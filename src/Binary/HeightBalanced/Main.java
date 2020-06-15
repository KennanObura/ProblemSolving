package Binary.HeightBalanced;

public class Main {
    public static void main(String[] args) {

        Node<Integer> node = new Node<>(2);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
//        node.left.left.left = new Node(8);

        Tree<Integer> tree = new Tree<>(node);
        System.out.println(tree.isBalanced() + "");
    }

    static private class Node<R> {
        Node<R> left;
        Node<R> right;
        R data;

        Node(R data) {
            this.data = data;
        }
    }

    static private class Tree<R> {
        Node<R> root;
        Tree(Node<R> root) {
            this.root = root;
        }

        private boolean isBalanced() {
            return isBalanced(root);
        }

        /*
        :: An empty tree is balanced
        :: - check if left subtree is balanced
        :: - check is right subtree is balanced : recursively
                - get height is left subtree
                - get height if right subtree : recursively

         :: - is |leftheight-rightheight| = / < 1
                    return true
         */
        private boolean isBalanced(Node<R> root) {
            if (root == null) return true;
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);

            return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int getHeight(Node<R> node) {
            return (node == null ? 0 : Math.max(getHeight(node.left), getHeight(node.right))) + 1;
        }
    }
}
