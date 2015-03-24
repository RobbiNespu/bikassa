package com.eb.warehouse.io.ngkp;

import com.google.common.base.MoreObjects;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class Ngkp2Header {

  private int telegramLength;
  private int destinationAddress;
  private int telegramType;
  private char telegramCounter;
  private int protocolVersion = 2;

  public Ngkp2Header() {
  }

  /**
   * TODO JavaDoc according to WAMAS C conventions
   */
  public static Ngkp2Header fromBytes(byte[] bytes) {
    Ngkp2Header header = new Ngkp2Header();
    header.telegramLength = BytesToInt.shortFromBytes(bytes[0], bytes[1]);
    header.destinationAddress = bytes[2];
    header.telegramType = bytes[3];
    header.telegramCounter = (char) bytes[4];
    header.protocolVersion = bytes[5];
    return header;
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

  public int getTelegramType() {
    return telegramType;
  }

  public void setTelegramType(int telegramType) {
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
