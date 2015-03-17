
package com.eb.warehouse.io.ngkp;

import com.eb.warehouse.io.ngkp.message.TT1411;
import com.eb.warehouse.io.ngkp.message.TT1434;
import com.google.common.base.MoreObjects;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class Ngkp2Telegram {

  public static Ngkp2Telegram fromHeaderAndBytes(Ngkp2Header header, byte[] payloadBytes) {
    Ngkp2Telegram telegram = new Ngkp2Telegram();
    telegram.setHeader(header);
    if (header.getTelegramType() == 1411) {
      telegram.setContent(TT1411.fromBytes(payloadBytes));
    } else if (header.getTelegramType() == 1434) {
      // Status and control reply
      telegram.setContent(TT1434.fromBytes(payloadBytes));
    }
    return null;
  }

  private Ngkp2Header header;
  private Object content;

  public Ngkp2Telegram() {
  }

  public Ngkp2Header getHeader() {
    return header;
  }

  public void setHeader(Ngkp2Header header) {
    this.header = header;
  }

  public Object getContent() {
    return content;
  }

  public void setContent(Object content) {
    this.content = content;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("header", header).add("content", content).toString();
  }
}