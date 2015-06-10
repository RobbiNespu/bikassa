package com.eb.warehouse.io;


/**
 * <p> Listener for raw byte messages from a remote sender. </p>
 */

public interface ByteMessageListener {

  /**
   * Consume the raw byte message from a remote sender. <p> This interface only guarantees that the
   * message array doesn't exceed a specified maximum length to avoid a {@link OutOfMemoryError}
   * error. It's the consumers responsibility to detect whether the message is valid and can be
   * further processed. </p>
   *
   * @param buffer. The length of delivered message may vary from <code>0</code> to a maximum
   *                       limit defined by the caller. Not NULL.
   */
  void consumeMessage(byte[] buffer);
}

//---------------------------- Revision History ----------------------------
//$Log$
//
