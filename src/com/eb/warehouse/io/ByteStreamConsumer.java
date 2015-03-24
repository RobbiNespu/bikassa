package com.eb.warehouse.io;

/**
 * <p> Consumes bytes sequentially from any data source. </p> <p> Classes deriving from this type
 * are usually stateful and need to take care of reseting its state when it isn't valid anymore.
 * </p>
 */
public interface ByteStreamConsumer {

  /**
   * See the byte. <p> This method may be called in a loop by a provider. Implementers need to take
   * care of reseting this object's state when it isn't valid anymore. </p>
   *
   * @param b byte to be seen.
   */
  void consumeByte(byte b);
}

//---------------------------- Revision History ----------------------------
//$Log$
//
