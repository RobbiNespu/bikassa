/*
 * Copyright (c) 2011 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the TT1411 telegram class.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1484 $, $Date: 2013-09-12 16:40:43 +0200 (Do, 12 Sep 2013) $, $Author:
 * dennis.chong $
 */
public class TT1411Subtype1020 extends TT1411 {

  public static TT1411 fromBytes(byte[] bytes) {
    TT1411Subtype1020 telegram = new TT1411Subtype1020();

    TT141xTOBlock toBlock = telegram.getToBlocks()[0];
    intoTOBlock(bytes, 16, toBlock);

    TT141xTUBlock tuBlock = toBlock.getTuBlocks()[0];
    intoTUBlock(bytes, 42, tuBlock);
    tuBlock = toBlock.getTuBlocks()[1];
    intoTUBlock(bytes, 76, tuBlock);

    return telegram;
  }

  private static final long serialVersionUID = 1L;

  public TT1411Subtype1020() {
    super();
    subType = 1020;
  }

  @Override
  public int getNumberOfTOBlocks() {
    return 1;
  }

  @Override
  public int getNumberOfTUBlocks() {
    return 2;
  }
}
