package Graph.revesion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        Graph graph = new Graph(false);
        graph.add(node1, node2, 3);
        graph.add(node1, node4, 3);
        graph.add(node2, node3, 5);
        graph.add(node5, node6, 6);
//        graph.add(node1, node6, 10);
        graph.add(node1, node5, 5);
        graph.add(node4, node5, 2);
        graph.add(node3, node6, 6);

        graph.print();


    }

    private static final class NodeEdge {
        int weight;
        Node nodeFrom;
        Node nodeTo;

        NodeEdge(Node nodeFrom, Node nodeTo, int weight) {
            this.weight = weight;
            this.nodeFrom = nodeFrom;
            this.nodeTo = nodeTo;
        }

        @Override
        public String toString() {
            return String.format("[%s -> %s, %o]", this.nodeFrom, this.nodeTo, this.weight);
        }
    }

    private static class Node {
        boolean visited;
        int item;
        LinkedList<NodeEdge> edges;

        Node(int item) {
            this.item = item;
            this.visited = false;
            edges = new LinkedList<>();
        }

        void insert(NodeEdge edge) {
            this.edges.addFirst(edge);
        }

        @Override
        public String toString() {
            return String.format("[%s]", item);
        }
    }

    private static class Graph {
        private boolean directed;
        private Set<Node> nodes;

        Graph(boolean directed) {
            this.directed = directed;
            nodes = new HashSet<>();
        }

        void add(Node source, Node dest, int weight) {
            nodes.add(source);
            nodes.add(dest);

            createEdge(source, dest, weight);

            if (!directed && source != dest)
                createEdge(dest, source, weight);
        }

        private void createEdge(Node source, Node dest, int weight) {
            // go through the edges to scan for repeated edge
            for (NodeEdge item : source.edges)
                if (item.nodeFrom == source && item.nodeTo == dest) {
                    item.weight = weight;
                    return;
                }

            source.insert(new NodeEdge(source, dest, weight));
        }

        void print() {
            print(nodes);
        }

        private void print(Set<Node> nodes) {
            for (Node node : nodes) {
                System.out.print("Node ::" + node.item);
                if (node.edges.isEmpty()) {
                    System.out.print("has no edge");
                    continue;
                } else
                    for (NodeEdge edge : node.edges)
                        System.out.print(edge + " ,");

                System.out.println();
            }
        }
    }
}
