package org.example.AdapterImplementation.graph;

import java.util.Collection;

import edu.uci.ics.jung.graph.SparseMultigraph;

public class GraphAdapter implements GraphInterface<Integer> {
    private final SparseMultigraph<Integer, String> graph;

    public GraphAdapter() {
        this.graph = new SparseMultigraph<>();
    }

    @Override
    public void addVertex(Integer vertex) {
        graph.addVertex(vertex);
    }

    @Override
    public void addEdge(String edge, Integer source, Integer target) {
        assert !graph.getEdges().contains(edge);
        assert graph.findEdge(source, target) == null;
        graph.addEdge(edge, source, target);
    }

    @Override
    public Collection<Integer> getNeighbors(Integer vertex) {
        assert graph.getVertices().contains(vertex);
        return graph.getNeighbors(vertex);
    }    
}
