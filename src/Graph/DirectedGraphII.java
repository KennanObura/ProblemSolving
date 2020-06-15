package Graph;

import java.util.*;

public class DirectedGraphII {
    public static void main(String[] args) {

        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);

//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(1, 4);
//        graph.addEdge(2, 3);
//        graph.addEdge(3, 4);
//        graph.addEdge(3, 5);

        Search search = new Search(graph);
        search.print();
//        search.depth();
//        search.breadth();


    }

    private static class Graph {
        int vertices;
        LinkedList<Integer>[] adj;

        Graph(int vertices) {
            this.vertices = vertices;

            adj = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++)
                adj[i] = new LinkedList<Integer>();
        }

        void addEdge(int source, int destination) {
            adj[source].addFirst(destination);

            //for undirected graph also add link back
            adj[destination].addFirst(source);
        }
    }

    private static class Search {

        private final Graph graph;

        Search(Graph graph) {
            this.graph = graph;
        }

        void print() {
            print(graph);
        }

        private void print(Graph graph) {
            for (int i = 0; i < graph.vertices; i++) {
                if (graph.adj[i].size() > 0) {
                    System.out.print("Vertex " + i + " is connected to: ");
                    for (int j = 0; j < graph.adj[i].size(); j++) {
                        System.out.print(graph.adj[i].get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

}
