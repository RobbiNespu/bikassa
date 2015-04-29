package com.eb.warehouse.io.ngkp;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public final class Ngkp2Telegram /*implements ByteMessage*/ {

//  private Ngkp2Header header;
//  private Object content;
//
//  public Ngkp2Telegram() {
//  }
//
//  public static Ngkp2Telegram fromHeaderAndBytes(Ngkp2Header header, byte[] payloadBytes,
//                                                 int offset) {
//    Ngkp2Telegram telegram = new Ngkp2Telegram();
//    telegram.setHeader(header);
//
//    int telegramType = Bytes2.shortFromBytes(payloadBytes[offset + 4], payloadBytes[offset + 5]);
//    int telegramSubType = Bytes2.shortFromBytes(payloadBytes[offset + 6], payloadBytes[offset + 7]);
//
//    if (telegramType == 1411) {
//      telegram.setContent(TT1411.fromBytes(payloadBytes, offset));
//    } else if (telegramType == 1434) {
//      // Status and control reply
//      telegram.setContent(TT1434.fromBytes(payloadBytes, offset));
//    }
//    return telegram;
//  }
//
//  @Override
//  public void intoByteArray(@Nonnull byte[] bytes, int offset) {
//
//  }
//
//  @Override
//  public void fromByteArray(@Nonnull byte[] bytes, int offset) {
//    header = new Ngkp2Header();
//    header.fromByteArray(bytes, offset);
//
//
//  }
//
//  public Ngkp2Header getHeader() {
//    return header;
//  }
//
//  public void setHeader(Ngkp2Header header) {
//    this.header = header;
//  }
//
//  public Object getContent() {
//    return content;
//  }
//
//  public void setContent(Object content) {
//    this.content = content;
//  }
//
//  /**
//   * {@inheritDoc}
//   */
//  @Override
//  public String toString() {
//    return MoreObjects.toStringHelper(this).add("header", header).add("content", content)
//        .toString();
//  }
}
