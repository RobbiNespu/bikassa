
package com.eb.warehouse.io.pcx;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.inject.Named;

import com.eb.warehouse.io.ByteMessageListener;
import com.eb.warehouse.io.SendableConnectionService;
import com.eb.warehouse.io.XmlMessageListener;
import com.eb.warehouse.io.socket.PermanentSocketConnectionModule;
import com.eb.warehouse.util.EventBusRegistrationListener;
import com.eb.warehouse.util.NamedThreadFactory;
import com.eb.warehouse.util.Service2;
import com.eb.warehouse.util.SubclassesOf;
import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.inject.AbstractModule;
import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class PcxConnectionModule extends AbstractModule {

  private final int commandPort;
  private final int statusPort;
  private final Set<String> stationIds;
  private final String sendLifeMessageThreadName;
  private final EventBus eventBus = new EventBus();

  public PcxConnectionModule(int commandPort, int statusPort, Set<String> stationIds, String sendLifeMessageThreadName) {
    this.commandPort = commandPort;
    this.statusPort = statusPort;
    this.stationIds = stationIds;
    this.sendLifeMessageThreadName = sendLifeMessageThreadName;
  }

  /** {@inheritDoc} */
  @Override
  protected void configure() {
    bind(ByteMessageListener.class).to(XmlMessageListener.class);

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new PermanentSocketConnectionModule(commandPort) {
          @Override
          protected void configureBinding(Class<SendableConnectionService> def, Class<? extends SendableConnectionService> impl) {
            bind(def).annotatedWith(Names.named("commandConnection")).to(impl);
          }
        });
        expose(SendableConnectionService.class).annotatedWith(Names.named("commandConnection"));
      }
    });

    install(new PrivateModule() {
      @Override
      protected void configure() {
        install(new PermanentSocketConnectionModule(statusPort) {
          @Override
          protected void configureBinding(Class<SendableConnectionService> def, Class<? extends SendableConnectionService> impl) {
            bind(def).annotatedWith(Names.named("statusConnection")).to(impl);
          }
        });
        expose(SendableConnectionService.class).annotatedWith(Names.named("statusConnection"));
      }
    });

    bind(new TypeLiteral<Set<String>>() {
    }).toInstance(stationIds);

    bind(ThreadFactory.class).annotatedWith(Names.named("sendLifeMessageThreadFactory")).to(NamedThreadFactory.class);
    bind(String.class).annotatedWith(Names.named("threadName")).toInstance(sendLifeMessageThreadName);
    bind(EventBus.class).annotatedWith(Names.named("internal")).toInstance(eventBus);
    bindPcxConnection();

    bindListener(new SubclassesOf(PcxConnection.class), new EventBusRegistrationListener(eventBus));
  }

  protected void bindPcxConnection() {
    bind(Service2.class).to(PcxConnection.class);
  }

  @Provides
  @Named("sendLifeMessageService")
  ListeningScheduledExecutorService createLifeMessageSendService(@Named("sendLifeMessageThreadFactory") ThreadFactory threadFactory) {
    return MoreExecutors.listeningDecorator(Executors.newSingleThreadScheduledExecutor(threadFactory));
  }
}
