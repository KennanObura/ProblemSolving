package TutorialHorizon.Binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Objective: Given a binary tree, write an algorithm to determine whether the tree is complete or not.
 *
 * Complete Binary Tree: A binary tree T with n levels is complete if all levels except possibly the last are
 * completely full, and the last level has all its nodes to the left side.
 *
 *    Example of not a complete Binary Tree
 *                 1
 *               /   \
 *              2     3
 *             / \     \
 *            4   5     6
 *
 *            Example of not a complete Binary Tree
 *                 1
 *               /   \
 *              2     3
 *             / \   /
 *            4   5 6
 *
 */
public class CompletenessOfBinaryTree {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        Tree tree = new Tree(root);
        tree.checkCompleteness();

    }

    private static class Node{
        Node left;
        Node right;
        final int data;

        Node(int data){
            this.data = data;
        }
    }

    private static class Tree {
        private final Node root;
        Tree(Node root){
            this.root = root;
        }

        void checkCompleteness(){
            if(isComplete(root)) System.out.println("Binary is complete");
            else System.out.println("Binary not complete");
        }

        private boolean isComplete(Node root) {
            if (root == null) return true;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            boolean isEnd = false;
            while (!queue.isEmpty()){
                Node temp = queue.remove();
                if(temp == null) //Found a null head, it should be the end in the queue
                    isEnd = true;

                else {
                    if(isEnd)
                        return false; //If there are other nodes and we already seen a null node ,
                    // its not complete
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
            }
            return isEnd;
        }
    }
}
