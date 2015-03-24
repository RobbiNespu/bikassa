
package com.eb.warehouse.io.pcx;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;

import com.eb.warehouse.io.socket.ReconnectingSocketConnectionModuleTest;

import org.assertj.core.util.Sets;
import org.junit.Test;

import javax.xml.bind.Marshaller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class PcxConnectionModuleTest {

  @Test
  public void inject() {
    Injector injector =
        Guice.createInjector(new PcxConnectionModule(1, 2, Sets.<String>newHashSet(), "b",
                                                     Key.get(PcxConnection.class)),
                           new ReconnectingSocketConnectionModuleTest.TestModule(),
                           new AbstractModule() {
                             @Override
                             protected void configure() {
                               bind(Marshaller.class).toInstance(mock(Marshaller.class));
                             }
                           });
    PcxConnection pcxConnection = injector.getInstance(PcxConnection.class);
    assertNotNull(pcxConnection);
  }
}
