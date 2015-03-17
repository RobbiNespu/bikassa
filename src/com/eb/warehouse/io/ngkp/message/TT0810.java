/*
 * Copyright (c) 2012 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1835 $, $Date: 2014-09-08 11:40:40 +0200 (Mon, 08 Sep 2014) $, $Author: dennis.chong $
 */

public class TT0810 extends TT081x {
  private static final long serialVersionUID = 1L;

  protected int reserve;
  protected int transportNumber;
  protected int transportId;
  protected int sourceSystem;
  protected int currentUnit;
  protected int currentPosition;
  protected int[] destinationSystem;
  protected int[] destinationUnit;
  protected int[] destinationPosition;
  protected int order;
  protected boolean[] orderExtensions1;
  protected boolean[] orderExtensions2;
  protected int acknowledge;
  protected boolean[] ackExtensions1;
  protected boolean[] ackExtensions2;
  protected int prioritization;
  protected int movementOptions1;
  protected int movementOptions2;
  protected int program1;
  protected int program2;
  protected int program3;
  protected int tuType;
  protected boolean[] tuFlags1;
  protected boolean[] tuFlags2;
  protected int tuLength;
  protected int tuWidth;
  protected int tuHeight;
  protected int tuWeight;
  protected boolean[] tuErrorFlags1;
  protected boolean[] tuErrorFlags2;
  protected String tuID;
  protected String additionalBarcode;
  protected String displayText;
  protected String additionalSocData;
  protected String plcData;
  protected Queue<String> destinationList;
  protected boolean type;

  public TT0810() {
    super();
    senderID = 201;
    receiverID = 0;
    telegramType = 810;
    subType = 0;
    version = 0;
    reserve = 0;
    transportNumber = 0;
    transportId = 0;
    sourceSystem = 0;
    currentUnit = 0;
    currentPosition = 0;
    destinationSystem = new int[5];
    destinationUnit = new int[5];
    destinationPosition = new int[5];
    order = 0;
    orderExtensions1 = new boolean[8];
    orderExtensions2 = new boolean[8];
    acknowledge = 0;
    ackExtensions1 = new boolean[8];
    ackExtensions2 = new boolean[8];
    prioritization = 0;
    movementOptions1 = 0;
    movementOptions2 = 0;
    program1 = 0;
    program2 = 0;
    program3 = 0;
    tuType = 0;
    tuFlags1 = new boolean[8];
    tuFlags2 = new boolean[8];
    tuLength = 0;
    tuWidth = 0;
    tuHeight = 0;
    tuWeight = 0;
    tuErrorFlags1 = new boolean[8];
    tuErrorFlags2 = new boolean[8];
    tuID = "                    ";
    additionalBarcode = fillUpToLength("", ' ', 100);
    displayText = fillUpToLength("", ' ', 20);
    additionalSocData = fillUpToLength("", ' ', 10);
    plcData = fillUpToLength("", ' ', 10);
    destinationList = new LinkedList<String>();
    type = false;
  }

  @Override
  public String fieldsToString() {
    StringBuilder s = new StringBuilder();
    s.append(super.fieldsToString());
    s.append(" reserve=" + reserve);
    s.append(", transportNumber=" + transportNumber);
    s.append(", transportId=" + transportId);
    s.append(", currentUnit=" + currentUnit);
    s.append(", currentPosition=" + currentPosition);
    s.append(", destinationUnit1=" + destinationUnit[0]);
    s.append(", destinationPosition1=" + destinationPosition[0]);
    s.append(", destinationUnit2=" + destinationUnit[1]);
    s.append(", destinationPosition2=" + destinationPosition[1]);
    s.append(", destinationUnit3=" + destinationUnit[2]);
    s.append(", destinationPosition3=" + destinationPosition[2]);
    s.append(", destinationUnit4=" + destinationUnit[3]);
    s.append(", destinationPosition4=" + destinationPosition[3]);
    s.append(", destinationUnit5=" + destinationUnit[4]);
    s.append(", destinationPosition5=" + destinationPosition[4]);
    s.append(", order=" + order);
    s.append(", orderExtensions1=" + bitsToString(orderExtensions1));
    s.append(", orderExtensions2=" + bitsToString(orderExtensions2));
    s.append(", acknowledge=" + acknowledge);
    s.append(", ackExtensions1=" + bitsToString(ackExtensions1));
    s.append(", ackExtensions2=" + bitsToString(ackExtensions2));
    s.append(", prioritization=" + prioritization);
    s.append(", movementOptions1=" + movementOptions1);
    s.append(", movementOptions2=" + movementOptions2);
    s.append(", program1=" + program1);
    s.append(", program2=" + program2);
    s.append(", program3=" + program3);
    s.append(", tuType=" + tuType);
    s.append(", tuFlags1=" + bitsToString(tuFlags1));
    s.append(", tuFlags2=" + bitsToString(tuFlags2));
    s.append(", tuLength=" + tuLength);
    s.append(", tuWidth=" + tuWidth);
    s.append(", tuHeight=" + tuHeight);
    s.append(", tuWeight=" + tuWeight);
    s.append(", tuErrorFlags1=" + bitsToString(tuErrorFlags1));
    s.append(", tuErrorFlags2=" + bitsToString(tuErrorFlags2));
    s.append(", tuID=" + tuID + displayTuExtra() + "]");
    return s.toString();
  }

