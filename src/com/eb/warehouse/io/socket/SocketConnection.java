package com.eb.warehouse.io.socket;

import com.eb.warehouse.util.Service2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import javax.annotation.Nonnull;

/**
 * <p> Connection using a socket that manages the whole life-cycle of the underlying {@link Socket}
 * instance. </p>
 */
public interface SocketConnection extends Service2 {

  /**
   * Start the connection.
   */
  @Override
  public void startAsync2();

  /**
   * Stop the connection. <p> All resources are reclaimed. This method returns when the connection
   * has been closed and all resources have been reclaimed. </p>
   */
  @Override
  public void stop2();

  /**
   * Write bytes to the socket's underlying {@link OutputStream}.
   *
   * @param bytes not NULL.
   * @throws IOException if writing failed.
   */
  void writeToSocket(@Nonnull byte[] bytes) throws IOException;

}
