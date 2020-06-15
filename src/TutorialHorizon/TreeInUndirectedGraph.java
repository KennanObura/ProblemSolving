package TutorialHorizon;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Objective: Given an undirected graph, Write an algorithm to determine whether its tree or not.
 * <p>
 * An undirected graph is a tree if it has properties mentioned below
 * <p>
 * There is no cycle present in the graph.
 * The graph is connected. (All the vertices in the graph are connected)
 */
public class TreeInUndirectedGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 0);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);

//        graph.print();
        graph.isTree();

        System.out.println("=============================================");
        Graph graph2 = new Graph(5);
        graph2.addEdge(1, 0);
        graph2.addEdge(3, 1);
        graph2.addEdge(3, 2);

        graph2.isTree();
    }

    private static class Graph {
        private final int vertices;
        private LinkedList<Integer>[] neighbours;

        Graph(int vertices) {
            this.vertices = vertices;
            this.neighbours = new LinkedList[vertices];

            for (int i = 0; i < vertices; i++)
                neighbours[i] = new LinkedList<>();
        }

        private void addEdge(int source, int dest) {
            neighbours[source].addFirst(dest);

            //undirected
            neighbours[dest].addFirst(source);
        }

        private void print() {
            for (int i = 0; i < vertices; i++) {
                System.out.print(i + " is connected to ");
                for (Integer item : neighbours[i])
                    System.out.print(item);
                System.out.println("");
            }
        }

        private void isTree() {
            boolean[] visited = new boolean[vertices];
            if (isTree(visited)) System.out.println("Graph is a tree");
            else System.out.println("Graph is not a tree");
        }

        private boolean isTree(boolean[] visited) {
            if (isCyclic(visited, 0, -1)) {
                System.out.println("Is cyclic");
                return false;
            }

            for (int i = 0; i < vertices; i++)
                if (!visited[i]) return false;
            return true;
        }

        private boolean isCyclic(boolean[] visited, int index, int parent) {
//            if (visited[index]) return true;

            visited[index] = true;

            for (Integer item : neighbours[index]) {
                if (item != parent) {
                    if (visited[item]) return true;
                    else {
                        if (isCyclic(visited, item, index))
                            return true;
                    }
                }
            }
            return false;
        }
    }
}
