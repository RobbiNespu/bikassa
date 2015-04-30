package com.eb.warehouse.io.socket;

import com.google.common.util.concurrent.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import javax.annotation.Nonnull;

/**
 * <p> Connection using a socket that manages the whole life-cycle of the underlying {@link Socket}
 * instance. </p>
 */
public interface SocketConnection extends Service {

  /**
   * Write bytes to the socket's underlying {@link OutputStream}.
   *
   * @param bytes not NULL.
   * @throws IOException if writing failed.
   */
  void writeToSocket(@Nonnull byte[] bytes) throws IOException;

}
