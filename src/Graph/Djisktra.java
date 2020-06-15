package Graph;

public class Djisktra {
    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
//        ShortestPath t = new ShortestPath();
//        t.dijkstra(graph, 0);
    }

    private static class ShortestPath {
        private final int[][] graph;
        private final int V;

        ShortestPath(int[][] graph) {
            this.V = graph.length;
            this.graph = graph;
        }

        void printSolution(int dist[], int n) {
            System.out.println("Vertex   Distance from Source");
            for (int i = 0; i < V; i++)
                System.out.println(i + " tt " + dist[i]);
        }

        void getPath(){

        }
    }

}
