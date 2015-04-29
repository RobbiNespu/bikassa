package com.eb.warehouse.io.socket;

import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;

import com.eb.warehouse.util.ThreadDelegator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

final class ConnectSocketTaskImpl implements ConnectSocketTask {

  private static final Logger L = LoggerFactory.getLogger(ConnectSocketTaskImpl.class);
  private final Provider<Socket> socketProvider;
  private final InetSocketAddress address;
  private final int reconnectDelay;
  private final TimeUnit reconnectDelayUnit;
  private final ThreadDelegator thread;
  //  private ConnectionStatsCounter statsCounter;
  private Socket socket;

  @Inject
  ConnectSocketTaskImpl(Provider<Socket> socketProvider, InetSocketAddress address,
                        @Named("reconnectDelay") int reconnectDelay,
                        @Named("reconnectDelayTimeUnit") TimeUnit reconnectDelayTimeUnit) {
    this.socketProvider = socketProvider;
    this.address = address;
    this.reconnectDelay = reconnectDelay;
    reconnectDelayUnit = reconnectDelayTimeUnit;
    thread = ThreadDelegator.REAL;
  }

  ConnectSocketTaskImpl(Provider<Socket> socketProvider, InetSocketAddress address,
                        ThreadDelegator thread) {
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
          thread.sleepCurrentThread(reconnectDelay, reconnectDelayUnit);
        }

        socket = socketProvider.get();
        //        statsCounter.incrementSocketConnectAttempts();
        socket.connect(address);
        //        statsCounter.incrementSuccessfulSocketConnects();
        L.info("Connected socket={}.", socket);
        return socket;
      } catch (IOException e) {
        L.debug("Failed connect socket to address={}.", address);
        Sockets.closeQuietly(socket);
        //        statsCounter.incrementFailedSocketConnects();
        if (thread.isCurrentThreadInterrupted(true)) {
          throw new InterruptedException();
        }
      }
    } while (true);
  }

  /**
   * TODO JavaDoc according to WAMAS C conventions
   */
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
        };
    return future;
  }
}
