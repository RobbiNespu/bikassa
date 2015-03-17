
package com.eb.warehouse.io.pcx;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import javax.xml.bind.Marshaller;

import org.assertj.core.util.Sets;
import org.junit.Test;

import com.eb.warehouse.io.socket.PermanentSocketConnectionModuleTest;
import com.eb.warehouse.util.Service2;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class PcxConnectionModuleTest {

  @Test
  public void inject() {
    Injector injector =
      Guice.createInjector(new PcxConnectionModule(1, 2, Sets.<String> newHashSet(), "b"),
                           new PermanentSocketConnectionModuleTest.TestModule(),
                           new AbstractModule() {
                             @Override
                             protected void configure() {
                               bind(Marshaller.class).toInstance(mock(Marshaller.class));
                             }
                           });
    Service2 pcxConnection = injector.getInstance(Service2.class);
    assertNotNull(pcxConnection);
  }
}
