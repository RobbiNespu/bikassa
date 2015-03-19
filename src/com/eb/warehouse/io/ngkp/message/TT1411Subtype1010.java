package com.eb.warehouse.io.ngkp.message;

/**
 * Concrete extension of the TT1411 telegram class.
 * 
 * @author <a href="mailto:dennis.chong@ssi-schaefer-noell.com">dennis.chong</a>
 * @version $Revision: 1484 $, $Date: 2013-09-12 16:40:43 +0200 (Do, 12 Sep 2013) $, $Author:
 *          dennis.chong $
 */
public class TT1411Subtype1010 extends TT1411 {

  public static TT1411 fromBytes(byte[] bytes, int offset) {
    TT1411Subtype1010 telegram = new TT1411Subtype1010();

    TT141xTOBlock toBlock = telegram.getToBlocks()[0];
    intoTOBlock(bytes, offset + 16, toBlock);

    TT141xTUBlock tuBlock = toBlock.getTuBlocks()[0];
    intoTUBlock(bytes, offset + 42, tuBlock);

    return telegram;
  }

  private static final long serialVersionUID = 1L;

  public TT1411Subtype1010() {
    super();
    subType = 1010;
  }

  @Override
  public int getNumberOfTOBlocks() {
    return 1;
  }

  @Override
  public int getNumberOfTUBlocks() {
    return 1;
  }
}
