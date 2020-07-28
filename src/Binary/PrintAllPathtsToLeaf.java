package Binary;

import TutorialHorizon.Binary.BinaryNode;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintAllPathtsToLeaf {
    public static void main(String[] args) {
        BinaryNode node = new BinaryNode(40);
        node.left = new BinaryNode(20);
        node.right = new BinaryNode(60);
        node.left.left = new BinaryNode(10);
        node.left.left.left = new BinaryNode(5);
        node.left.right = new BinaryNode(30);
        node.right.left = new BinaryNode(50);
        node.right.left.right = new BinaryNode(55);
        node.right.right = new BinaryNode(70);

        Tree tree = new Tree(node);
        tree.printLeafPath();
    }

    private static class Tree {
        private final BinaryNode root;

        private Tree(BinaryNode root) {
            this.root = root;
        }

        private void printLeafPath() {
            printLeafPath(root, new ArrayList<Integer>());
        }

        private void printLeafPath(BinaryNode root, ArrayList<Integer> path) {
            if (root == null) return;


            path.add(root.val);

            if (root.right == null && root.left == null)
                System.out.println(Arrays.toString(path.toArray()));

            if (root.left != null) printLeafPath(root.left, path);
            if (root.right != null) printLeafPath(root.right, path);

            //back track, removing the last item
            path.remove(path.size()-1);

        }

    }
}