package TutorialHorizon.Binary;

/**
 *
 *Objective: – Given a binary tree, print it in Top View of it.
 *
 * What is Top View: Top view means when you look the tree from the top the
 * nodes you will see will be called the top view of the tree. See the example below.
 *
 */
public class PrintTopView {
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(1);
        root.left = new BinaryNode(2);
        root.right = new BinaryNode(3);
        root.left.left = new BinaryNode(4);
        root.left.left.left = new BinaryNode(8);
        root.left.left.right = new BinaryNode(9);
        root.left.right = new BinaryNode(5);
        root.right.left = new BinaryNode(6);
        root.right.right = new BinaryNode(7);


        Tree tree = new Tree(root);
        tree.topView();
    }

    private static class Tree {
        Tree(BinaryNode root) {
            this.root = root;
        }

        final private BinaryNode root;

        void topView(){
            System.out.println(root.val);
            leftView(root.left);
            rightView(root.right);
        }

        private void rightView(BinaryNode node) {
            if(node == null) return;
            System.out.println(node.val);
            rightView(node.right);
        }

        private void leftView(BinaryNode node) {
            if(node == null) return;
            System.out.println(node.val);
            leftView(node.left);
        }
    }
}
