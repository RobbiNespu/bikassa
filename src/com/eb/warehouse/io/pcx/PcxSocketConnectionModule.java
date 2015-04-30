package com.eb.warehouse.io.pcx;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Key;

import com.eb.warehouse.io.socket.AutoLifeSendSocketConnectionModule;
import com.eb.warehouse.io.socket.SocketConnection;
import com.eb.warehouse.io.socket.SocketEventBusBinding;
import com.eb.warehouse.util.EventBusRegistrationListener;
import com.eb.warehouse.util.SubclassesOf;

/**
 * Created by ebe on 24.03.2015.
 */
public class PcxSocketConnectionModule extends AbstractModule {

  private final Key<SocketConnection> socketConnectionBindingKey;
  private final EventBus socketEventBus = new EventBus();

  public PcxSocketConnectionModule(Key<SocketConnection> socketConnectionBindingKey) {
    this.socketConnectionBindingKey = socketConnectionBindingKey;
  }

  @Override
  protected void configure() {
    install(new AutoLifeSendSocketConnectionModule(socketEventBus));
    bind(socketConnectionBindingKey).to(PcxSocketConnection.class);
    bind(EventBus.class).annotatedWith(SocketEventBusBinding.class).toInstance(socketEventBus);
    bindListener(new SubclassesOf(PcxSocketConnection.class),
                 new EventBusRegistrationListener(socketEventBus));
  }
}
