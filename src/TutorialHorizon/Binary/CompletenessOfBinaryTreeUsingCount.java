package TutorialHorizon.Binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Objective: Given a binary tree, write an algorithm to determine whether the tree is complete or not.
 * <p>
 * Complete Binary Tree: A binary tree T with n levels is complete if all levels except possibly the last are
 * completely full, and the last level has all its nodes to the left side.
 * <p>
 * Example of not a complete Binary Tree
 * 1
 * /   \
 * 2     3
 * / \     \
 * 4   5     6
 * <p>
 * Example of not a complete Binary Tree
 * 1
 * /   \
 * 2     3
 * / \   /
 * 4   5 6
 */
public class CompletenessOfBinaryTreeUsingCount {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        Tree tree = new Tree(root);
        tree.checkCompleteness();

    }

    private static class Node {
        Node left;
        Node right;
        final int data;

        Node(int data) {
            this.data = data;
        }
    }

    private static class Tree {
        private final Node root;

        Tree(Node root) {
            this.root = root;
        }

        void checkCompleteness() {
            if (isComplete(root)) System.out.println("Binary is complete");
            else System.out.println("Binary not complete");
        }

        /**
         * Approach: Use Nodes count
         * <p>
         * Count the number of nodes in the tree.
         * Now start assigning indexes to tree nodes starting from the root (index 0) and at each level increase the index from left to right.
         * If at any node assigned index is greater than the node count, that means the tree is not constructed in the right manner to be called a complete tree, return false.
         * If all the tree nodes are successfully assigned indexes and at each node, the index is less than node count then it means the tree is complete, return true.
         * See the image below for more understanding.
         *
         * @param root
         * @return
         */


        private boolean isComplete(Node root) {
            if (root == null) return true;
            int nodeCount = nodeCount(root);
            return isComplete(root, nodeCount, 0);
        }

        private boolean isComplete(Node root, int nodeCount, int index) {
            if (root == null) return true;
            if (index >= nodeCount) return false;
            int left_index = 2 * index + 1;
            int right_index = 2 * index + 2;
            return isComplete(root.left, nodeCount, left_index) && isComplete(root.right, nodeCount, right_index);
        }

        private int nodeCount(Node root) {
            if (root == null) return 0;
            return nodeCount(root.left) + nodeCount(root.right) + 1;
        }
    }
}
