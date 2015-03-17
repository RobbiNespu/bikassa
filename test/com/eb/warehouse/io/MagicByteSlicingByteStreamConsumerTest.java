
package com.eb.warehouse.io;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MagicByteSlicingByteStreamConsumerTest {

  private static final class AssertingMsgListener implements ByteMessageListener {
    int callCount = 0;
    byte[] buffer;

    @Override
    public void consumeMessage(byte[] buffer) {
      callCount++;
      this.buffer = buffer;
    }
  }

  private AssertingMsgListener assertListener;
  private MagicByteSlicingByteStreamConsumer consumer;

  @Before
  public void setUp() {
    assertListener = new AssertingMsgListener();
    consumer = new MagicByteSlicingByteStreamConsumer(2, (byte) 1, assertListener);
  }

  @Test
  public void consumeTwoBytesWithSecondAsDelimiterByteSlicesBufferExcludingDelimiter() {
    consumer.consumeByte((byte) 2);
    consumer.consumeByte((byte) 1);
    assertEquals(1, assertListener.callCount);
    assertEquals(1, assertListener.buffer.length);
    assertEquals(2, assertListener.buffer[0]);
    assertEquals(0, consumer.getPosition());
  }
}