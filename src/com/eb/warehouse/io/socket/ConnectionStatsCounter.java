package com.eb.warehouse.io.socket;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

interface ConnectionStatsCounter {

  void incrementReceivedBytes();

  void incrementReceivedBytes(long bytes);

  void incrementSentBytes();

  /**
   * TODO JavaDoc according to WAMAS C conventions
   */
  void incrementSentBytes(long bytes);

  void incrementSocketConnectAttempts();

  /**
   * TODO JavaDoc according to WAMAS C conventions
   */
  void incrementSuccessfulSocketConnects();

  /**
   * TODO JavaDoc according to WAMAS C conventions
   */
  void incrementFailedSocketConnects();
}
