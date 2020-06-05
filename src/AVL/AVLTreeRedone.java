package AVL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AVLTreeRedone {
    public static void main(String[] args) {

        BalancedTree balancedTree = new BalancedTree();
        balancedTree.insert(8);
        balancedTree.insert(9);
        balancedTree.insert(10);
        balancedTree.insert(12);
        balancedTree.insert(11);

        balancedTree.printBreadth();

        System.out.println("Pre order print");
        balancedTree.preOrder();
    }
}

class BalancedTree {
    private Node root;

    private class Node {
        Node left, right;
        int data, height;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    void insert(int num) {
        root = insert(root, num);
    }

    void preOrder() {
        preOrder(root);
    }

    void printBreadth(){
        printBreadth(root);
    }

    private void preOrder(Node node) {
        Stack<Node> stack = new Stack<>();

        stack.add(node);

        while (!stack.isEmpty()) {
            Node temp = stack.pop();

            System.out.println(temp.data + "");
            if (temp.left != null)
                preOrder(temp.left);
            if (temp.right != null)
                preOrder(temp.right);
        }
    }

    private Node insert(Node root, int num) {
        if (root == null) return new Node(num);
        if (num < root.data) root.left = insert(root.left, num);
        if (num > root.data) root.right = insert(root.right, num);
//        else throw new RuntimeException("Duplicate not allowed");
        this.updateHeight(root);
        return reBalance(root, num);
    }

    private void updateHeight(Node node) {
        node.height = Math.max(height(node.left), height(node.right));
    }

    private Node reBalance(Node root, int num) {
        int balanceFactor = balanceFactor(root);
        /*
         * left left case
         */
        if (balanceFactor > 1 && num < root.left.data) {
            return rotateRight(root);
        } // rotate right

        /*
         * right right case
         */
        if (balanceFactor < -1 && num > root.right.data) {
            return rotateLeft(root);

        }//                rotate left

        /*
         *left right case
         *
         */
        if (balanceFactor > 1 && num > root.left.data) {

            root.left = rotateLeft(root.left);
            return rotateRight(root);

        } // Double rotate


        /*
         * right left case
         *
         */
        if (balanceFactor < -1 && num < root.right.data) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        } // Double rotate

        return root;
    }

    private Node rotateRight(Node node) {
        Node temp = node.left;
        Node temp2 = temp.right;

        //rotate
        temp.right = node;
        node.left = temp2;

        updateHeight(node);
        updateHeight(temp);

        return temp;
    }

    private Node rotateLeft(Node node) {
        Node temp = node.right;
        Node temp2 = temp.left;

        //rotate
        temp.left = node;
        node.right = temp2;

        updateHeight(node);
        updateHeight(temp);

        return temp;
    }

    private int balanceFactor(Node root) {
        return (height(root.left) - height(root.right));
    }

    private int height(Node node) {
        return (node == null ? 0 : node.height);
    }

    private void printBreadth(Node current){
        Queue<Node> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()){
            Node temp = queue.remove();
            System.out.println(temp.data + " -");
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }
    }
}