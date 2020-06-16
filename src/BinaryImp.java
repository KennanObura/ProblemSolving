
import kotlin.Pair;

import java.util.*;
import java.util.LinkedList;


public class BinaryImp {
    public static void main(String[] args) {
        Binary binary = new Binary();
        binary.add(40);
        binary.add(20);
        binary.add(10);
        binary.add(30);
        binary.add(60);
        binary.add(50);
        binary.add(100);

//        binary.preOrderPrintPaths();
        binary.printSpiralLevels();

//        System.out.println(binary.averageOfLevelNodes() + "");

//        binary.inOrderTraversal();
//        binary.inOrderTraversalItr();
//        TreeMap<Integer, Integer> map = binary.sumOfVertical();

//        for (Map.Entry<Integer, Integer> item : map.entrySet())
//            System.out.println(item.getKey() + " sum:" + item.getValue());
//        System.out.println( + "");
//        binary.Node = binary.successorSearch(20);
//        System.out.print(binary.successorSearch(100) + ": success");
    }
}

class Binary {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    void add(int data) {
        root = insert(root, data);
    }

    boolean preOrderSearch(int KEY) {
        return preOrderSearch(root, KEY);
    }

    ArrayList<Double> averageOfLevelNodes() {
        return averageOfLevelNodes(root);
    }

    void printNodeLevels() {
        printNodeLevels(root);
    }

    void printSpiralLevels() {
        printSpiralLevels(root);
    }


    //wrong.
//    Use two stacks, one temp stack inside main while
    private void printSpiralLevels(Node root) {
        if (root == null) return;

        Stack<Node> queue = new Stack<>();
        queue.add(root);
        boolean direction = false;
        while (!queue.isEmpty()) {
            Node temp = queue.pop();
            System.out.println(temp.data);
            if (!direction) {
                if (temp.left != null)
                    queue.push(temp.left);
                if (temp.right != null)
                    queue.push(temp.right);
                direction = true;
            } else {
                if (temp.right != null)
                    queue.push(temp.right);
                if (temp.left != null)
                    queue.push(temp.left);
                direction = false;
            }
        }
    }

    void inOrderTraversalItr() {
        inOrderTraversalItr(root);
    }

    void inOrderTraversal() {
        inOrderTraversal(root);
    }

    void preOrderPrintPaths() {
        int[] list = new int[100];
        preOrderPrintPaths(root, list, 0);

    }

