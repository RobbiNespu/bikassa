package com.eb.warehouse.io.ngkp.message;


import com.eb.warehouse.io.ByteMessage;

import java.nio.ByteBuffer;

import javax.annotation.Nonnull;

import static com.eb.warehouse.io.ngkp.Bytes2.intFromBytes;
import static com.eb.warehouse.io.ngkp.Bytes2.shortFromBytes;

/**
 * Concrete extension of the TT1434 telegram class.
 *
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1634 $, $Date: 2014-01-20 15:40:17 +0100 (Mo, 20 Jan 2014) $, $Author:
 *          dennis.chong $
 */

public class TT1434Version1 extends TT1434 {

  private Header header;

  public TT1434Version1() {
  }

  public final class Header implements ByteMessage {

    private int senderId;
    private int receiverId;
    private int telegramType;
    private int telegramSubType;
    private int version = 1;
    private int topic;
    private int statusRequestId;

    public int getSenderId() {
      return senderId;
    }

    public void setSenderId(int senderId) {
      this.senderId = senderId;
    }

    public int getReceiverId() {
      return receiverId;
    }

    public void setReceiverId(int receiverId) {
      this.receiverId = receiverId;
    }

    public int getTelegramType() {
      return telegramType;
    }

    public void setTelegramType(int telegramType) {
      this.telegramType = telegramType;
    }

    public int getTelegramSubType() {
      return telegramSubType;
    }

    public void setTelegramSubType(int telegramSubType) {
      this.telegramSubType = telegramSubType;
    }

    public int getVersion() {
      return version;
    }

    public int getTopic() {
      return topic;
    }

    public void setTopic(int topic) {
      this.topic = topic;
    }

    public int getStatusRequestId() {
      return statusRequestId;
    }

    public void setStatusRequestId(int statusRequestId) {
      this.statusRequestId = statusRequestId;
    }

    @Override
    public void fromByteArray(@Nonnull byte[] bytes, int offset) {
      senderId = shortFromBytes(bytes[offset + 0], bytes[offset + 1]);
      receiverId = shortFromBytes(bytes[offset + 2], bytes[offset + 3]);
      telegramType = shortFromBytes(bytes[offset + 4], bytes[offset + 5]);
      telegramSubType = shortFromBytes(bytes[offset + 6], bytes[offset + 7]);
      version = shortFromBytes(bytes[offset + 8], bytes[offset + 9]);
      topic = shortFromBytes(bytes[offset + 10], bytes[offset + 11]);
      statusRequestId =
          intFromBytes(bytes[offset + 12], bytes[offset + 13], bytes[offset + 14],
                       bytes[offset + 15]);
    }

    @Override
    public void intoByteArray(@Nonnull byte[] bytes, int offset) {
      ByteBuffer.wrap(bytes).putShort((short) senderId).putShort((short) receiverId)
          .putShort((short) telegramType).putShort((short) telegramSubType)
          .putShort((short) version).putShort((short) topic).putInt(statusRequestId);
    }
  }
}
