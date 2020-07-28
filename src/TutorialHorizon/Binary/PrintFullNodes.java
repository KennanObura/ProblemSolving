package TutorialHorizon.Binary;

/***
 *
 * Objective: Given a binary tree, print all nodes will are full nodes.
 *
 * Full Nodes: Nodes Which has both the children, left and right are called Full Nodes
 */
public class PrintFullNodes {
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(1);
        root.left = new BinaryNode(2);
        root.right = new BinaryNode(3);
        root.left.left = new BinaryNode(7);
        root.left.right = new BinaryNode(5);
        root.right.left = new BinaryNode(6);
        root.right.right = new BinaryNode(7);

        Tree tree = new Tree(root);
        tree.isFullNode();
    }
    private static class Tree {
        Tree(BinaryNode root) {
            this.root = root;
        }

        final private BinaryNode root;

        void isFullNode(){
            isFullNode(root);
        }

        private void isFullNode(BinaryNode root) {
            if(root == null) return;

            if(root.left != null && root.right != null)
                System.out.println(root.val);

            isFullNode(root.left);
            isFullNode(root.right);
        }

    }
}
