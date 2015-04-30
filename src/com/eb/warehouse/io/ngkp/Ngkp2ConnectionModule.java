package com.eb.warehouse.io.ngkp;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.name.Names;

import com.eb.warehouse.io.ByteMessageListener;
import com.eb.warehouse.io.ByteStreamConsumer;
import com.eb.warehouse.io.socket.AutoConnectSocketConnectionModule;
import com.eb.warehouse.io.socket.AutoLifeSendSocketConnectionModule;
import com.eb.warehouse.io.socket.PortBinding;
import com.eb.warehouse.io.socket.SocketConnection;
import com.eb.warehouse.io.socket.SocketEventBusBinding;
import com.eb.warehouse.util.EventBusRegistrationListener;
import com.eb.warehouse.util.SubclassesOf;
import com.eb.warehouse.util.ThreadNameBinding;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class Ngkp2ConnectionModule extends AbstractModule {

  public static final String TELEGRAM_EVENTS_BINDING_NAME = "telegramEvents";
  private static final Key<SocketConnection> SENDER_CONN_KEY = Key.get(SocketConnection.class,
                                                                       Names.named(
                                                                           Ngkp2ConnectionImpl.SENDER_CONN_BINDING_NAME));
  private static final Key<SocketConnection> RECEIVER_CONN_KEY = Key.get(SocketConnection.class,
                                                                         Names.named(
                                                                             Ngkp2ConnectionImpl.RECEIVER_CONN_BINDING_NAME));
  private final int senderPort;
  private final int receiverPort;
  private final Key<Ngkp2Connection> bindingKey;

  public Ngkp2ConnectionModule(int senderPort, int receiverPort, Key<Ngkp2Connection> bindingKey) {
    this.senderPort = senderPort;
    this.receiverPort = receiverPort;
    this.bindingKey = bindingKey;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    bind(bindingKey).to(Ngkp2ConnectionImpl.class);

    install(new PrivateModule() {
      @Override
      protected void configure() {
        EventBus socketEvents = new EventBus();
        EventBus telegramEvents = new EventBus();
        bind(EventBus.class).annotatedWith(SocketEventBusBinding.class).toInstance(socketEvents);
        bind(EventBus.class).annotatedWith(Names.named(TELEGRAM_EVENTS_BINDING_NAME)).toInstance(
            telegramEvents);
        bindListener(new SubclassesOf(Ngkp2SenderSocketConnection.class),
                     new EventBusRegistrationListener(socketEvents));
        bindListener(new SubclassesOf(Ngkp2SenderSocketConnection.class),
                     new EventBusRegistrationListener(telegramEvents));

        bind(ByteMessageListener.class).to(Ngkp2MessageParser.class);
        bind(ByteStreamConsumer.class).to(Ngkp2SlicingByteStreamConsumer.class);
        bind(Integer.class).annotatedWith(PortBinding.class).toInstance(senderPort);
        bind(String.class).annotatedWith(ThreadNameBinding.class).toInstance("life-sender");

        bind(SENDER_CONN_KEY).to(Ngkp2SenderSocketConnection.class);
        install(new AutoLifeSendSocketConnectionModule(socketEvents));
        expose(SENDER_CONN_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        EventBus telegramEvents = new EventBus();
        bind(EventBus.class).annotatedWith(SocketEventBusBinding.class).toInstance(new EventBus());
        bind(EventBus.class).annotatedWith(Names.named(TELEGRAM_EVENTS_BINDING_NAME)).toInstance(
            telegramEvents);
        bindListener(new SubclassesOf(Ngkp2ReceiverSocketConnection.class),
                     new EventBusRegistrationListener(telegramEvents));

        bind(ByteMessageListener.class).to(Ngkp2MessageParser.class);
        bind(ByteStreamConsumer.class).to(Ngkp2SlicingByteStreamConsumer.class);
        bind(Integer.class).annotatedWith(PortBinding.class).toInstance(receiverPort);

        bind(RECEIVER_CONN_KEY).to(Ngkp2ReceiverSocketConnection.class);
        install(new AutoConnectSocketConnectionModule());
        expose(RECEIVER_CONN_KEY);
      }
    });
  }

}