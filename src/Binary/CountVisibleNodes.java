package Binary;



/**
 *
 * Given a Binary tree, the task is to find the number of visible nodes in the given binary tree. A node is a visible node if,
 * in the path from the root to the node N, there is no node with greater value than N’s,
 */
public class CountVisibleNodes {
    static private Node root;
    public static void main(String[] args) {

        root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(10);

        root.left.left = new Node(20);
        root.left.right = new Node(21);

        root.right.left = new Node(1);

        System.out.println(visibleNodes(root, 0, Integer.MIN_VALUE));
    }

    static private class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }


    private static int visibleNodes(Node root, int count, int max){
        if(root == null) return count;

        if(root.data > max){
            max = root.data;
            count++;
        }
        count =  visibleNodes(root.left, count, max);
        count = visibleNodes(root.right, count, max);
        return count;
    }
}
