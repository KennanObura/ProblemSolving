package TutorialHorizon.Binary;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySize {
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
        tree.iterative();
    }

    static private class Tree {
        private final BinaryNode root;
        Tree(BinaryNode root){
            this.root = root;
        }

        void recursive(){
            System.out.println(recursive(root));
        }

        void iterative(){
            System.out.println(iterative(root));
        }

        private int iterative(BinaryNode root) {
            if(root == null) return 0;
            Queue<BinaryNode> queue = new LinkedList<>();
            int count =0;
            queue.add(root);
            while (!queue.isEmpty()){
                BinaryNode temp = queue.remove();
                count++;
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            return count;
        }

        private int recursive(BinaryNode root) {
            if(root == null) return 0;
            return 1 + recursive(root.left) + recursive(root.right);
        }
    }
}
