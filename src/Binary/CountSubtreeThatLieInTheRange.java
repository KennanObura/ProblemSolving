package Binary;

public class CountSubtreeThatLieInTheRange {
    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(1);

        root.right = new Node(50);
        root.right.left = new Node(40);
        root.right.right = new Node(100);

        Tree tree = new Tree(root);
        tree.countSubtree(5, 45);
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
        Tree(Node root) {
            this.root = root;
        }

        final Node root;

        void countSubtree(int start, int end) {
            int count = countSubtree(root, start, end, 0);
            System.out.println(count);
        }

        private int countSubtree(Node root, int start, int end, int count) {
            if (root == null) return 0;
            if (isInRange(root, start, end))
                count++;

            if (root.left != null)
                count = countSubtree(root.left, start, end, count);
            if (root.right != null)
                count = countSubtree(root.right, start, end, count);

            return count;
        }

        private boolean isInRange(Node root, int start, int end){
            return  (root.data >= start && root.data <= end);
        }
    }
}
