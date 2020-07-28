package TutorialHorizon.Binary;

import java.util.ArrayList;

public class PathWhoseSumIsK {
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(1);
        root.left = new BinaryNode(2);
        root.right = new BinaryNode(3);
        root.left.left = new BinaryNode(7);
        root.left.right = new BinaryNode(5);
        root.right.left = new BinaryNode(6);
        root.right.right = new BinaryNode(7);

        Tree tree = new Tree(root);
        tree.pathExist(10);
    }

    private static class Tree {
        Tree(BinaryNode root) {
            this.root = root;
        }

        final private BinaryNode root;

        void pathExist(int k){
            pathExist(root, k, 0, "");
        }

        private void pathExist(BinaryNode root, int k, int sum, String path) {
            if(root == null) return;

            if(root.val > k) return;

            path += " "+ root.val;
            sum += root.val;

            if(sum  == k) System.out.println(path);

            pathExist(root.left, k, sum, path);
            pathExist(root.right, k, sum, path);

        }
    }
}
