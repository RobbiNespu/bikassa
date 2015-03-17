
package com.eb.warehouse.io;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ByteStreamBufferedByteConsumerTest {

  private ByteStreamBufferedByteConsumer consumer;

  @Before
  public void setUp() {
    consumer = new ByteStreamBufferedByteConsumerImpl(2);
  }

  @Test
  public void newInstanceSetsPositionToZero() {
    assertEquals(0, consumer.getPosition());
  }

  @Test
  public void consumeOneByteIncrementsPositionByOne() {
    consumer.consumeByte((byte) 1);
    assertEquals(1, consumer.getPosition());
  }

  @Test
  public void consumeThreeBytesResetsPositionToZero() {
    consumer.consumeByte((byte) 1);
    consumer.consumeByte((byte) 1);
    consumer.consumeByte((byte) 1);
    assertEquals(0, consumer.getPosition());
  }

  private static class ByteStreamBufferedByteConsumerImpl extends ByteStreamBufferedByteConsumer {

    public ByteStreamBufferedByteConsumerImpl(int bufferSize) {
      super(bufferSize);
    }

    @Override
    public void consumeByte(byte b) {
      super.consumeByte(b);
    }
  }
}
