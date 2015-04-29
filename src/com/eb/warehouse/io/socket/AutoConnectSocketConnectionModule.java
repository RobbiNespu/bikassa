package com.eb.warehouse.io.socket;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;

import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.util.NamedThreadFactory;
import com.eb.warehouse.util.NamedThreadFactoryModule;

import java.net.InetSocketAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class AutoConnectSocketConnectionModule extends AbstractModule {

  public static final String SOCKET_EVENTS_BINDING_NAME = "socketEvents";
  public static final String AUTO_CONNECT_SOCKET_CONN_BINDING_NAME = "autoConnect";
  private static final Key<ListeningExecutorService>
      CONNECT_AND_READ_SOCKET_KEY =
      Key.get(ListeningExecutorService.class, Names
          .named(AutoConnectSocketConnection.CONNECT_AND_READ_EXECUTOR_SERVICE_NAME_BINDING));
  private final int port;
  private final Key<SocketConnection> socketConnectionBindingKey;

  public AutoConnectSocketConnectionModule(int port,
                                           Key<SocketConnection> socketConnectionBindingKey) {
    this.port = port;
    this.socketConnectionBindingKey = socketConnectionBindingKey;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    bind(socketConnectionBindingKey).to(AutoConnectSocketConnection.class);
    bind(ConnectSocketTask.class).to(ConnectSocketTaskImpl.class);
    install(new FactoryModuleBuilder().implement(new TypeLiteral<Callable<Void>>() {
                                                 },
                                                 ReadSocketTask.class)
                .build(ReadSocketTaskFactory.class));

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new NamedThreadFactoryModule());
        expose(CONNECT_AND_READ_SOCKET_KEY);
      }

      @Provides
      @Named(NamedThreadFactory.THREAD_NAME_BINDING_NAME)
      String createReaderThreadName(@Named("hostname") String hostname, @Named("port") int port) {
        return hostname + ":" + port + "-reader";
      }

      @Provides
      @Named(AutoConnectSocketConnection.CONNECT_AND_READ_EXECUTOR_SERVICE_NAME_BINDING)
      ListeningExecutorService createConnectAndReadRunner(ThreadFactory threadFactory) {
        return MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor(threadFactory));
      }
    });

    bind(Integer.class).annotatedWith(Names.named("port")).toInstance(port);
    bind(Integer.class).annotatedWith(Names.named("reconnectDelay")).toInstance(7);
    bind(TimeUnit.class).annotatedWith(Names.named("reconnectDelayTimeUnit")).toInstance(
        TimeUnit.SECONDS);
  }

  @Provides
  InetSocketAddress createSocketAddress(@Named("hostname") String hostname,
                                        @Named("port") int port) {
    return new InetSocketAddress(hostname, port);
  }
}
