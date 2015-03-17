
package com.eb.warehouse.io;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagicByteSlicingByteStreamConsumer extends ByteStreamBufferedByteConsumer {

  private static final Logger L = LoggerFactory.getLogger(MagicByteSlicingByteStreamConsumer.class);
  private final byte delimiter;
  private final ByteMessageListener listener;

  @Inject
  public MagicByteSlicingByteStreamConsumer(@Named("bufferSize") int bufferSize, byte delimiter, ByteMessageListener listener) {
    super(bufferSize);
    this.delimiter = delimiter;
    this.listener = listener;
  }

  /** {@inheritDoc} */
  @Override
  public void consumeByte(byte b) {
    if (getPosition() >= getInitialBufferSize()) {
      L.warn("Not found delimiterByte={} in stream before maximum buffer size={} exceeded. Reset byte consumer.", delimiter, getInitialBufferSize());
      resetPosition();
      super.consumeByte(b);

    } else if (b != delimiter) {
      // Just consume byte. We haven't reached max buffer size nor found a delimiter byte yet.
      super.consumeByte(b);

    } else {
      // Delimiter byte was found. Slice buffer excluding delimiter byte.
      byte[] newBuf = new byte[getPosition()];
      System.arraycopy(getBuffer(), 0, newBuf, 0, getPosition());
      listener.consumeMessage(newBuf);
      resetPosition();
    }
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
