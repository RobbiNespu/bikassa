package com.eb.warehouse.io.ngkp;

import com.eb.warehouse.io.ByteStreamBufferedByteConsumer;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

final class NgkpSlicingByteStreamConsumer extends ByteStreamBufferedByteConsumer {

  private Ngkp2Header currentProcessedHeader;

  public NgkpSlicingByteStreamConsumer(int initialBufferSize) {
    super(initialBufferSize);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void consumeByte(byte b) {
    super.consumeByte(b);

    if (currentProcessedHeader != null) {
      if (getPosition() > currentProcessedHeader.getTelegramLength()) {
        // We finished parsing the NGKPv2 payload
        byte[] payloadBytes = getBuffer();
        Ngkp2Telegram
            telegram =
            Ngkp2Telegram.fromHeaderAndBytes(currentProcessedHeader, payloadBytes, 0);
        System.out.println("NGKP arrived!! " + telegram);
        currentProcessedHeader = null;
        resetPosition();
      }
    } else if (getPosition() == 10) {
      byte[] headerBytes = getBuffer();
      int expectedChecksum = CRC16.calculate(headerBytes, 0, 8);
      byte lsb = headerBytes[8];
      byte msb = headerBytes[9];
      int actualChecksum = ((msb & 0xFF) << 8) | (lsb & 0xFF);
      if (expectedChecksum == actualChecksum) {
        // We received a correct NGKPv2 header
        currentProcessedHeader = Ngkp2Header.fromBytes(headerBytes);
      }

      resetPosition();
    }
  }

}