package com.eb.warehouse.io.ngkp;

import com.google.common.base.MoreObjects;

import com.eb.warehouse.io.ByteMessage;

import javax.annotation.Nonnull;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class Ngkp2Header implements ByteMessage {

  private int telegramLength;
  private int destinationAddress;
  private char telegramType;
  private char telegramCounter;
  private int protocolVersion = 2;

  public Ngkp2Header() {
  }

  public Ngkp2Header(Ngkp2Header toCopy) {
    telegramLength = toCopy.telegramLength;
    destinationAddress = toCopy.destinationAddress;
    telegramType = toCopy.telegramType;
    telegramCounter = toCopy.telegramCounter;
    protocolVersion = 2;
  }

  @Override
  public void intoByteArray(@Nonnull byte[] bytes, int offset) {
    bytes[offset] = (byte) ((telegramLength >> 8) & 0xFF);
    bytes[offset + 1] = (byte) (telegramLength & 0xFF);
    bytes[offset + 2] = (byte) (destinationAddress & 0xFF);
    bytes[offset + 3] = (byte) telegramType;
    bytes[offset + 4] = (byte) telegramCounter;
    bytes[offset + 5] = (byte) 2; // version
    int crc16 = CRC16.calculate(bytes, offset, 8);
    bytes[offset + 8] = (byte) (crc16 & 0xFF);
    bytes[offset + 9] = (byte) ((crc16 >> 8) & 0xFF);
  }

  @Override
  public void fromByteArray(@Nonnull byte[] bytes, int offset) {
    telegramLength = Bytes2.shortFromBytes(bytes[offset], bytes[offset + 1]);
    destinationAddress = bytes[offset + 2] & 0xFF;
    telegramType = (char) bytes[offset + 3];
    telegramCounter = (char) bytes[offset + 4];
    protocolVersion = bytes[offset + 5];
  }

  public int getTelegramLength() {
    return telegramLength;
  }

  public void setTelegramLength(int telegramLength) {
    this.telegramLength = telegramLength;
  }

  public int getDestinationAddress() {
    return destinationAddress;
  }

  public void setDestinationAddress(int destinationAddress) {
    this.destinationAddress = destinationAddress;
  }

  public char getTelegramType() {
    return telegramType;
  }

  public void setTelegramType(char telegramType) {
    this.telegramType = telegramType;
  }

  public char getTelegramCounter() {
    return telegramCounter;
  }

  public void setTelegramCounter(char telegramCounter) {
    this.telegramCounter = telegramCounter;
  }

  public int getProtocolVersion() {
    return protocolVersion;
  }

  public void setProtocolVersion(int protocolVersion) {
    this.protocolVersion = protocolVersion;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("telegramLength", telegramLength)
        .add("dstAddress", destinationAddress)
        .add("telegramType", telegramType)
        .add("telegramCounter", telegramCounter)
        .add("protocolVers", protocolVersion)
        .toString();
  }
}
