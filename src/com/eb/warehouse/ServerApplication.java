
package com.eb.warehouse;

/**
 * <p>
 * The long-running server application that runs the whole system and is instantiated in the
 * <code>static void main(...)</code> method.
 * </p>
 */

public interface ServerApplication {

  /**
   * Run the server application.
   * <p>
   * This method blocks until the server application should be shutdown.
   * </p>
   */
  void run2();

}

//---------------------------- Revision History ----------------------------
//$Log$
//
