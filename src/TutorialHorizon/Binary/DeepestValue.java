package TutorialHorizon.Binary;

public class DeepestValue {
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
        tree.deepestValue();

        tree.maxElement();
    }

    static private class Tree{
        Tree(BinaryNode root){
            this.root = root;
        }
        private final BinaryNode root;
        private int maxLevel = 0;

        void deepestValue(){
            int value = deepestValue(root, 0, -1);
            System.out.println(value);
        }

        void maxElement(){
            int value = maxElement(root, 0);
            System.out.println(value);
        }

        /**
         *
         * Take two global variable as “deepestlevel” and “value“.
         * starting with level=0, Do the inorder traversal and whenever you go down one level
         * ( root.left OR root.right), increase the level by 1.
         * Keep checking if deepestlevel < level, if yes then update the “deepestlevel ” and “value “.
         * At the end return “value“, which will the deepest node value.
         * See the code for better explanation.
         * @param root root node
         * @param level current level of traversal
         * @param value current node value
         * @return value at the deepest node
         */
        private int deepestValue(BinaryNode root, int level, int value) {
            if (root == null) return value;

            if(root.left != null)
                value = deepestValue(root.left, level+1, value);
            if(level > maxLevel){
                maxLevel = level;
                value = root.val;
            }
            if(root.right != null)
                value = deepestValue(root.right, level+1, value);
            return value;
        }

        private int maxElement(BinaryNode root, int max){
            if(root == null) return max;
            max = Math.max(max, root.val);
            max = maxElement(root.left, max);
            max = maxElement(root.right, max);
            return max;
        }

    }
}
