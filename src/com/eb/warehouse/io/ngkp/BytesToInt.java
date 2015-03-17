
package com.eb.warehouse.io.ngkp;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public final class BytesToInt {

  private BytesToInt() {
  }

  public static int shortFromBytes(byte msb, byte lsb) {
    return (msb >> 8) & 0xFF + lsb & 0xFF;
  }

  public static int intFromBytes(byte msb, byte b2, byte b3, byte lsb) {
    return (msb >> 24) & 0xFF + (b2 >> 16) & 0xFF + shortFromBytes(b3, lsb);
  }
}
