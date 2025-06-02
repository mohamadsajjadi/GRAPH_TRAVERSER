package org.example.AdapterImplementation.graph;

import java.util.Collection;

public interface GraphInterface<V> {
    void addVertex(V vertex);

    void addEdge(String edge, V source, V target);
    
    Collection<V> getNeighbors(V vertex);
}
