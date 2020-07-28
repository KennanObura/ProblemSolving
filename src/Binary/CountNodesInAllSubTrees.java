package Binary;

public class CountNodesInAllSubTrees {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(1);

        root.right = new Node(50);
        root.right.left = new Node(40);
        root.right.right = new Node(100);


        Tree tree = new Tree(root);
        tree.solution();
    }

    static private class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    static private class Tree {

        private final Node root;

        Tree(Node root) {
            this.root = root;
        }

        void solution(){
            solution(root);
        }

        private void solution(Node root) {
            if(root == null) return;
            
            int count = countNodes(root, 0);
            System.out.println(root.data +" , "+ count);

            if(root.left != null) {
                count = countNodes(root.left, 0);
                System.out.println(root.left.data +" , "+ count);
                solution(root.left);
            }
            if(root.right != null){
                count = countNodes(root.right , 0);
                System.out.println(root.right.data +" , "+ count);
                solution(root.right);
            }
        }

        private int countNodes(Node node, int count) {
            if(node == null) return 0;
            count++;

            if(node.left != null)
                count = countNodes(node.left, count);
            if(node.right != null)
               count = countNodes(node.right, count);
            return count;
        }
    }
}

