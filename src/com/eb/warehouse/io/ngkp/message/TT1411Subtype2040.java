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
public class TT1411Subtype2040 extends TT1411 {

  public static TT1411 fromBytes(byte[] bytes) {
    TT1411Subtype2040 telegram = new TT1411Subtype2040();

    TT141xTOBlock toBlock = telegram.getToBlocks()[0];
    intoTOBlock(bytes, 16, toBlock);

    TT141xTUBlock tuBlock = toBlock.getTuBlocks()[0];
    intoTUBlock(bytes, 42, tuBlock);

    tuBlock = toBlock.getTuBlocks()[1];
    intoTUBlock(bytes, 76, tuBlock);

    tuBlock = toBlock.getTuBlocks()[2];
    intoTUBlock(bytes, 110, tuBlock);

    tuBlock = toBlock.getTuBlocks()[3];
    intoTUBlock(bytes, 144, tuBlock);

    toBlock = telegram.getToBlocks()[1];
    intoTOBlock(bytes, 178, toBlock);

    tuBlock = toBlock.getTuBlocks()[0];
    intoTUBlock(bytes, 204, tuBlock);

    tuBlock = toBlock.getTuBlocks()[1];
    intoTUBlock(bytes, 238, tuBlock);

    tuBlock = toBlock.getTuBlocks()[2];
    intoTUBlock(bytes, 272, tuBlock);

    tuBlock = toBlock.getTuBlocks()[3];
    intoTUBlock(bytes, 306, tuBlock);

    return telegram;
  }

  private static final long serialVersionUID = 1L;

  public TT1411Subtype2040() {
    super();
    subType = 2040;
  }

  @Override
  public int getNumberOfTOBlocks() {
    return 2;
  }

  @Override
  public int getNumberOfTUBlocks() {
    return 4;
  }
}