  public String displayTuExtra() {
    String tuExtra = "";
    if ((subType & 1 << 0) != 0) {
      tuExtra += ", additionalBarcode=" + additionalBarcode;
    }
    if ((subType & 1 << 1) != 0) {
      tuExtra += ", displayText=" + displayText;
    }
    if ((subType & 1 << 2) != 0) {
      tuExtra += ", additionalSocData=" + additionalSocData;
    }
    if ((subType & 1 << 3) != 0) {
      tuExtra += ", plcData=" + plcData;
    }
    return tuExtra;
  }

  @Override
  public String toHex() {
    String hex = "";
    hex = insertIntIntoHex(hex, senderID, 2);
    hex = insertIntIntoHex(hex, receiverID, 2);
    hex = insertIntIntoHex(hex, telegramType, 2);
    hex = insertIntIntoHex(hex, subType, 2);
    hex = insertIntIntoHex(hex, version, 2);
    hex = insertIntIntoHex(hex, reserve, 2);
    hex = insertIntIntoHex(hex, requestID, 4);
    hex = insertIntIntoHex(hex, transportNumber, 2);
    hex = insertIntIntoHex(hex, transportId, 2);
    hex = insertIntIntoHex(hex, currentUnit, 2);
    hex = insertIntIntoHex(hex, currentPosition, 2);
    hex = insertIntIntoHex(hex, destinationUnit[0], 2);
    hex = insertIntIntoHex(hex, destinationPosition[0], 2);
    hex = insertIntIntoHex(hex, destinationUnit[1], 2);
    hex = insertIntIntoHex(hex, destinationPosition[1], 2);
    hex = insertIntIntoHex(hex, destinationUnit[2], 2);
    hex = insertIntIntoHex(hex, destinationPosition[2], 2);
    hex = insertIntIntoHex(hex, destinationUnit[3], 2);
    hex = insertIntIntoHex(hex, destinationPosition[3], 2);
    hex = insertIntIntoHex(hex, destinationUnit[4], 2);
    hex = insertIntIntoHex(hex, destinationPosition[4], 2);
    hex = insertIntIntoHex(hex, order, 2);
    hex = insertBitsIntoHex(hex, orderExtensions1, 1);
    hex = insertBitsIntoHex(hex, orderExtensions2, 1);
    hex = insertIntIntoHex(hex, acknowledge, 2);
    hex = insertBitsIntoHex(hex, ackExtensions1, 1);
    hex = insertBitsIntoHex(hex, ackExtensions2, 1);
    hex = insertIntIntoHex(hex, prioritization, 2);
    hex = insertIntIntoHex(hex, movementOptions1, 2);
    hex = insertIntIntoHex(hex, movementOptions2, 2);
    hex = insertIntIntoHex(hex, program1, 2);
    hex = insertIntIntoHex(hex, program2, 2);
    hex = insertIntIntoHex(hex, program2, 2);
    hex = insertIntIntoHex(hex, tuType, 2);
    hex = insertBitsIntoHex(hex, tuFlags1, 1);
    hex = insertBitsIntoHex(hex, tuFlags2, 1);
    hex = insertIntIntoHex(hex, tuLength, 2);
    hex = insertIntIntoHex(hex, tuWidth, 2);
    hex = insertIntIntoHex(hex, tuHeight, 2);
    hex = insertIntIntoHex(hex, tuWeight, 2);
    hex = insertBitsIntoHex(hex, tuErrorFlags1, 1);
    hex = insertBitsIntoHex(hex, tuErrorFlags2, 1);
    hex = insertStringIntoHex(hex, formatString(tuID, 20));
    if ((subType & 1 << 0) != 0) {
      hex = insertStringIntoHex(hex, additionalBarcode);
    }
    if ((subType & 1 << 1) != 0) {
      hex = insertStringIntoHex(hex, displayText);
    }
    if ((subType & 1 << 2) != 0) {
      hex = insertStringIntoHex(hex, additionalSocData);
    }
    if ((subType & 1 << 3) != 0) {
      hex = insertStringIntoHex(hex, plcData);
    }
    return hex;
  }