    TreeMap<Integer, Integer> sumOfVertical() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        sumOfVertical(root, 0, map);
        return map;
    }


    void levelTraversal() {
        levelTraversal(root);
    }

    int successorSearch(int input) {
        return successorSearch(root, input, -1);
    }

    /**
     * SUCCESSOR SEARCH I
     * <p>
     * The idea is to do a recursive call till Key is found
     * <p>
     * - if Key is found and has right Node (node.right != null)
     * do recursive call to on left to find the least node
     * <p>
     * - if Key lies on the left side
     * update the the parent as the successor
     * then do recursive call on the method (node.left)
     * <p>
     * - if Key lies on the right
     * Just do recursive call on method (node.right)
     * <p>
     * return successor
     *
     * @param current
     * @param input
     * @param successor
     * @return
     */

    int successorSearch(Node current, int input, int successor) {
        if (current == null)
            return successor;
        if (input == current.data && current.right != null)
            return getLeftMostNode(current.right);
        else if (input < current.data) {
            successor = current.data;
            return successorSearch(current.left, input, successor);
        } else
            return successorSearch(current.right, input, successor);
    }


    /**
     * SUCCESSOR SEARCH II
     * Assumption <>
     * in a BST , successor will lie at the right if the right node exist
     * since the BST is sorted.
     * <p>
     * 1. Do a normal inOrder search till key is found.
     * 2. If Key Node if found
     * if has Right child node
     * Traverse to right, Then do recursive left traversal till the node is null.
     * The node will be the least in the right node. return it
     * if Left node, return the immediate right as this is the successor
     * If No such
     * Parent is the successor.
     * <p>
     * 4
     * /\
     * 2     6
     * /\    /
     * 1  3  5
     *
     * @param current
     * @param input
     * @return
     */
    private int successorSearch(Node current, int input) {

        Node keyNode = findNode(current, input);

        if (keyNode.right != null)
            return getLeftMostNode(keyNode.right);
        return nextGreaterEfficient(current, input, 0);
    }

    private Node findNode(Node current, int input) {
        if (current == null)
            return null;
        if (current.data == input)
            return current;

        Node left = null;
        if (current.left != null)
            left = findNode(current.left, input);

        Node right = null;
        if (current.right != null)
            right = findNode(current.right, input);

        if (left == null && right == null)
            return null;

        if (left != null)
            return left;
        return right;
    }

    int nextGreaterEfficient(Node node, int target, int nextLarge) {
        if (node == null)
            return nextLarge;

        /* when we find a node having value greater than the target
         * node, then there is no point in going right side,
         * as we will only find nodes having value greater than this
         * node, therefore we update the final answer and move to left
         * subtree
         *
         */
        if (node.data > target) {
            nextLarge = node.data;
            return nextGreaterEfficient(node.left, target, nextLarge);
        } else
            return nextGreaterEfficient(node.right, target, nextLarge);
    }

    private int getLeftMostNode(Node node) {
        if (node.left != null)
            return getLeftMostNode(node.left);
        return node.data;
    }

    private boolean preOrderSearch(Node current, int KEY) {
        if (current == null)
            return false;

        if (current.data == KEY)
            return true;
        System.out.println("" + current.data);
        if (KEY < current.data) {
            if (current.left != null)
                return preOrderSearch(current.left, KEY);
        } else {
            if (current.right != null)
                return preOrderSearch(current.right, KEY);
        }

        return false;
    }


    private void levelTraversal(Node current) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(current);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            System.out.println(" " + temp.data);
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    /**
     * 1. def queue
     * 2. def arraylist averages to store average of levels
     * 3. add the head to the queues
     * 4. do a while loop if queue not empty
     * <p>
     * - count == queue size
     * for loop till count
     * *  queue poll
     * *  calculate sum
     * *  check if left/ right not null.. add to queue
     * - add average (sum/count) to list
     *
     * @param current
     * @return
     */
    private ArrayList<Double> averageOfLevelNodes(Node current) {
        ArrayList<Double> averages = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            int count = queue.size();
            int sum = 0;

            for (int i = 0; i < count; i++) {
                Node temp = queue.remove();
                sum += temp.data;
                System.out.println(" " + sum);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            averages.add(sum / (double) count);
        }
        return averages;
    }

    /**
     * Def a queue that holds Pair<Node and level>
     * add the head node to the queue
     * <p>
     * do a while loop when queue not empty
     * queue poll and increment the Pair<Level>
     * add left/right when not null
     *
     * @param current
     */

    private void printNodeLevels(Node current) {
        if (current == null) {
            System.out.println("Level:  0");
            return;
        }

        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(current, 1));

        while (!queue.isEmpty()) {
            Pair<Node, Integer> pair = queue.remove();
            System.out.println(pair.getFirst() + " is at Level :" + pair.getSecond());
            if (pair.getFirst().left != null)
                queue.add(new Pair<>(pair.getFirst().left, pair.getSecond() + 1));
            if (pair.getFirst().right != null)
                queue.add(new Pair<>(pair.getFirst().right, pair.getSecond() + 1));
        }
    }

    private void inOrderTraversalItr(Node root) {
        Stack<Node> stack = new Stack<>();

        Node current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                Node temp = stack.pop();
                System.out.println(temp.data + "");
                current = temp.right;
            }
        }
    }


    private void inOrderTraversal(Node current) {
        if (current == null)
            return;

        if (current.left != null)
            inOrderTraversal(current.left);
        System.out.println("" + current.data);
        if (current.right != null)
            inOrderTraversal(current.right);
    }

    /**
     * Do an inOrder Traversal
     * 1. Def level = 0;
     * 2. Def a TreeMap (WIll sort in order of -2,-1,0,1,2) TreeMap(level, sum+=node.data)
     * 3. Recursively
     * stop when node == null
     * <p>
     * do level-- when visiting left
     * <p>
     * <In TreeMap>
     * update sum (sum+node.data) if level is already seen
     * otherwise put level#key & node.data# value to map (map.put(level, node.data))
     * <p>
     * do level++ when visiting right
     *
     * @param root
     * @param level
     * @param map
     */

    private void sumOfVertical(Node root, int level, TreeMap<Integer, Integer> map) {
        if (root == null)
            return;

        if (root.left != null)
            sumOfVertical(root.left, level - 1, map);

        if (map.containsKey(level))
            map.replace(level, map.get(level) + root.data);
        else
            map.put(level, root.data);

        if (root.right != null)
            sumOfVertical(root.right, level + 1, map);
    }


    private void preOrderPrintPaths(Node current, int[] list, int length) {
        if (current == null)
            return;

        list[length] = current.data;
        length++;

        if (current.left != null)
            preOrderPrintPaths(current.left, list, length);
        if (current.right != null)
            preOrderPrintPaths(current.right, list, length);

        if (current.right == null && current.left == null)
            this.printArray(list, length);

    }


    private void printArray(int[] arr, int length) {
        for (int i = 0; i < length; i++)
            System.out.println("" + arr[i]);
    }


    private Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.data)
            root.left = insert(root.left, data);

        if (data > root.data)
            root.right = insert(root.right, data);
        return root;
    }
}
