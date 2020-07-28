package Binary;

import TutorialHorizon.Binary.BinaryNode;

public class PrintLevel  {
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
        tree.printLevel(20);
    }


    private  static class Tree{
        final BinaryNode root;
        Tree(BinaryNode root){
            this.root = root;
        }

        void printLevel(int key){
            printLevel(root, key, 0);
        }

        private void printLevel(BinaryNode root, int key, int level) {
            if(root == null) return;

            if(root.val == key) System.out.println(level);

            if(root.left != null) printLevel(root.left, key, level+1);

            if(root.right != null) printLevel(root.right, key, level+1);
        }

    }


}
