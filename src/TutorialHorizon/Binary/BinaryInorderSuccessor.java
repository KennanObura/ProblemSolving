package TutorialHorizon.Binary;

public class BinaryInorderSuccessor {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.left.right = new Node(7);
        root.left.right = new Node(15);
        root.right.left = new Node(25);
        root.right.right = new Node(35);
        root.left.right.left = new Node(13);
        root.left.right.right = new Node(18);

        Tree tree = new Tree(root);
        tree.getSuccessor(20);
    }

    private static class Node {
        private Node left;
        private Node right;
        private final int val;

        Node(int val) {
            this.val = val;
        }
    }

    private static class Tree {
        private final Node root;

        Tree(Node root) {
            this.root = root;
        }

        void getSuccessor(int k) {
            Node successor = getSuccessor(root, k, null);
            System.out.println(successor.val);
        }

        private Node getSuccessor(Node root, int k, Node successor) {
            if (root == null) return successor;
            if (root.val == k && root.right != null)
                return getLeftMostChild(root.right);

            if (k < root.val) {
                successor = root;
                return getSuccessor(root.left, k, successor);
            }else
                return getSuccessor(root.right, k, successor);
        }

        private Node getLeftMostChild(Node node) {
            if (node == null) return null;
            if (node.left != null)
                return getLeftMostChild(node.left);
            return node;
        }
    }
}
