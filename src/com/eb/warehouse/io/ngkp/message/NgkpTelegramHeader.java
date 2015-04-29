package com.eb.warehouse.io.ngkp.message;

import com.eb.warehouse.io.ByteMessage;

import java.nio.ByteBuffer;

import javax.annotation.Nonnull;

import static com.eb.warehouse.io.ngkp.Bytes2.shortFromBytes;

/**
 * Created by ebe on 26.03.2015.
 */
public final class NgkpTelegramHeader implements ByteMessage {

  private int senderId;
  private int receiverId;
  private int telegramType;
  private int telegramSubType;
  private int version;

  @Override
  public void fromByteArray(@Nonnull byte[] bytes, int offset) {
    senderId = shortFromBytes(bytes[offset + 0], bytes[offset + 1]);
    receiverId = shortFromBytes(bytes[offset + 2], bytes[offset + 3]);
    telegramType = shortFromBytes(bytes[offset + 4], bytes[offset + 5]);
    telegramSubType = shortFromBytes(bytes[offset + 6], bytes[offset + 7]);
    version = shortFromBytes(bytes[offset + 8], bytes[offset + 9]);
  }

  @Override
  public void intoByteArray(@Nonnull byte[] bytes, int offset) {
    ByteBuffer.wrap(bytes).putShort((short) senderId).putShort((short) receiverId)
        .putShort((short) telegramType).putShort((short) telegramSubType).putShort((short) version);
  }

  public final int getSenderId() {
    return senderId;
  }

  public final void setSenderId(int senderId) {
    this.senderId = senderId;
  }

  public final int getReceiverId() {
    return receiverId;
  }

  public final void setReceiverId(int receiverId) {
    this.receiverId = receiverId;
  }

  public final int getTelegramType() {
    return telegramType;
  }

  public final void setTelegramType(int telegramType) {
    this.telegramType = telegramType;
  }

  public final int getTelegramSubType() {
    return telegramSubType;
  }

  public final void setTelegramSubType(int telegramSubType) {
    this.telegramSubType = telegramSubType;
  }

  public final int getVersion() {
    return version;
  }

  public final void setVersion(int version) {
    this.version = version;
  }

  @Override
  public String toString() {
    StringBuilder b = new StringBuilder();
    b.append("senderId=").append(senderId).append(", ");
    b.append("receiverId=").append(receiverId).append(", ");
    b.append("telegramType=").append(telegramType).append(", ");
    b.append("telegramSubType=").append(telegramSubType).append(", ");
    b.append("version=").append(version);
    return b.toString();
  }
}