  @Override
  public void fromHex(String hex) {
    senderID = extractIntFromHex(hex, 0, 2);
    receiverID = extractIntFromHex(hex, 2, 2);
    telegramType = extractIntFromHex(hex, 4, 2);
    subType = extractIntFromHex(hex, 6, 2);
    version = extractIntFromHex(hex, 8, 2);
    reserve = extractIntFromHex(hex, 10, 2);
    requestID = extractIntFromHex(hex, 12, 4);
    transportNumber = extractIntFromHex(hex, 16, 2);
    transportId = extractIntFromHex(hex, 18, 2);
    currentUnit = extractIntFromHex(hex, 20, 2);
    currentPosition = extractIntFromHex(hex, 22, 2);
    destinationUnit[0] = extractIntFromHex(hex, 24, 2);
    destinationPosition[0] = extractIntFromHex(hex, 26, 2);
    destinationUnit[1] = extractIntFromHex(hex, 28, 2);
    destinationPosition[1] = extractIntFromHex(hex, 30, 2);
    destinationUnit[2] = extractIntFromHex(hex, 32, 2);
    destinationPosition[2] = extractIntFromHex(hex, 34, 2);
    destinationUnit[3] = extractIntFromHex(hex, 36, 2);
    destinationPosition[3] = extractIntFromHex(hex, 38, 2);
    destinationUnit[4] = extractIntFromHex(hex, 40, 2);
    destinationPosition[4] = extractIntFromHex(hex, 42, 2);
    order = extractIntFromHex(hex, 44, 2);
    extractBitsFromHex(hex, orderExtensions1, 46, 1);
    extractBitsFromHex(hex, orderExtensions2, 47, 1);
    acknowledge = extractIntFromHex(hex, 48, 2);
    extractBitsFromHex(hex, ackExtensions1, 50, 1);
    extractBitsFromHex(hex, ackExtensions2, 51, 1);
    prioritization = extractIntFromHex(hex, 52, 2);
    movementOptions1 = extractIntFromHex(hex, 54, 2);
    movementOptions2 = extractIntFromHex(hex, 56, 2);
    program1 = extractIntFromHex(hex, 58, 2);
    program2 = extractIntFromHex(hex, 60, 2);
    program3 = extractIntFromHex(hex, 62, 2);
    tuType = extractIntFromHex(hex, 64, 2);
    extractBitsFromHex(hex, tuFlags1, 66, 1);
    extractBitsFromHex(hex, tuFlags2, 67, 1);
    tuLength = extractIntFromHex(hex, 68, 2);
    tuWidth = extractIntFromHex(hex, 70, 2);
    tuHeight = extractIntFromHex(hex, 72, 2);
    tuWeight = extractIntFromHex(hex, 74, 2);
    extractBitsFromHex(hex, tuErrorFlags1, 76, 1);
    extractBitsFromHex(hex, tuErrorFlags2, 77, 1);
    tuID = extractStringFromHex(hex, 78, 20);
    int offset = 98;
    if ((subType & 1 << 0) != 0) {
      additionalBarcode = extractStringFromHex(hex, offset, 100); //TODO: changed to 100 bytes according to latest IFSOC
      offset += 100;
    }
    if ((subType & 1 << 1) != 0) {
      displayText = extractStringFromHex(hex, offset, 20);
      offset += 20;
    }
    if ((subType & 1 << 2) != 0) {
      additionalSocData = extractStringFromHex(hex, offset, 10);
      offset += 10;
    }
    if ((subType & 1 << 3) != 0) {
      plcData = extractStringFromHex(hex, offset, 10);
      offset += 10;
    }
    createDestinationList();
  }

