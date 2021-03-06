package com.eb.warehouse.io.socket;

import com.google.common.util.concurrent.Service;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * <p> Connection using a socket that manages the whole life-cycle of the underlying {@link Socket}
 * instance. </p>
 */
public interface SocketConnection extends Service {

  /**
   * Write bytes to the underlying socket's {@link OutputStream}.
   *
   * @param bytes not NULL.
   * @throws IOException if writing failed.
   */
  void writeToSocket(@Nonnull byte[] bytes) throws IOException;

  /**
   * Get the hostname associated with this connection.
   *
   * @return
   */
  String getHostname();

  /**
   * Get the port number associated with this connection.
   *
   * @return
   */
  int getPort();
}
