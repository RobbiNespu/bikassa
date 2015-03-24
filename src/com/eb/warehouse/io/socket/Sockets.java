package com.eb.warehouse.io.socket;

import java.io.IOException;
import java.net.Socket;

import javax.annotation.Nullable;

/**
 * <p> Utility methods pertaining {@link Socket} instances. </p>
 */

final class Sockets {

  private Sockets() {
  }

  /**
   * Close this socket ignoring any thrown {@link IOException}.
   *
   * @param socket to close.
   */
  public static void closeQuietly(@Nullable Socket socket) {
    if (socket == null) {
      return;
    }

    try {
      socket.close();
    } catch (IOException e) {
    }
  }
}