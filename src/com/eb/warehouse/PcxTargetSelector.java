package com.eb.warehouse;

import com.google.common.base.Optional;

import com.eb.warehouse.io.pcx.message.Announce;
import com.eb.warehouse.io.pcx.message.ResponseQuery;

import java.util.Set;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public interface PcxTargetSelector {

  /**
   * Select a target out of the provided ones for the received PCX query. <p> Return {@link
   * Optional#absent()} if no {@link Announce} should be sent to the hardware. In that case box
   * might wait at the station or proceed automatically depending on hardware configuration. </p>
   *
   * @param stationId TODO
   */
  Optional<String> selectTarget(String stationId, Set<String> targets, ResponseQuery query);

}
