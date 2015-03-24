package com.eb.warehouse.io.socket;

import com.google.common.base.MoreObjects;
import com.google.inject.assistedinject.Assisted;

import com.eb.warehouse.io.ByteStreamConsumer;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.Callable;

import javax.inject.Inject;

/**
 * <p> {@link Runnable} implementation that reads endlessly from a socket's {@link InputStream} in
 * blocking mode and forwards every read byte to a {@link ByteStreamConsumer}. </p> <p> To stop
 * reading from the socket call its {@link Socket#close()} or the {@link InputStream#close()}
 * method. </p> <p> If any exception occurs while attempting to read from the socket the {@link
 * #run()} method will return and the cause can be retrieved by calling {@link #failureCause()}.
 * </p>
 */
final class ReadSocketTask implements Callable<Void> {

  private final InputStream socketInputStream;
  private final ByteStreamConsumer byteFromSocketConsumer;

  //  private ConnectionStatsCounter statsCounter;

  @Inject
  public ReadSocketTask(@Assisted InputStream socketInputStream,
                        ByteStreamConsumer socketStreamConsumer) {
    this.socketInputStream = socketInputStream;
    byteFromSocketConsumer = socketStreamConsumer;
  }

  /**
   * Read bytes from the {@link Socket#getInputStream()} in a while loop and forward every byte to
   * the {@link ByteStreamConsumer} until an {@link IOException} occurs.
   */
  @Override
  public Void call() throws Exception {
    byte b;
    while ((b = (byte) socketInputStream.read()) != -1) {
      //      statsCounter.incrementReceivedBytes();
      byteFromSocketConsumer.consumeByte(b);
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("socketInputStream", socketInputStream)
        .add("byteConsumer", byteFromSocketConsumer).omitNullValues().toString();
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
