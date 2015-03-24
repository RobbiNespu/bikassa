/*
 * Copyright (c) 2013 SSI Schaefer Noell GmbH
 */

package com.eb.warehouse.io.ngkp.message;

import java.io.Serializable;

public abstract class TT141xTOBlock implements Serializable {

  private static final long serialVersionUID = 1L;

  protected TT141x parent;
  protected int order;
  protected int acknowledge;
  protected int tuAmount;
  protected boolean[] orderExtensions1;
  protected boolean[] orderExtensions2;
  protected boolean[] acknowledgeExtensions1;
  protected boolean[] acknowledgeExtensions2;
  protected int aisle;
  protected int x;
  protected int y;
  protected int side;
  protected int depth;
  protected int srm;
  protected int lsd;
  protected int place;
  protected TT141xTUBlock[] tuBlocks;

  public TT141xTOBlock(TT141x parent) {
    super();
    this.parent = parent;
    this.order = 0;
    this.acknowledge = 0;
    this.tuAmount = 0;
    this.orderExtensions1 = new boolean[8];
    this.orderExtensions2 = new boolean[8];
    this.acknowledgeExtensions1 = new boolean[8];
    this.acknowledgeExtensions2 = new boolean[8];
    this.aisle = 0;
    this.x = 0;
    this.y = 0;
    this.side = 0;
    this.depth = 0;
    this.srm = 0;
    this.lsd = 0;
    this.place = 0;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + " [" + fieldsToString(0) + "]";
  }

  public abstract String fieldsToString(int index);

  public abstract String toHex();

  public abstract int fromHex(String hex, int byteoffset);

  public boolean isTransportOrder() {
    return order == TT141x.GET_ORDER || order == TT141x.PUT_ORDER;
  }

  public boolean isFollowUpOrder() {
    return order == TT141x.FOLLOW_UP_GET_ORDER || order == TT141x.FOLLOW_UP_PUT_ORDER;
  }

  public boolean isPositioningOrder() {
    return order == TT141x.POSITIONING_ORDER || order == TT141x.FOLLOW_UP_POSITIONING_ORDER;
  }

  public boolean isGetOrder() {
    return order == TT141x.GET_ORDER || order == TT141x.FOLLOW_UP_GET_ORDER;
  }

  public boolean isPutOrder() {
    return order == TT141x.PUT_ORDER || order == TT141x.FOLLOW_UP_PUT_ORDER;
  }

  public boolean isEmptyOrder() {
    return order == TT141x.VOID_ORDER || order == TT141x.EMPTY_ORDER;
  }

  public boolean isForkClearanceOrder() {
    return /* order == TT141x.VOID_ORDER || */order == TT141x.FORK_CLEARANCE_ORDER; // TODO fixed
  }

  public boolean isRackClearanceOrder() {
    return order == TT141x.RACK_CLEARANCE_ORDER;
  }

  public boolean getOrderExtensionBit(int extension, int bit) {
    if (extension == 1) {
      return getOrderExtensions1()[bit];
    }
    if (extension == 2) {
      return getOrderExtensions2()[bit];
    }
    return false;
  }

  public void setOrderExtensionBit(int extension, int bit, boolean value) {
    if (extension == 1) {
      getOrderExtensions1()[bit] = value;
    }
    if (extension == 2) {
      getOrderExtensions2()[bit] = value;
    }
  }

  public boolean getAckExtensionBit(int extension, int bit) {
    if (extension == 1) {
      return getAcknowledgeExtensions1()[bit];
    }
    if (extension == 2) {
      return getAcknowledgeExtensions2()[bit];
    }
    return false;
  }

  public void setAckExtensionBit(int extension, int bit, boolean value) {
    if (extension == 1) {
      getAcknowledgeExtensions1()[bit] = value;
    }
    if (extension == 2) {
      getAcknowledgeExtensions1()[bit] = value;
    }
  }

  public TT141x getParent() {
    return parent;
  }

  public void setParent(TT141x parent) {
    this.parent = parent;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public int getAcknowledge() {
    return acknowledge;
  }

  public void setAcknowledge(int acknowledge) {
    this.acknowledge = acknowledge;
  }

  public int getTuAmount() {
    return tuAmount;
  }

  public void setTuAmount(int tuAmount) {
    this.tuAmount = tuAmount;
  }

  public boolean[] getOrderExtensions1() {
    return orderExtensions1;
  }

  public void setOrderExtensions1(boolean[] orderExtensions1) {
    this.orderExtensions1 = orderExtensions1;
  }

  public boolean[] getOrderExtensions2() {
    return orderExtensions2;
  }

  public void setOrderExtensions2(boolean[] orderExtensions2) {
    this.orderExtensions2 = orderExtensions2;
  }

  public boolean[] getAcknowledgeExtensions1() {
    return acknowledgeExtensions1;
  }

  public void setAcknowledgeExtensions1(boolean[] acknowledgeExtensions1) {
    this.acknowledgeExtensions1 = acknowledgeExtensions1;
  }

  public boolean[] getAcknowledgeExtensions2() {
    return acknowledgeExtensions2;
  }

  public void setAcknowledgeExtensions2(boolean[] acknowledgeExtensions2) {
    this.acknowledgeExtensions2 = acknowledgeExtensions2;
  }

  public int getAisle() {
    return aisle;
  }

  public void setAisle(int aisle) {
    this.aisle = aisle;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getSide() {
    return side;
  }

  public void setSide(int side) {
    this.side = side;
  }

  public int getDepth() {
    return depth;
  }

  public void setDepth(int depth) {
    this.depth = depth;
  }

  public int getSrm() {
    return srm;
  }

  public void setSrm(int srm) {
    this.srm = srm;
  }

  public int getLsd() {
    return lsd;
  }

  public void setLsd(int lsd) {
    this.lsd = lsd;
  }

  public int getPlace() {
    return place;
  }

  public void setPlace(int place) {
    this.place = place;
  }

  public TT141xTUBlock[] getTuBlocks() {
    return tuBlocks;
  }

  public void setTuBlocks(TT141xTUBlock[] tuBlocks) {
    this.tuBlocks = tuBlocks;
  }
}
