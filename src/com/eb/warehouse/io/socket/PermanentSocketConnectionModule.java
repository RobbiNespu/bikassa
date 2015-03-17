
package com.eb.warehouse.io.socket;

import java.net.InetSocketAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import com.eb.warehouse.io.ByteStreamConsumer;
import com.eb.warehouse.io.MagicByteSlicingByteStreamConsumer;
import com.eb.warehouse.io.SendableConnectionService;
import com.eb.warehouse.util.NamedThreadFactory;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class PermanentSocketConnectionModule extends AbstractModule {

  private final int port;

  public PermanentSocketConnectionModule(int port) {
    this.port = port;
  }

  /** {@inheritDoc} */
  @Override
  protected void configure() {
    configureBinding(SendableConnectionService.class, PermanentSocketConnection.class);
    bind(ConnectSocketTask.class).to(RecurringConnectSocketTask.class);
    install(new FactoryModuleBuilder().implement(new TypeLiteral<Callable<Void>>() {
    }, ReadSocketTask.class).build(ReadSocketTaskFactory.class));
    bind(ByteStreamConsumer.class).to(MagicByteSlicingByteStreamConsumer.class);
    bind(ThreadFactory.class).annotatedWith(Names.named("connectAndReadSocketThreadFactory")).to(NamedThreadFactory.class);
    bind(Integer.class).annotatedWith(Names.named("port")).toInstance(port);
    bind(Integer.class).annotatedWith(Names.named("reconnectDelay")).toInstance(7);
    bind(TimeUnit.class).annotatedWith(Names.named("reconnectDelayTimeUnit")).toInstance(TimeUnit.SECONDS);
  }

  @Provides
  InetSocketAddress createSocketAddress(@Named("hostname") String hostname, @Named("port") int port) {
    return new InetSocketAddress(hostname, port);
  }

  @Provides
  @Named("readerThreadName")
  String createReaderThreadName(@Named("hostname") String hostname, @Named("port") int port) {
    return hostname + ":" + port + "-reader";
  }

  @Provides
  ListeningExecutorService createConnectAndReadRunner(@Named("connectAndReadSocketThreadFactory") ThreadFactory threadFactory) {
    return MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor(threadFactory));
  }

  protected void configureBinding(Class<SendableConnectionService> def, Class<? extends SendableConnectionService> impl) {
    bind(def).to(impl);
  }

}
