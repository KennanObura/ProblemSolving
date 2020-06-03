package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedGraphMain {
    public static void main(String[] args) {

        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);

        node40.addNeighbour(node10);
        node40.addNeighbour(node20);
        node10.addNeighbour(node30);
        node20.addNeighbour(node10);
        node20.addNeighbour(node30);
        node20.addNeighbour(node60);
        node20.addNeighbour(node50);
        node30.addNeighbour(node60);
        node60.addNeighbour(node70);
        node50.addNeighbour(node70);

        Search search = new Search(node40);
//        search.depth();
        search.breadth();


    }

    private static class Node {
        final int data;
        boolean visited;
        private final ArrayList<Node> neighbours;

        Node(int data) {
            this.data = data;
            this.visited = false;
            this.neighbours = new ArrayList<>();
        }

        public void addNeighbour(Node neighbour) {
            this.addNeighbour(this.neighbours, neighbour);
        }

        public ArrayList<Node> getNeighbours() {
            return this.neighbours;
        }

        private void addNeighbour(ArrayList<Node> adj, Node neighbour) {
            adj.add(neighbour);
        }
    }

    private static class Search {
        private final Node root;

        Search(Node root) {
            this.root = root;
        }

        void depth() {
            depth(this.root);
        }

        void breadth(){
            breadth(this.root);
        }

        private void depth(Node root) {
            if (root == null)
                return;
            root.visited = true;
            System.out.println("" + root.data);
            ArrayList<Node> neighbours = root.getNeighbours();
            for (Node neighbour : neighbours)
                if (neighbour != null && !neighbour.visited)
                    depth(neighbour);
        }

        private void breadth(Node root) {
            if (root == null) return;
            System.out.println("Breadth search");
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node temp = queue.remove();
                temp.visited = true;
                System.out.println(temp.data + "");

                ArrayList<Node> neighbours = temp.getNeighbours();

                for (Node neighbour : neighbours)
                    if (neighbour != null && !neighbour.visited) {
                        queue.add(neighbour);
                        neighbour.visited = true;
                    }
            }
        }
    }

}
