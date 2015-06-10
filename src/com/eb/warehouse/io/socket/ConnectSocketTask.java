package com.eb.warehouse.io.socket;

import com.eb.warehouse.util.SelfCallable;
import com.eb.warehouse.util.ThreadWrapper;
import com.google.common.base.MoreObjects;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * Task that tries to connect a socket to an address. <p>If connect fails it tries again until a
 * connection is established successfully or the task has been interrupted.</p> <p>This class takes
 * care of releasing socket resources if connect failed. Once the connection is established the
 * socket instance is handed over and freeing the socket when going out of scope is the callee's
 * responsibility.</p>
 */
final class ConnectSocketTask implements SelfCallable<Socket> {

    private static final Logger L = LoggerFactory.getLogger(ConnectSocketTask.class);
    private final Provider<Socket> socketProvider;
    private final InetSocketAddress address;
    private final int reconnectDelay;
    private final TimeUnit reconnectDelayUnit;
    private final ThreadWrapper thread;
    //  private ConnectionStatsCounter statsCounter;
    private Socket socket;

    @Inject
    ConnectSocketTask(Provider<Socket> socketProvider, InetSocketAddress address,
                      @Named(NamedBindings.RECONNECT_DELAY_BINDING) int reconnectDelay,
                      @Named(NamedBindings.RECONNECT_DELAY_TIME_UNIT_BINDING) TimeUnit reconnectDelayTimeUnit) {
        this.socketProvider = socketProvider;
        this.address = address;
        this.reconnectDelay = reconnectDelay;
        reconnectDelayUnit = reconnectDelayTimeUnit;
        thread = ThreadWrapper.REAL;
    }

    ConnectSocketTask(Provider<Socket> socketProvider, InetSocketAddress address,
                      ThreadWrapper thread) {
        this.socketProvider = socketProvider;
        this.address = address;
        reconnectDelay = 0;
        reconnectDelayUnit = TimeUnit.SECONDS;
        this.thread = thread;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Socket call() throws Exception {
        do {
            try {
                if (socket != null) {
                    // Sleep before trying to connect again and again.
                    L.debug("Try reconnect socket after {} {}.", reconnectDelay,
                            reconnectDelayUnit.toString().toLowerCase());
                    thread.sleep2(reconnectDelay, reconnectDelayUnit);
                }

                socket = socketProvider.get();
                //        statsCounter.incrementSocketConnectAttempts();
                socket.connect(address);
                //        statsCounter.incrementSuccessfulSocketConnects();
                L.info("Connected socket={}.", socket);
                Socket handOver = socket;
                socket = null;
                return handOver;
            } catch (IOException e) {
                L.debug("Failed connect socket to address={}.", address);
                Sockets.closeQuietly(socket);
                //        statsCounter.incrementFailedSocketConnects();
                if (thread.isInterruptedAndReset(true)) {
                    throw new InterruptedException();
                }
            }
        } while (true);
    }

    @Override
    public ListenableFuture<Socket> submitTo(final ListeningExecutorService runner) {
        final ListenableFuture<Socket> wrapped = runner.submit(this);
        ForwardingListenableFuture<Socket>
                future =
                new ForwardingListenableFuture<Socket>() {
                    @Override
                    protected ListenableFuture<Socket> delegate() {
                        return wrapped;
                    }

                    @Override
                    public boolean cancel(boolean mayInterruptIfRunning) {
                        Sockets.closeQuietly(socket);
                        return super.cancel(mayInterruptIfRunning);
                    }

                    @Override
                    public String toString() {
                        return "CancelInterceptingFuture{address=" + address + "}";
                    }
                };
        return future;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("address", address).add("reconnectDelay", reconnectDelay)
                .add("reconnectDelayUnit", reconnectDelayUnit).toString();
    }
}
