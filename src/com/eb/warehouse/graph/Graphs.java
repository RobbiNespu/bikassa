
package com.eb.warehouse.graph;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Map;
import java.util.Set;

import org.assertj.core.util.Maps;

import com.google.common.base.MoreObjects;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

/**
 * <p>
 * Usage: TODO add some usage examples.
 * </p>
 */

public class Graphs {

  public static interface GraphBuilder<T> {

    /**
     * TODO JavaDoc according to WAMAS C conventions
     *
     * @param string
     * @return
     */
    GraphNodeBuilder<T> withNode(T nodeId);

    /**
     * TODO JavaDoc according to WAMAS C conventions
     *
     * @return
     */
    Graph<T> build();

  }

  public static interface GraphNodeBuilder<T> extends GraphBuilder<T> {

    /**
     * TODO JavaDoc according to WAMAS C conventions
     * 
     * @param weight
     * @param string
     * @return
     */
    GraphNodeBuilder<T> withEdge(T edgeId, int weight);

    /**
     * TODO JavaDoc according to WAMAS C conventions
     *
     * @return
     */
    @Override
    Graph<T> build();

  }

  private static final class Builder<T> implements GraphBuilder<T>, GraphNodeBuilder<T> {

    private final T graphId;
    private final Set<T> nodeIds = Sets.newHashSet();
    private final SetMultimap<T, T> connections = HashMultimap.create();
    private final Map<T, Integer> edgeWeights = Maps.newHashMap();
    private T currentNodeId;

    /**
     * TODO JavaDoc according to WAMAS C conventions
     *
     * @param graphId
     */
    public Builder(T graphId) {
      this.graphId = graphId;
    }

    /** {@inheritDoc} */
    @Override
    public GraphNodeBuilder<T> withNode(T nodeId) {
      checkArgument(!nodeIds.contains(nodeId), "Already defined node '" + nodeId + "'.");
      nodeIds.add(nodeId);
      currentNodeId = nodeId;
      return this;
    }

    /** {@inheritDoc} */
    @Override
    public GraphNodeBuilder<T> withEdge(T edgeId, int weight) {
      connections.put(currentNodeId, edgeId);
      edgeWeights.put(edgeId, weight);
      return this;
    }

    /** {@inheritDoc} */
    @Override
    public Graph<T> build() {
      return new SetMultimapGraph<T>(graphId, connections);
    }

  }

  private static final class SetMultimapGraph<T> implements Graph<T> {

    private final T graphId;
    private final SetMultimap<T, T> nodeEdges;

    public SetMultimapGraph(T graphId, SetMultimap<T, T> nodeEdges) {
      this.graphId = graphId;
      this.nodeEdges = ImmutableSetMultimap.copyOf(nodeEdges);
    }

    /** {@inheritDoc} */
    @Override
    public T getId() {
      return graphId;
    }

    /** {@inheritDoc} */
    @Override
    public Set<T> getNodeEdges(T nodeId) {
      return nodeEdges.get(nodeId);
    }

    /** {@inheritDoc} */
    @Override
    public Set<T> getNodes() {
      return nodeEdges.keySet();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("id", graphId).add("nodeEdges", nodeEdges).toString();
    }
  }

  /**
   * TODO JavaDoc according to WAMAS C conventions
   *
   * @return
   */
  public static <T> GraphBuilder<T> newGraph(T graphId) {
    return new Builder<T>(graphId);
  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//
