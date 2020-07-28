package TutorialHorizon.Binary;

public class DeleteBinary {
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(20);
        root.left = new BinaryNode(10);
        root.right = new BinaryNode(30);
        root.left.left = new BinaryNode(5);
        root.left.left.right = new BinaryNode(7);
        root.left.right = new BinaryNode(15);
        root.right.left = new BinaryNode(25);
        root.right.right = new BinaryNode(35);


        Tree tree = new Tree(root);
        tree.print();

        tree.search(35);

//        System.out.println("deleting ===");
//        tree.delete();
//        tree.print();

    }

    private static class Tree {
        private BinaryNode root;

        Tree(BinaryNode root) {
            this.root = root;
        }

        void delete() {
            root = delete(root);
        }

        void print() {
            print(root);
        }

        void search(int k) {
            if (search(root, k)) System.out.println(k + " is found");
            else System.out.println(k + " not found");
        }

        private boolean search(BinaryNode root, int k) {
            if (root == null) return false;
            if (root.val == k) return true;

            boolean isFound = false;
            if (root.left != null)
                isFound = search(root.left, k);
            if (root.right != null)
                isFound = search(root.right, k);
            return isFound;
        }

        private BinaryNode delete(BinaryNode root) {
            if (root == null) return null;
            if (root.left != null) return delete(root.left);
            if (root.right != null) return delete(root.right);
            root = null;
            System.gc();
            return null;
        }

        private void print(BinaryNode root) {
            if (root == null) return;
            System.out.println(root.val);
            if (root.left != null) print(root.left);
            if (root.right != null) print(root.right);
        }

    }
}
