package Binary;

import TutorialHorizon.Binary.BinaryNode;
import java.util.Stack;

public class SpiralOrderTraversal {
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
        tree.traverse();
    }


    private  static class Tree{
        final BinaryNode root;
        Tree(BinaryNode root){
            this.root = root;
        }

       void traverse(){
            traverse(root);
       }

        private void traverse(BinaryNode root) {
            Stack<BinaryNode> stack = new Stack<>();

            stack.push(root);

            boolean direction = false;

            while (!stack.isEmpty()){
                Stack<BinaryNode> tempStack = new Stack<>();

                while (!stack.isEmpty()) {
                    BinaryNode temp = stack.pop();
                    System.out.print(temp.val + " ");
                    if (direction) {
                        if (temp.right != null) tempStack.add(temp.right);
                        if (temp.left != null) tempStack.add(temp.left);
                    } else {
                        if (temp.left != null) tempStack.add(temp.left);
                        if (temp.right != null) tempStack.add(temp.right);
                    }
                }
                direction = !direction;
                stack = tempStack;
            }
        }
    }


}
