
package com.eb.warehouse.graph;

import java.util.Set;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public interface Graph<T> {

  /**
   * TODO JavaDoc according to WAMAS C conventions
   *
   * @return
   */
  T getId();

  Set<T> getNodes();

  /**
   * TODO JavaDoc according to WAMAS C conventions
   *
   * @param string
   * @return
   */
  Set<T> getNodeEdges(T nodeId);

}

//---------------------------- Revision History ----------------------------
//$Log$
//
