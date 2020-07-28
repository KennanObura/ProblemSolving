package Binary;

import TutorialHorizon.Binary.BinaryNode;

public class CountLeafNodes {
    public static void main(String[] args) {
        BinaryNode node = new BinaryNode(40);
        node.left = new BinaryNode(20);
        node.right = new BinaryNode(60);
        node.left.left = new BinaryNode(10);
        node.left.left.left = new BinaryNode(5);
        node.left.right = new BinaryNode(30);
        node.right.left = new BinaryNode(50);
        node.right.left.right = new BinaryNode(55);
        node.right.right = new BinaryNode(70);

        Tree tree = new Tree(node);
        tree.countLeafNodes();
    }

    private static class Tree {
        private final BinaryNode root;

        private Tree(BinaryNode root) {
            this.root = root;
        }

        private void countLeafNodes() {
            int count = countLeafNodes(root);
            System.out.println(count + " Nodes");
        }

        private int countLeafNodes(BinaryNode root) {
            if (root == null) return 0;

            if (root.right == null && root.left == null)
                return 1;

            return countLeafNodes(root.left) + countLeafNodes(root.right);

        }

    }
}