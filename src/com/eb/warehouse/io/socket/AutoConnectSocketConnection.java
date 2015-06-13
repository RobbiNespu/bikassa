package com.eb.warehouse.io.socket;

import com.eb.warehouse.util.SelfCallable;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/**
 * <p> Socket connection that tries to be connected to the socket as long as the connection is
 * running. Reconnect is triggered either if {@link #writeToSocket(byte[])} throws an exception or a
 * previous connect to the socket failed.</p>
 */
final class AutoConnectSocketConnection extends AbstractIdleService implements SocketConnection {

    private static final Logger L = LoggerFactory.getLogger(AutoConnectSocketConnection.class);
    private final String hostname;
    private final int port;
    private final SelfCallable<Socket> connectSocketTask;
    private final ReadSocketTaskFactory readSocketTaskFactory;
    private final EventBus socketConnectEvents;
    private final FutureCallback<Socket> connectCallback;
    private final FutureCallback<Void> readCallback;
    private final ListeningExecutorService connectAndReadExecService;
    // private ConnectionStatsCounter statsCounter;
    private volatile boolean running;
    private volatile Socket socket;
    private ListenableFuture<Socket> connectFuture;
    private ListenableFuture<Void> readFuture;

    @Inject
    AutoConnectSocketConnection(@HostnameBinding String hostname,
                                @PortBinding int port,
                                @ConnectAndReadSocketExecServiceBinding ListeningExecutorService connectAndReadExecService,
                                SelfCallable<Socket> connectSocketTask,
                                ReadSocketTaskFactory readSocketTaskFactory,
                                @SocketEventBusBinding EventBus socketConnectEvents) {
        this.hostname = hostname;
        this.port = port;
        this.connectAndReadExecService = connectAndReadExecService;
        this.connectSocketTask = connectSocketTask;
        this.readSocketTaskFactory = readSocketTaskFactory;
        this.socketConnectEvents = socketConnectEvents;
        connectCallback = new ConnectSocketCallback();
        readCallback = new ReadSocketCallback();
    }

    AutoConnectSocketConnection(String hostname,
                                int port,
                                ListeningExecutorService connectAndReadExecService,
                                SelfCallable<Socket> connectSocketTask,
                                ReadSocketTaskFactory readSocketTaskFactory,
                                EventBus socketConnectEvents,
                                FutureCallback<Socket> connectCallback,
                                FutureCallback<Void> readCallback) {
        this.hostname = hostname;
        this.port = port;
        this.connectAndReadExecService = connectAndReadExecService;
        this.connectSocketTask = connectSocketTask;
        this.readSocketTaskFactory = readSocketTaskFactory;
        this.socketConnectEvents = socketConnectEvents;
        this.connectCallback = connectCallback;
        this.readCallback = readCallback;
    }

    @Override
    protected void startUp() throws Exception {
        connectAsync();
    }

    private void connectAsync() {
        connectFuture = connectSocketTask.submitTo(connectAndReadExecService);
        Futures.addCallback(connectFuture, connectCallback);
    }

    private void closeOldSocketAndReconnectAsync() {
        if (connectFuture.isCancelled() || connectFuture.isDone()) {
            Sockets.closeQuietly(socket);
            connectAsync();
        }
    }

    @Override
    protected void shutDown() throws Exception {
        L.trace("Stopping auto-connecting socket connection.");
        if (connectFuture != null) {
            connectFuture.cancel(true);
            L.trace("Cancelling connectFuture={}.", connectFuture);
        }
        Sockets.closeQuietly(socket);
        try {
            if (connectFuture != null) {
                connectFuture.get();
            }
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        } catch (CancellationException e) {
        }
        L.trace("Stopped auto-connecting socket connection.");
    }

    @Override
    public String getHostname() {
        return hostname;
    }

    @Override
    public int getPort() {
        return port;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToSocket(byte[] bytes) throws IOException {
        L.trace("Try writing bytes={} to socket={} output stream.", bytes, socket);
        if (socket == null) {
            throw new IOException(
                    "Cannot write to socket. Called 'startAsync2()'.");
        }
        if (!connectFuture.isDone()) {
            throw new IOException(
                    "Cannot write to socket. Still connecting to it.");
        }

        try {
            socket.getOutputStream().write(bytes);
            // statsCounter.incrementSentBytes(bytes.length);
            L.trace("Wrote bytes successfully to socket output stream.");
        } catch (IOException e) {
            closeOldSocketAndReconnectAsync();
            throw e;
        }
    }

    /**
     * Inject a socket and ListenableFuture for testing. The future is the handle to the in-progress
     * process of connecting the socket.
     */
    @VisibleForTesting
    void setSocketAndConnecting(Socket socket, ListenableFuture<Socket> connectFuture) {
        this.socket = socket;
        this.connectFuture = connectFuture;
    }

    final class ConnectSocketCallback implements FutureCallback<Socket> {

        @Override
        public void onSuccess(Socket connected) {
            socket = connected;
            try {
                Callable<Void> readTask =
                        readSocketTaskFactory.createReadSocketInputStreamTask(connected.getInputStream());
                readFuture = connectAndReadExecService.submit(readTask);
                Futures.addCallback(readFuture, readCallback);
                socketConnectEvents.post(new SocketConnectedEvent());
            } catch (IOException e) {
                closeOldSocketAndReconnectAsync();
            } catch (RuntimeException e) {
                L.error("Must never show up in log.", e);
            }
        }

        @Override
        public void onFailure(Throwable t) {
            // Fails only if task throws InterruptedException, future cancels the task and throws CancellationException
            // or underyling socket gets closed.
        }
    }

    final class ReadSocketCallback implements FutureCallback<Void> {

        @Override
        public void onSuccess(Void none) {
            // Executes if remote host closes socket --> EOF reached at input stream.
            closeOldSocketAndReconnectAsync();
        }

        @Override
        public void onFailure(Throwable t) {
            // May only execute if it's an IOException
            closeOldSocketAndReconnectAsync();
        }
    }
}
