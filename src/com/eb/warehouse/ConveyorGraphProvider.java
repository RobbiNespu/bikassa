package com.eb.warehouse;

import com.google.inject.Provider;

import com.eb.warehouse.graph.Graph;
import com.eb.warehouse.graph.Graphs;
import com.eb.warehouse.graph.Graphs.GraphBuilder;
import com.eb.warehouse.graph.Graphs.GraphNodeBuilder;

import java.util.Collection;

/**
 * <p> Usage: TODO add some usage examples. </p>
 */

public class ConveyorGraphProvider implements Provider<Graph<String>> {

  private final Collection<PcxStation> pcxStations;
  //private final Map<String, Integer> targetTuPositionCount;

  public ConveyorGraphProvider(Collection<PcxStation> pcxStations) {
    this.pcxStations = pcxStations;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Graph<String> get() {
    GraphBuilder<String> graphBuilder = Graphs.newGraph("conveyor");
    for (PcxStation station : pcxStations) {
      GraphNodeBuilder<String> nodeBuilder = graphBuilder.withNode(station.getStationId());
      for (String target : station.getTargets()) {
//        int targetTuPosCount = targetTuPositionCount.get(target);
//        nodeBuilder.withEdge(target, targetTuPosCount);
      }
    }
    return graphBuilder.build();
  }

}
