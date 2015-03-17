
package com.eb.warehouse.io.ngkp;

import java.nio.ByteBuffer;

import org.junit.Before;
import org.junit.Test;

public class NgkpSlicingByteStreamConsumerTest {

  private NgkpSlicingByteStreamConsumer consumer;

  @Before
  public void setUp() {
    consumer = new NgkpSlicingByteStreamConsumer(16);
  }

  @Test
  public void consumeTenBytes_validNgkpHeader() {
    byte[] buf =
      ByteBuffer.allocate(10).put((byte) 1).put((byte) 2).put((byte) 3).put((byte) 4).put((byte) 5).put((byte) 6).put((byte) 7).put((byte) 8).array();
    int crc16 = CRC16.calculate(buf, 0, 8);
    System.out.println((byte) crc16);
    System.out.println((crc16 >> 8) & 0xFF);
    consumer.consumeByte((byte) 1);
    consumer.consumeByte((byte) 2);
    consumer.consumeByte((byte) 3);
    consumer.consumeByte((byte) 4);
    consumer.consumeByte((byte) 5);
    consumer.consumeByte((byte) 6);
    consumer.consumeByte((byte) 7);
    consumer.consumeByte((byte) 8);
    consumer.consumeByte((byte) -16);
    consumer.consumeByte((byte) 196);
  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//
