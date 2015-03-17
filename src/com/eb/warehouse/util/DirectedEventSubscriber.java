
package com.eb.warehouse.util;

import java.util.Set;

/**
 * <p>
 * Provides the senders the event subscriber accepts for incoming events.
 * </p>
 */

public interface DirectedEventSubscriber {

  /**
   * Get all sender identifiers for those incoming events are accepted by this instance.
   *
   * @return
   */
  Set<String> acceptedQueues();
}
