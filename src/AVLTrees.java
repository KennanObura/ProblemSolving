import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.lang.Math.*;

public class AVLTrees {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.add(8);
        tree.add(12);
        tree.add(16);
//        tree.add(50);
        tree.preOrder();

        System.out.println("" + tree.balanceFactor());

    }
}


class AVLTree {
    private Node root;

    private class Node {
        int data;
        Node left;
        Node right;
        int height;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }


    void add(int data) {
        root = insert(root, data);
    }

    void preOrder() {
        preOrder(root);
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

    private Node insert(Node node, int data) {
        if (node == null)
            return new Node(data);
        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        else throw new RuntimeException("Duplicate key not allowed");
        return reBalance(node);
    }

    int balanceFactor() {
        return balanceFactor(root);
    }

    private int balanceFactor(Node node) {
        return (height(node.left) - height(node.right));
    }

    private int height(Node node) {
        return (node == null ? 0 : node.height);
    }

    private void updateHeight(Node node) {
//        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private Node reBalance(Node node) {
        updateHeight(node);
        if (balanceFactor() == 2) {
            if (node.right != null && height(node.right.right) <= height(node.right.left)) {
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        }
        if (balanceFactor() == -2) {
            if (node.left != null && height(node.left.left) <= height(node.left.right)) {
                node.left = rotateLeft(node.left);
            }
            node = rotateRight(node);
        }
        return node;
    }

    private Node rotateRight(Node node) {
        Node temp1 = node.left;
        Node temp2 = temp1.right;

        temp1.right = node;
        node.left = temp2;

        updateHeight(temp1);
        updateHeight(node);

        return temp1;
    }

    private Node rotateLeft(Node node) {
        Node temp1 = node.right;
        Node temp2 = temp1.left;

        temp1.left = node;
        node.right = temp2;

        updateHeight(node);
        updateHeight(temp1);
        return temp1;
    }
}