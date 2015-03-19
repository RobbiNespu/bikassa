package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the TT1411 telegram class.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1484 $, $Date: 2013-09-12 16:40:43 +0200 (Do, 12 Sep 2013) $, $Author:
 *          dennis.chong $
 */
public class TT1411Subtype2040 extends TT1411 {

  public static TT1411 fromBytes(byte[] bytes, int offset) {
    TT1411Subtype2040 telegram = new TT1411Subtype2040();

    TT141xTOBlock toBlock = telegram.getToBlocks()[0];
    intoTOBlock(bytes, offset + 16, toBlock);

    TT141xTUBlock tuBlock = toBlock.getTuBlocks()[0];
    intoTUBlock(bytes, offset + 42, tuBlock);

    tuBlock = toBlock.getTuBlocks()[1];
    intoTUBlock(bytes, offset + 76, tuBlock);

    tuBlock = toBlock.getTuBlocks()[2];
    intoTUBlock(bytes, offset + 110, tuBlock);

    tuBlock = toBlock.getTuBlocks()[3];
    intoTUBlock(bytes, offset + 144, tuBlock);

    toBlock = telegram.getToBlocks()[1];
    intoTOBlock(bytes, offset + 178, toBlock);

    tuBlock = toBlock.getTuBlocks()[0];
    intoTUBlock(bytes, offset + 204, tuBlock);

    tuBlock = toBlock.getTuBlocks()[1];
    intoTUBlock(bytes, offset + 238, tuBlock);

    tuBlock = toBlock.getTuBlocks()[2];
    intoTUBlock(bytes, offset + 272, tuBlock);

    tuBlock = toBlock.getTuBlocks()[3];
    intoTUBlock(bytes, offset + 306, tuBlock);

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
