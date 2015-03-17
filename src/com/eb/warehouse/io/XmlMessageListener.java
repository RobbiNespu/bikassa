
package com.eb.warehouse.io;

import java.io.ByteArrayInputStream;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.eventbus.EventBus;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public final class XmlMessageListener implements ByteMessageListener {

  private static final Logger L = LoggerFactory.getLogger(XmlMessageListener.class);
  private final Unmarshaller unmarshaller;
  private final EventBus incomingEventBus;

  @Inject
  public XmlMessageListener(Unmarshaller unmarshaller, @Named("incoming") EventBus incomingEventBus) {
    this.unmarshaller = unmarshaller;
    this.incomingEventBus = incomingEventBus;
  }

  /** {@inheritDoc} */
  @Override
  public void consumeMessage(byte[] buffer) {
    ByteArrayInputStream is = new ByteArrayInputStream(buffer);
    try {
      L.debug("Try unmarshalling XML string={} into object.", new String(buffer, Charsets.UTF_8));
      Object msg = unmarshaller.unmarshal(is);
      L.debug("Post incoming event={} to eventBusId={}.", msg, incomingEventBus.hashCode());
      incomingEventBus.post(msg);
    } catch (JAXBException e) {
    }
  }
}
