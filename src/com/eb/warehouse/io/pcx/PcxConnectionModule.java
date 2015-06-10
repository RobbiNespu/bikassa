package com.eb.warehouse.io.pcx;

import com.eb.warehouse.io.ByteMessageListener;
import com.eb.warehouse.io.ByteStreamConsumer;
import com.eb.warehouse.io.MagicByteSlicingByteStreamConsumer;
import com.eb.warehouse.io.XmlMessageListener;
import com.eb.warehouse.io.socket.AutoConnectSocketConnectionModule;
import com.eb.warehouse.io.socket.AutoLifeSendSocketConnectionModule;
import com.eb.warehouse.io.socket.PortBinding;
import com.eb.warehouse.io.socket.SocketConnection;
import com.google.inject.*;
import com.google.inject.name.Names;

import javax.inject.Named;
import java.util.Set;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public final class PcxConnectionModule extends AbstractModule {

    private static final String COMMAND_PORT_BINDING = "command-port";
    private static final String STATUS_PORT_BINDING = "status-port";
    private static final String CONNECTION_NAME_BINDING = "connection-name";
    private static final Key<SocketConnection>
            COMMAND_CONNECTION_KEY =
            Key.get(SocketConnection.class, PcxCommandConnectionBinding.class);
    private static final Key<SocketConnection>
            STATUS_CONNECTION_KEY =
            Key.get(SocketConnection.class, PcxStatusConnectionBinding.class);
    private final Key<PcxConnection> pcxConnectionBindingKey;

    public PcxConnectionModule(Key<PcxConnection> pcxConnectionBindingKey) {
        this.pcxConnectionBindingKey = pcxConnectionBindingKey;
    }

    public static void bindParameters(Binder binder, int cmdPort, int statusPort, String connName,
                                      Set<String> targetStationIds) {
        binder.bind(Integer.class).annotatedWith(Names.named(PcxConnectionModule.COMMAND_PORT_BINDING))
                .toInstance(cmdPort);
        binder.bind(Integer.class).annotatedWith(Names.named(PcxConnectionModule.STATUS_PORT_BINDING))
                .toInstance(statusPort);
        binder.bind(String.class)
                .annotatedWith(Names.named(PcxConnectionModule.CONNECTION_NAME_BINDING))
                .toInstance(connName);
        binder.bind(new TypeLiteral<Set<String>>() {
        }).toInstance(targetStationIds);
    }

    @Override
    protected void configure() {
        bind(ByteMessageListener.class).to(XmlMessageListener.class);
        bind(ByteStreamConsumer.class).to(MagicByteSlicingByteStreamConsumer.class);
        bind(pcxConnectionBindingKey).to(PcxConnectionImpl.class);

        install(new PrivateModule() {
            @Override
            protected void configure() {
                install(new PcxSocketConnectionModule(COMMAND_CONNECTION_KEY));
                expose(COMMAND_CONNECTION_KEY);
            }

            @Provides
            @PortBinding
            int providePort(@Named(COMMAND_PORT_BINDING) int port) {
                return port;
            }

            @Provides
            @Named(AutoLifeSendSocketConnectionModule.LIFE_SEND_THREAD_NAME_BINDING)
            String provideLifeSendThreadName(@Named(CONNECTION_NAME_BINDING) String connectionName) {
                return connectionName + "-cmd-life";
            }

            @Provides
            @Named(AutoConnectSocketConnectionModule.CONNECT_READ_SOCKET_THREAD_NAME_BINDING)
            String provideConnectReadThreadName(@Named(CONNECTION_NAME_BINDING) String connectionName) {
                return connectionName + "-cmd-reader";
            }
        });

        install(new PrivateModule() {
            @Override
            protected void configure() {
                install(new PcxSocketConnectionModule(STATUS_CONNECTION_KEY));
                expose(STATUS_CONNECTION_KEY);
            }

            @Provides
            @PortBinding
            int providePort(@Named(STATUS_PORT_BINDING) int port) {
                return port;
            }

            @Provides
            @Named(AutoLifeSendSocketConnectionModule.LIFE_SEND_THREAD_NAME_BINDING)
            String provideLifeSendThreadName(@Named(CONNECTION_NAME_BINDING) String connectionName) {
                return connectionName + "-status-life";
            }

            @Provides
            @Named(AutoConnectSocketConnectionModule.CONNECT_READ_SOCKET_THREAD_NAME_BINDING)
            String provideConnectReadThreadName(@Named(CONNECTION_NAME_BINDING) String connectionName) {
                return connectionName + "-status-reader";
            }
        });
    }
}
