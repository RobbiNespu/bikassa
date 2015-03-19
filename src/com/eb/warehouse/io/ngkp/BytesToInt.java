package com.eb.warehouse.io.ngkp;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public final class BytesToInt {

  private BytesToInt() {}

  public static int shortFromBytes(byte msb, byte lsb) {
    return ((msb & 0xFF) << 8) + (lsb & 0xFF);
  }

  public static int intFromBytes(byte msb, byte b2, byte b3, byte lsb) {
    return ((msb & 0xFF) << 24) + ((b2 & 0xFF) << 16) + shortFromBytes(b3, lsb);
  }
}
