package com.eb.warehouse.io.pcx;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.name.Names;

import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.io.socket.AutoConnectSocketConnectionModule;
import com.eb.warehouse.io.socket.AutoLifeSendSocketConnectionModule;
import com.eb.warehouse.util.EventBusRegistrationListener;
import com.eb.warehouse.util.SubclassesOf;

/**
 * Created by ebe on 24.03.2015.
 */
public class PcxSocketConnectionModule extends AbstractModule {

  private final int port;
  private final String sendLifeMessageThreadName;
  private final Key<SocketConnection> socketConnectionBindingKey;
  private final EventBus socketEventBus = new EventBus();

  public PcxSocketConnectionModule(int port, String sendLifeMessageThreadName,
                                   Key<SocketConnection> socketConnectionBindingKey) {
    this.port = port;
    this.sendLifeMessageThreadName = sendLifeMessageThreadName;
    this.socketConnectionBindingKey = socketConnectionBindingKey;
  }

  @Override
  protected void configure() {
    install(
        new AutoLifeSendSocketConnectionModule(port, sendLifeMessageThreadName, socketEventBus));
    bind(socketConnectionBindingKey).to(PcxSocketConnection.class);
    bind(EventBus.class)
        .annotatedWith(Names.named(AutoConnectSocketConnectionModule.SOCKET_EVENTS_BINDING_NAME))
        .toInstance(socketEventBus);
    bindListener(new SubclassesOf(PcxSocketConnection.class),
                 new EventBusRegistrationListener(socketEventBus));
  }
}
