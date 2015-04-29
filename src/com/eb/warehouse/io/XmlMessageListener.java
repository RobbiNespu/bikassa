package com.eb.warehouse.io;

import com.google.common.base.Charsets;

import com.eb.warehouse.util.EventConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public final class XmlMessageListener implements ByteMessageListener {

  private static final Logger L = LoggerFactory.getLogger(XmlMessageListener.class);
  private final Unmarshaller unmarshaller;
  private final EventConsumer eventConsumer;

  @Inject
  public XmlMessageListener(Unmarshaller unmarshaller,
                            EventConsumer eventConsumer) {
    this.unmarshaller = unmarshaller;
    this.eventConsumer = eventConsumer;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void consumeMessage(byte[] buffer) {
    ByteArrayInputStream is = new ByteArrayInputStream(buffer);
    try {
      L.trace("Try unmarshalling XML string={} into object.", new String(buffer, Charsets.UTF_8));
      Object msg = unmarshaller.unmarshal(is);
      eventConsumer.onEvent(msg);
    } catch (JAXBException e) {
      L.debug("Not unmarshalled XML string into object.", e);
    }
  }
}
