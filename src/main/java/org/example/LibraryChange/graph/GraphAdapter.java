package org.example.LibraryChange.graph;

import java.util.Collection;

import org.jgrapht.graph.SimpleDirectedGraph;

public class GraphAdapter implements GraphInterface<Integer> {
    private final SimpleDirectedGraph<Integer, String> graph;

    public GraphAdapter() {
        this.graph = new SimpleDirectedGraph<Integer, String>(String.class);
    }

    @Override
    public void addVertex(Integer vertex) {
        graph.addVertex(vertex);
    }

    @Override
    public void addEdge(String edge, Integer source, Integer target) {
        assert !graph.containsEdge(edge);
        assert !graph.containsEdge(source, target);
        graph.addEdge(source, target, edge);
    }

    @Override
    public Collection<Integer> getNeighbors(Integer vertex) {
        assert graph.containsVertex(vertex);
        return graph.edgesOf(vertex)
            .stream()
            .map(edge -> {
                Integer src = graph.getEdgeSource(edge), 
                        dest = graph.getEdgeTarget(edge);
                return src.equals(vertex) ? dest : src;
            }).toList();
    }    
}
