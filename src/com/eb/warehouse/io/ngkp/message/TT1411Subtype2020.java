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
 *          dennis.chong $
 */
public class TT1411Subtype2020 extends TT1411 {

  public static TT1411 fromBytes(byte[] bytes, int offset) {
    TT1411Subtype2020 telegram = new TT1411Subtype2020();

    TT141xTOBlock toBlock = telegram.getToBlocks()[0];
    intoTOBlock(bytes, offset + 16, toBlock);

    TT141xTUBlock tuBlock = toBlock.getTuBlocks()[0];
    intoTUBlock(bytes, offset + 42, tuBlock);

    tuBlock = toBlock.getTuBlocks()[1];
    intoTUBlock(bytes, offset + 76, tuBlock);

    toBlock = telegram.getToBlocks()[1];
    intoTOBlock(bytes, offset + 110, toBlock);

    tuBlock = toBlock.getTuBlocks()[0];
    intoTUBlock(bytes, offset + 136, tuBlock);

    tuBlock = toBlock.getTuBlocks()[1];
    intoTUBlock(bytes, offset + 170, tuBlock);

    return telegram;
  }

  private static final long serialVersionUID = 1L;

  public TT1411Subtype2020() {
    super();
    subType = 2020;
  }

  @Override
  public int getNumberOfTOBlocks() {
    return 2;
  }

  @Override
  public int getNumberOfTUBlocks() {
    return 2;
  }
}
