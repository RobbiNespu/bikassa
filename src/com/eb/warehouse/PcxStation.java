
package com.eb.warehouse;

import java.util.Set;

/**
 * <p>
 * Used to make Guice happy.
 * </p>
 */

public interface PcxStation {

  String getStationId();
  
  Set<String> getTargets();
}
