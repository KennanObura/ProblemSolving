package TutorialHorizon.Binary;

public class AVLInsert {
    public static void main(String[] args) {

        Tree i = new Tree();
        i.insert(4);
        i.insert(2);
        i.insert(1);
        i.insert(5);
        i.insert(6);
        i.insert(9);
        i.insert(14);
        i.insert(11);
        i.insert(10);
        i.insert(20);

        i.inorder();

    }

    private static class Node {
        Node(int data) {
            this.data = data;
            this.height = 1;
        }

        private int height;
        private final int data;
        private Node left;
        private Node right;
    }

    private static class Tree {
        private Node root;

        Tree() {
            this.root = null;
        }

        void insert(int data) {
            root = insert(root, data);
        }

        void inorder(){
            inorder(root);
        }

        private Node insert(Node root, int data) {
            if (root == null) return new Node(data);
            if (data < root.data) root.left = insert(root.left, data);
            else if (data > root.data) root.right = insert(root.right, data);
            else throw new RuntimeException("Duplicate item");
            updateHeight(root);
            return reBalanceTree(root, data);
        }

        private void updateHeight(Node node) {
            node.height = Math.max(height(node.left), height(node.right)) + 1;
        }

        private Node reBalanceTree(Node root, int data) {
            int balanceFactor = getBalanceFactor(root);

            /*
             *left left case
             *
             *      x
             *     /
             *    y
             *   /
             *  z
             */

            if (balanceFactor > 1 && data < root.left.data)
                return rotateRight(root);


            /*
             *left right case
             *
             *      x
             *     /
             *    y
             *      \
             *        z
             */
            if (balanceFactor > 1 && data > root.left.data) {
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }



            /*
             *right right case
             *
             *      x
             *       \
             *         y
             *          \
             *            z
             */

            if (balanceFactor < -1 && data > root.right.data)
                return rotateLeft(root);


            /*
             * right right case
             *
             *      x
             *       \
             *         y
             *        /
             *       z
             */

            if (balanceFactor < -1 && data < root.right.data) {
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }

            return root;
        }

        private Node rotateLeft(Node root) {
            Node temp = root.right;
            Node temp2 = temp.left;

            //rotate
            temp.left = root;
            root.right = temp2;

            updateHeight(root);
            updateHeight(temp);

            return temp;
        }

        private Node rotateRight(Node root) {
            Node temp = root.left;
            Node temp2 = temp.right;

            //rotate
            temp.right = root;
            root.left = temp2;

            updateHeight(root);
            updateHeight(temp);

            return temp;
        }

        private int getBalanceFactor(Node node) {
            return height(node.left) - height(node.right);
        }

        private int height(Node node) {
            return node == null ? 0 : node.height;
        }


        private void inorder(Node node){
            if(node == null) return;
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }

    }

}