  public boolean isTransportOrder() {
    return order == TT081x.NEW;
  }

  public boolean isTransportUpdate() {
    return order == TT081x.UPDATE;
  }

  public boolean isTransportOverwrite() {
    return order == TT081x.OVERWRITE;
  }

  public boolean isTransportDelete() {
    return order == TT081x.DELETE;
  }

  public boolean isTransportRequest() {
    return order == TT081x.REQUEST;
  }

  public String getSourceID() {
    return getReceiverID() + "/" + getCurrentUnit() + "/" + getCurrentPosition();
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
      return getAckExtensions1()[bit];
    }
    if (extension == 2) {
      return getAckExtensions2()[bit];
    }
    return false;
  }

  public void setAckExtensionBit(int extension, int bit, boolean value) {
    if (extension == 1) {
      getAckExtensions1()[bit] = value;
    }
    if (extension == 2) {
      getAckExtensions2()[bit] = value;
    }
  }

  public boolean isTT810Received() {
    return type;
  }

  public void setTT810Reveceived() {
    type = true;
  }

  public int getReserve() {
    return reserve;
  }

  public void setReserve(int reserve) {
    this.reserve = reserve;
  }

  public int getTransportNumber() {
    return transportNumber;
  }

  public void setTransportNumber(int transportNumber) {
    this.transportNumber = transportNumber;
  }

  public int getTransportId() {
    return transportId;
  }

  public void setTransportId(int transportId) {
    this.transportId = transportId;
  }

  public int getCurrentUnit() {
    return currentUnit;
  }

  public void setCurrentUnit(int currentUnit) {
    this.currentUnit = currentUnit;
  }

  public int getCurrentPosition() {
    return currentPosition;
  }

  public void setCurrentPosition(int currentPosition) {
    this.currentPosition = currentPosition;
  }

  public int[] getDestinationUnit() {
    return destinationUnit;
  }

  public void setDestinationUnit(int[] destinationUnit) {
    this.destinationUnit = destinationUnit;
  }

  public int[] getDestinationPosition() {
    return destinationPosition;
  }

  public void setDestinationPosition(int[] destinationPosition) {
    this.destinationPosition = destinationPosition;
  }

  public void clearDestinatUnit() {
    for (int i = 0; i < destinationUnit.length; i++) {
      destinationUnit[i] = 0;
      destinationPosition[i] = 0;
    }
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
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

  public int getAcknowledge() {
    return acknowledge;
  }

  public void setAcknowledge(int acknowledge) {
    this.acknowledge = acknowledge;
  }

  public boolean[] getAckExtensions1() {
    return ackExtensions1;
  }

  public void setAckExtensions1(boolean[] ackExtensions1) {
    this.ackExtensions1 = ackExtensions1;
  }

  public boolean[] getAckExtensions2() {
    return ackExtensions2;
  }

  public void setAckExtensions2(boolean[] ackExtensions2) {
    this.ackExtensions2 = ackExtensions2;
  }

  public int getPrioritization() {
    return prioritization;
  }

  public void setPrioritization(int prioritization) {
    this.prioritization = prioritization;
  }

  public int getMovementOptions1() {
    return movementOptions1;
  }

  public void setMovementOptions1(int movementOptions1) {
    this.movementOptions1 = movementOptions1;
  }

  public int getMovementOptions2() {
    return movementOptions2;
  }

  public void setMovementOptions2(int movementOptions2) {
    this.movementOptions2 = movementOptions2;
  }

  public int getProgram1() {
    return program1;
  }

  public void setProgram1(int program1) {
    this.program1 = program1;
  }

  public int getProgram2() {
    return program2;
  }

  public void setProgram2(int program2) {
    this.program2 = program2;
  }

  public int getProgram3() {
    return program3;
  }

  public void setProgram3(int program3) {
    this.program3 = program3;
  }

  public int getTuType() {
    return tuType;
  }

  public void setTuType(int tuType) {
    this.tuType = tuType;
  }

  public boolean[] getTuFlags1() {
    return tuFlags1;
  }

  public void setTuFlags1(boolean[] tuFlags1) {
    this.tuFlags1 = tuFlags1;
  }

  public boolean[] getTuFlags2() {
    return tuFlags2;
  }

  public void setTuFlags2(boolean[] tuFlags2) {
    this.tuFlags2 = tuFlags2;
  }

  public int getTuLength() {
    return tuLength;
  }

  public void setTuLength(int tuLength) {
    this.tuLength = tuLength;
  }

  public int getTuWidth() {
    return tuWidth;
  }

  public void setTuWidth(int tuWidth) {
    this.tuWidth = tuWidth;
  }

  public int getTuHeight() {
    return tuHeight;
  }

  public void setTuHeight(int tuHeight) {
    this.tuHeight = tuHeight;
  }

  public int getTuWeight() {
    return tuWeight;
  }

  public void setTuWeight(int tuWeight) {
    this.tuWeight = tuWeight;
  }

  public boolean[] getTuErrorFlags1() {
    return tuErrorFlags1;
  }

  public void setTuErrorFlags1(boolean[] tuErrorFlags1) {
    this.tuErrorFlags1 = tuErrorFlags1;
  }

  public boolean[] getTuErrorFlags2() {
    return tuErrorFlags2;
  }

  public void setTuErrorFlags2(boolean[] tuErrorFlags2) {
    this.tuErrorFlags2 = tuErrorFlags2;
  }

  public String getTuID() {
    return tuID;
  }

  public void setTuID(String tuID) {
    this.tuID = tuID;
  }

  public String getAdditionalBarcode() {
    return additionalBarcode;
  }

  public void setAdditionalBarcode(String additionalBarcode) {
    this.additionalBarcode = additionalBarcode;
  }

  public String getDisplayText() {
    return displayText;
  }

  public void setDisplayText(String displayText) {
    this.displayText = displayText;
  }

  public String getAdditionalSocData() {
    return additionalSocData;
  }

  public void setAdditionalSocData(String additionalSocData) {
    this.additionalSocData = additionalSocData;
  }

  public String getPlcData() {
    return plcData;
  }

  public void setPlcData(String plcData) {
    this.plcData = plcData;
  }

  public int getSourceSystem() {
    return sourceSystem;
  }

  public void setSourceSystem(int sourceSystem) {
    this.sourceSystem = sourceSystem;
  }

  public int[] getDestinationSystem() {
    return destinationSystem;
  }

  public void setDestinationSystem(int[] destinationSystems) {
    destinationSystem = destinationSystems;
  }

  public Queue<String> getDestinationList() {
    return destinationList;
  }

  public void setDestinationList(Queue<String> destinationList) {
    this.destinationList = destinationList;
  }

  public String getNextDestination() {
    return destinationList.peek();
  }

  public String removeNextDestination() {
    return destinationList.poll();
  }

  public int getDestinationsCount() {
    return destinationList.size();
  }

  public void clearDestinations() {
    destinationList.clear();
  }

  public boolean isType() {
    return type;
  }

  public void setType(boolean type) {
    this.type = type;
  }

  public void setDestinations(List<TT0810Destination> destinations) {
    int index = 0;
    for (TT0810Destination destination : destinations) {
      destinationUnit[index] = destination.getDestinationUnit();
      destinationPosition[index] = destination.getDestinationPosition();
      destinationSystem[index] = destination.getDestinationSystem();
      String destinationID = destinationSystem[index] + "/" + destinationUnit[index] + "/" + destinationPosition[index];
      destinationList.add(destinationID);
      index++;
    }
  }

  public void clearDestinationUnits() {
    for (int i = 0; i < destinationUnit.length; i++) {
      destinationUnit[i] = 0;
      destinationPosition[i] = 0;
    }
  }

  public void createDestinationList() {
    for (int i = 0; i < destinationUnit.length; i++) {
      if (destinationPosition[i] > 0) {
        String destinationID = receiverID + "/" + destinationUnit[i] + "/" + destinationPosition[i];
        destinationList.add(destinationID);
      }
    }
  }
}
