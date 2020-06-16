package TutorialHorizon;

/**
 * Do postorder traversal.
 * Check if the node is a leaf node (means node does not have either left or right child node), return true.
 * Check if the node has only one child (either left or right child node), return false.
 * Make a recursive call to the left and right child and do AND before returning the result.
 * See the image below for more understanding.
 */
public class BinaryIfFull {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.left.right = new Node(7);
//        root.left.right = new Node(15);
//        root.right.left = new Node(25);
//        root.right.right = new Node(35);
//        root.left.right.left = new Node(13);
//        root.left.right.right = new Node(18);

        Tree tree = new Tree(root);
        tree.binaryIsFull();
        tree.isComplete();

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

        private void binaryIsFull() {
            if (binaryIsFull(root)) System.out.println("Binary is full");
            else System.out.println("Binary is not full");
        }

        private void isComplete() {
            if (isComplete(root, 0, getNodeCount(root))) System.out.println("Binary is complete");
            else System.out.println("Binary is not complete");
        }

        private int getNodeCount(Node root) {
            if (root == null) return 0;
            return getNodeCount(root.left) + getNodeCount(root.right) + 1;
        }

        private boolean binaryIsFull(Node root) {
            if (root == null) return true;
            if (root.right != null && root.left == null || root.left != null && root.right == null)
                return false;

            return binaryIsFull(root.left) &&
                    binaryIsFull(root.right);
        }

        private boolean isComplete(Node root, int index, int nodeCount) {
            if (root == null) return true;
            if (index >= nodeCount) return false;
            return isComplete(root.left, 2 * index + 1, nodeCount) &&
                    isComplete(root.right, 2 * index + 2, nodeCount);
        }


    }
}
