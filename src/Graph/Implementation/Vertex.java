package Graph.Implementation;

import java.util.LinkedList;
import java.util.List;


public class Vertex<R> {
    R item;
    Boolean visited;
    List<WeightedEdge<Integer>> edges;

    Vertex(R item) {
        this.item = item;
        this.visited = false;
        this.edges = new LinkedList<>();
    }

    @Override
    public String toString() {
        return String.format("(%s)", item);
    }

    void setEdges(List<WeightedEdge<Integer>> edges) {
        this.edges = edges;
    }

    List<WeightedEdge<Integer>> getEdges() {
        return this.edges;
    }
}

