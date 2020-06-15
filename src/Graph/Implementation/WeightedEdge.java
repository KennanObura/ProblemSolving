package Graph.Implementation;

public class WeightedEdge<R> {
    Vertex<R> from;
    Vertex<R> to;
    int weight;

    WeightedEdge(Vertex<R> from, Vertex<R> to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("(%s -> %s, weight %o)", from.item, to.item, this.weight);
    }
}
