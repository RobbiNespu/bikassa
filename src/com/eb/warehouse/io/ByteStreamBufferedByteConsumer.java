package com.eb.warehouse.io;

import com.google.common.base.MoreObjects;

import java.io.ByteArrayOutputStream;

import static com.google.common.base.Preconditions.checkArgument;

public abstract class ByteStreamBufferedByteConsumer implements ByteStreamConsumer {

  private final int initialBufferSize;
  private final ByteArrayOutputStream buffer;
  private int pos = 0;

  protected ByteStreamBufferedByteConsumer(int initialBufferSize) {
    checkArgument(initialBufferSize > 0, "bufferSize must be greater than 0.");
    this.initialBufferSize = initialBufferSize;
    buffer = new ByteArrayOutputStream(initialBufferSize);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void consumeByte(byte b) {
    buffer.write(b);
    pos++;
  }

  protected final void resetPosition() {
    buffer.reset();
    pos = 0;
  }

  public final byte[] getBuffer() {
    return buffer.toByteArray();
  }

  /**
   * Get the current position of the internal byte array buffer. <p> If the buffer is full already
   * and {@link #consumeByte(byte)} is called again then the position is reset to <code>0</code>.
   * </p>
   */
  public final int getPosition() {
    return pos;
  }

  /**
   * @return the initialBufferSize, TODO not null / can be null
   */
  public final int getInitialBufferSize() {
    return initialBufferSize;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("initialBufferSize", initialBufferSize)
        .add("buffer", buffer).add("position", pos).toString();
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
