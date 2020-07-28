package TutorialHorizon.Binary;

public class CheckIfBinaryIsMirrorOfAnother {
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(20);
        root.left = new BinaryNode(10);
        root.right = new BinaryNode(30);
        root.left.left = new BinaryNode(5);
        root.left.left.right = new BinaryNode(7);
        root.left.right = new BinaryNode(15);
        root.right.left = new BinaryNode(25);
        root.right.right = new BinaryNode(35);


        BinaryNode root2 = new BinaryNode(20);
        root2.right = new BinaryNode(10);
        root2.left = new BinaryNode(30);
        root2.right.right = new BinaryNode(5);
        root2.right.right.left = new BinaryNode(7);
        root2.right.left = new BinaryNode(15);
        root2.left.right = new BinaryNode(25);
        root2.left.left = new BinaryNode(35);

        Tree tree = new Tree(root);
        tree.isMirror(root2);
    }

    private static class Tree {
        Tree(BinaryNode root) {
            this.root = root;
        }

        final private BinaryNode root;

        void isMirror(BinaryNode tree) {
            if (isMirror(root, tree)) System.out.println("Binary is a mirror of another");
            else System.out.println("Not a mirror of another");
        }

        private boolean isMirror(BinaryNode root, BinaryNode tree) {
            if (root == null && tree == null) return true;
            if(root == null && tree != null || root != null && tree == null)
                return false;

            if (root.val != tree.val) return false;
            return isMirror(root.left, tree.right) && isMirror(root.right, tree.left);
        }
    }
}
