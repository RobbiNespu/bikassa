package com.eb.warehouse.io;

import javax.annotation.Nonnull;

/**
 * Message object that can be serialized into and restored from a byte array.
 */
public interface ByteMessage {

  /**
   * Serialize this message into the byte array beginning at the specified offset.
   *
   * @param bytes  to write to.
   * @param offset index where to begin writing.
   */
  void intoByteArray(@Nonnull byte[] bytes, int offset);

  /**
   * Restore this message from the byte array beginning at the specified offset.
   *
   * @param bytes  to read from.
   * @param offset index where to begin reading.
   */
  void fromByteArray(@Nonnull byte[] bytes, int offset);
}
