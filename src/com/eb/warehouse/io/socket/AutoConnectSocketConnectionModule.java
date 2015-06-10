package com.eb.warehouse.io.socket;

import com.eb.warehouse.util.NamedThreadFactoryModule;
import com.eb.warehouse.util.SelfCallable;
import com.eb.warehouse.util.ThreadNameBinding;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.*;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;

import javax.inject.Named;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class AutoConnectSocketConnectionModule extends AbstractModule {

    public static final String
            CONNECT_READ_SOCKET_THREAD_NAME_BINDING =
            "connect-read-socket-thread-name";
    private static final Key<ListeningExecutorService>
            CONNECT_AND_READ_SOCKET_KEY =
            Key.get(ListeningExecutorService.class, ConnectAndReadSocketExecServiceBinding.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configure() {
        bind(SocketConnection.class).annotatedWith(AutoConnectSocketConnectionBinding.class).to(
                AutoConnectSocketConnection.class);
        bind(new TypeLiteral<SelfCallable<Socket>>() {
        }).to(ConnectSocketTask.class);
        install(new FactoryModuleBuilder().implement(new TypeLiteral<Callable<Void>>() {
        }, ReadSocketTask.class).build(ReadSocketTaskFactory.class));

        install(new PrivateModule() {
            @Override
            protected void configure() {
                install(new NamedThreadFactoryModule());
                expose(CONNECT_AND_READ_SOCKET_KEY);
            }

            @Provides
            @ThreadNameBinding
            String provideReaderThreadName(
                    @Named(CONNECT_READ_SOCKET_THREAD_NAME_BINDING) String threadName) {
                return threadName;
            }

            @Provides
            @ConnectAndReadSocketExecServiceBinding
            ListeningExecutorService provideConnectAndExecService(ThreadFactory threadFactory) {
                return MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor(threadFactory));
            }
        });

        bind(Integer.class).annotatedWith(Names.named(NamedBindings.RECONNECT_DELAY_BINDING))
                .toInstance(7);
        bind(TimeUnit.class).annotatedWith(Names.named(NamedBindings.RECONNECT_DELAY_TIME_UNIT_BINDING))
                .toInstance(
                        TimeUnit.SECONDS);
    }

    @Provides
    InetSocketAddress provideSocketAddress(@HostnameBinding String hostname,
                                           @PortBinding int port) {
        return new InetSocketAddress(hostname, port);
    }
}
