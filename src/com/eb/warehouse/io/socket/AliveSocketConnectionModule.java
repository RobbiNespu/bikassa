package com.eb.warehouse.io.socket;

import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.util.EventBusRegistrationListener;
import com.eb.warehouse.util.NamedThreadFactoryModule;
import com.eb.warehouse.util.SubclassesOf;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.inject.Named;

/**
 * Created by ebe on 24.03.2015.
 */
public class AliveSocketConnectionModule extends AbstractModule {

  private static final Key<ListeningScheduledExecutorService>
      LIFE_SENDER_KEY =
      Key.get(ListeningScheduledExecutorService.class,
              Names.named(AliveSocketConnection.SEND_LIFE_SCHEDULED_EXECUTOR_SERVICE_BINDING_NAME));
  private final int port;
  private final String sendLifeMessageThreadName;
  private final EventBus socketEventBus;

  public AliveSocketConnectionModule(int port, String sendLifeMessageThreadName,
                                     EventBus socketEventBus) {
    this.port = port;
    this.sendLifeMessageThreadName = sendLifeMessageThreadName;
    this.socketEventBus = socketEventBus;
  }

  @Override
  protected void configure() {
    install(new PrivateModule() {
      @Override
      protected void configure() {
        bind(String.class).annotatedWith(Names.named("threadName"))
            .toInstance(sendLifeMessageThreadName);
        install(new NamedThreadFactoryModule());
        expose(LIFE_SENDER_KEY);
      }

      @Provides
      @Named(AliveSocketConnection.SEND_LIFE_SCHEDULED_EXECUTOR_SERVICE_BINDING_NAME)
      ListeningScheduledExecutorService createLifeMessageSendService(ThreadFactory threadFactory) {
        return MoreExecutors.listeningDecorator(Executors
                                                    .newSingleThreadScheduledExecutor(
                                                        threadFactory));
      }
    });

    install(
        new PermanentSocketConnectionModule(port, socketEventBus, Key.get(SocketConnection.class,
                                                                          Names.named(
                                                                              "immediateSender")),
                                            AliveSocketConnection.class));
    bind(SocketConnection.class).annotatedWith(Names.named("aliveSender"))
        .to(AliveSocketConnection.class);

    bindListener(new SubclassesOf(AliveSocketConnection.class),
                 new EventBusRegistrationListener(socketEventBus));
  }
}
