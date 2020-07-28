package java2blog.simple_graph;


import java.util.*;

public class GraphAsHashMap {
    public static void main(String[] args) {
        ArrayList<Node> vertices = new ArrayList<>();

        Node node40 = new Node(40);
        Node node30 = new Node(30);
        Node node20 = new Node(20);
        Node node10 = new Node(10);
        Node node50 = new Node(50);
        Node node60 = new Node(60);
        Node node70 = new Node(70);

        vertices.add(node40);
        vertices.add(node10);
        vertices.add(node20);
        vertices.add(node30);
        vertices.add(node50);
        vertices.add(node60);
        vertices.add(node70);

        Graph graph = new Graph(vertices, false);

        graph.addEdge(node40, node10);
        graph.addEdge(node40, node20);

        graph.addEdge(node10, node30);
        graph.addEdge(node20,node10);
        graph.addEdge(node20,node30);
        graph.addEdge(node20,node60);
        graph.addEdge(node20,node50);

        graph.addEdge(node50,node70);
        graph.addEdge(node30,node60);
        graph.addEdge(node60,node70);

//        graph.doDFSTraversal(node30);
        graph.doDFSTraversalIterative(node40);
    }

    private static class Node {
        private final int val;
        private boolean visited = false;

        Node(int val) {
            this.val = val;
        }
    }


    private static class Graph {

        private Graph(ArrayList<Node> vertices, boolean isDirected) {
            this.edges = new HashMap<>();
            this.isDirected = isDirected;

            for (Node vertex : vertices)
                edges.put(vertex, new LinkedList<>());

        }

        private final Map<Node, LinkedList<Node>> edges;
        private final boolean isDirected;


        void addEdge(Node source, Node destination) {
            add(source, destination);

            if (!isDirected)
                add(destination, source);
        }

        void add(Node source, Node destination) {
            LinkedList<Node> neigbnours = edges.get(source);

            //Avoid adding duplicate edge
            if (!neigbnours.contains(destination)) {
                neigbnours.addFirst(destination);
                edges.put(source, neigbnours);
            }
        }


        private void doDFSTraversal(Node node) {
            if (node == null) return;
            node.visited = true;

            System.out.println(node.val + " ");

            LinkedList<Node> neigbours = edges.get(node);
            for (Node neighbour : neigbours)
                if (!neighbour.visited)
                    doDFSTraversal(neighbour);

        }

        private void doDFSTraversalIterative(Node root){
            if (root == null) return;

            Stack<Node> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()){
                Node node = stack.pop();

                if(!node.visited) {
                    node.visited = true;
                    System.out.println(node.val + " Node");
                }

                LinkedList<Node> neighbors = edges.get(node);
                for(Node neighbor : neighbors)
                    if(neighbor != null && !neighbor.visited)
                        stack.push(neighbor);

            }
        }
    }
}
