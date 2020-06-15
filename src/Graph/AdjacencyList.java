package Graph;

import java.util.LinkedList;

public class AdjacencyList {
    public static void main(String[] args) {

        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 2);

        graph.isCyclic();

        System.out.println(graph.getDistanceBetween(0, 3) + " ");

    }

    private static class Graph {
        private int vertices;
        private LinkedList<Integer>[] neighbours;
        private boolean[] visited;

        Graph(int vertices) {
            this.vertices = vertices;
            this.neighbours = new LinkedList[vertices];

            for (int i = 0; i < vertices; i++)
                neighbours[i] = new LinkedList<>();
            this.visited = new boolean[vertices];
        }

        void addEdge(int source, int dest) {
            neighbours[source].addFirst(dest);

            // undirected
            neighbours[dest].addFirst(source);
        }

        void print() {
            for (int i = 0; i < neighbours.length; i++) {
                System.out.print(i + " is connected to :");
                for (Integer item : neighbours[i])
                    System.out.print(item + " ");
                System.out.println();
            }
        }

        void isCyclic() {
            if (findCycle()) System.out.println(" Has a cycle");
            else System.out.println(" Has no cycle");
        }

        int getDistanceBetween(int source, int dest) {
            boolean[] calculated = new boolean[vertices];
            return getDistanceBetween(source, dest, calculated, 0, -1);
        }

        private int getDistanceBetween(int source, int dest, boolean[] calculated, int distance, int parent) {
            calculated[source] = true;

            if (source == dest)
                return distance;

            for (int i = 0; i < neighbours[source].size(); i++) {
                int current = neighbours[source].get(i);
                if (current == parent) {
                    distance--;
                    continue;
                }

                distance++;
                if (!calculated[current])
                    return getDistanceBetween(current, dest, calculated, distance, source);

            }
            return distance;
        }

        private boolean findCycle() {
            //do dfs for each item
            for (int i = 0; i < vertices; i++) {
                if (!visited[i] && findCycle(i, -1))
                    return true;
            }
            return false;
        }

        private boolean findCycle(int node, int parent) {
            visited[node] = true;
            for (int i = 0; i < neighbours[node].size(); i++) {
                int current = neighbours[node].get(i);
                if (current != parent)
                    if (visited[current]) return true;
                    else {
                        if (findCycle(current, node)) return true;
                    }
            }
            return false;
        }
    }
}
