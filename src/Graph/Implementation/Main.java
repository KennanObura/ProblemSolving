package Graph.Implementation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Vertex<Integer> vertex1 = new Vertex<>(1);
        Vertex<Integer> vertex2 = new Vertex<>(2);
        Vertex<Integer> vertex3 = new Vertex<>(3);
        Vertex<Integer> vertex4 = new Vertex<>(4);
        Vertex<Integer> vertex5 = new Vertex<>(5);
        Vertex<Integer> vertex6 = new Vertex<>(6);


        Graph graph = new Graph(false);
        graph.addEdge(vertex1, vertex2, 3);
        graph.addEdge(vertex2, vertex4, 2);
        graph.addEdge(vertex4, vertex5, 6);
        graph.addEdge(vertex2, vertex3, 1);
        graph.addEdge(vertex3, vertex6, 4);
//        graph.addEdge(vertex2, vertex5, 2);
//        graph.addEdge(vertex4, vertex5, 2);
//        graph.addEdge(vertex5, vertex6, 2);
//        graph.print();


        Traverse traverse = new Traverse(graph);
//        traverse.depthSearch(vertex1);
//        traverse.breadthSearch(vertex1);

        System.out.println(traverse.isReachable(vertex5, vertex6) + " ");


    }

    private static class Graph {
        private Set<Vertex<Integer>> vertices;
        private final boolean directed;


        Graph(boolean directed) {
            this.directed = directed;
            this.vertices = new HashSet<>();
        }

        public void addNodes(Vertex<Integer>... n) {
            vertices.addAll(Arrays.asList(n));
        }

        public void addEdge(Vertex<Integer> source, Vertex<Integer> destination, int weight) {
            vertices.add(source);
            vertices.add(destination);

            //we use addEdgeHelper to make sure we dont duplicate an edge
            this.addEdgeHelper(source, destination, weight);

            if (!directed && source != destination)
                this.addEdgeHelper(destination, source, weight);

        }

        private void addEdgeHelper(Vertex<Integer> source, Vertex<Integer> destination, int weight) {
            // Go through all the edges and see whether that edge has
            // already been added
            for (WeightedEdge<Integer> item : source.edges)
                if (item.from == source && item.to == destination) {
                    item.weight = weight;
                    return;
                }
//            if new just add a new edge
            source.edges.add(new WeightedEdge<>(source, destination, weight));
        }


        private void print() {
            for (Vertex<Integer> vertex : this.vertices) {
                List<WeightedEdge<Integer>> edges = vertex.edges;

                if (edges.isEmpty()) continue;

                System.out.print(vertex + " is connected to");

                for (WeightedEdge<Integer> edge : edges)
                    System.out.print(edge);
                System.out.println();

            }
        }

    }

    private static class Traverse {
        private final Graph graph;

        Traverse(Graph graph) {
            this.graph = graph;
        }

        void depthSearch(Vertex<Integer> root) {
            this.depthSearch(graph, root);
        }

        private void depthSearch(Graph graph, Vertex<Integer> root) {
            if (root == null)
                return;
            root.visited = true;
            System.out.print(root + " ");
            for (WeightedEdge<Integer> edge : root.edges) {
                if (!edge.to.visited)
                    depthSearch(edge.to);
            }
        }

        private void breadthSearch(Vertex<Integer> root) {
            if (root == null) return;

            Queue<Vertex<Integer>> queue = new LinkedList<>();
            queue.add(root);

            root.visited = true;
            while (!queue.isEmpty()) {
                Vertex<Integer> temp = queue.remove();
                System.out.println(temp + " ");

                for (WeightedEdge<Integer> edge : temp.edges)
                    if (!edge.to.visited) {
                        queue.add(edge.to);
                        edge.to.visited = true;
                    }
            }
        }


        private boolean isReachable(Vertex<Integer> source, Vertex<Integer> destination) {
            if (source == null || destination == null)
                throw new RuntimeException("Either source or destinations are unknown");


            if (source.equals(destination) && destination.visited) return true;
//
                source.visited = true;

            for (WeightedEdge<Integer> edge : source.edges)
                if (!edge.to.visited)
                    return isReachable(edge.to, destination);

            return source.equals(destination) && destination.visited;
        }
    }

    private static class DijkstraAlgorithm {

        //        private final List<WeightedEdge<Integer>> edges;
        //        private final List<Vertex<Integer>> vertices;
        private Set<Vertex<Integer>> settled;
        private Set<Vertex<Integer>> unsettled;

        DijkstraAlgorithm(Graph graph) {
//            this.edges = new ArrayList<>(graph.getEdges());
//            this.vertices = new ArrayList<>(graph.getVertices());
        }

    }
}
