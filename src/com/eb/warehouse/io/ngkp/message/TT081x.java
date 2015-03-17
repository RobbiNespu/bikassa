/*
 * Copyright (c) 2014 SSI Schaefer Noell GmbH
 */

package com.eb.warehouse.io.ngkp.message;

public class TT081x extends NGKPTelegram {
  private static final long serialVersionUID = 1L;

  public static final int NEW = 8001;
  public static final int UPDATE = 8002;
  public static final int OVERWRITE = 8003;
  public static final int DELETE = 8004;
  public static final int REQUEST = 8005;

  public static final int NOT_ACTIVE = 8001;
  public static final int NEW_TU = 8002;
  public static final int BUSY = 8003;
  public static final int ARRIVED = 8004;
  public static final int ARRIVED_EMPTY = 8005;
  public static final int TIMEOUT_NO_CONTINUATION = 8006;
  public static final int LD_REQUEST = 8007;
  public static final int CS_TAKE_OVER = 8012;
  public static final int LD_NOT_REACHABLE = 8051;
  public static final int TO_DELETED_MANUALLY = 8091;
  public static final int CP_LOCATION_WRONG = 8121;
  public static final int LD_LOCATION_WRONG = 8122;
  public static final int TPO_NOT_ACTIVE = 8129;
}
