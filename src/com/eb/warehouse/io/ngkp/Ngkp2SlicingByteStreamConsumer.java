package com.eb.warehouse.io.ngkp;

import com.eb.warehouse.io.ByteMessageListener;
import com.eb.warehouse.io.ByteStreamBufferedByteConsumer;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

final class Ngkp2SlicingByteStreamConsumer extends ByteStreamBufferedByteConsumer {

  private final ByteMessageListener listener;
  private int telegramLength = -1;

  @Inject
  public Ngkp2SlicingByteStreamConsumer(@Named("bufferSize") int initialBufferSize,
                                        ByteMessageListener listener) {
    super(initialBufferSize);
    this.listener = listener;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void consumeByte(byte b) {
    super.consumeByte(b);

    if (getPosition() == 10) {
      byte[] headerBytes = getBuffer();
      int expectedChecksum = CRC16.calculate(headerBytes, 0, 8);
      byte lsb = headerBytes[8];
      byte msb = headerBytes[9];
      int actualChecksum = ((msb & 0xFF) << 8) | (lsb & 0xFF);
      if (expectedChecksum == actualChecksum) {
        // We received a correct NGKPv2 header
        telegramLength = Bytes2.shortFromBytes(headerBytes[0], headerBytes[1]);
      } else {
        resetPosition();
      }
    }

    if (getPosition() == telegramLength) {
      int bufferLen = getBuffer().length;
      byte[] copiedBuffer = new byte[bufferLen];
      // We finished reading the NGKPv2 telegram
      System.arraycopy(getBuffer(), 0, copiedBuffer, 0, bufferLen);
      listener.consumeMessage(getBuffer());
      resetPosition();
      telegramLength = -1;
    }
  }

}
