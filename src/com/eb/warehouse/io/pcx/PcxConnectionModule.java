package com.eb.warehouse.io.pcx;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import com.eb.warehouse.io.ByteMessageListener;
import com.eb.warehouse.io.ByteStreamConsumer;
import com.eb.warehouse.io.MagicByteSlicingByteStreamConsumer;
import com.eb.warehouse.io.SocketConnection;
import com.eb.warehouse.io.XmlMessageListener;

import java.util.Set;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class PcxConnectionModule extends AbstractModule {

  private static final Key<SocketConnection>
      COMMAND_CONNECTION_KEY =
      Key.get(SocketConnection.class, Names.named("command"));
  private static final Key<SocketConnection>
      STATUS_CONNECTION_KEY =
      Key.get(SocketConnection.class, Names.named("status"));
  private final int commandPort;
  private final int statusPort;
  private final Set<String> stationIds;
  private final String connectionName;
  private final Key<PcxConnection> pcxConnectionBindingKey;

  public PcxConnectionModule(int commandPort, int statusPort, Set<String> stationIds,
                             String sendLifeMessageThreadName,
                             Key<PcxConnection> pcxConnectionBindingKey) {
    this.commandPort = commandPort;
    this.statusPort = statusPort;
    this.stationIds = stationIds;
    this.connectionName = sendLifeMessageThreadName;
    this.pcxConnectionBindingKey = pcxConnectionBindingKey;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    bind(ByteMessageListener.class).to(XmlMessageListener.class);
    bind(ByteStreamConsumer.class).to(MagicByteSlicingByteStreamConsumer.class);

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new PcxSocketConnectionModule(commandPort, connectionName + "-cmd-life",
                                              COMMAND_CONNECTION_KEY));
        expose(COMMAND_CONNECTION_KEY);
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new PcxSocketConnectionModule(statusPort, connectionName + "-status-life",
                                              STATUS_CONNECTION_KEY));
        expose(STATUS_CONNECTION_KEY);
      }
    });

    bind(new TypeLiteral<Set<String>>() {
    }).toInstance(stationIds);

    bind(pcxConnectionBindingKey).to(PcxConnectionImpl.class);
  }
}
