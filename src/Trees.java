import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Trees {
    public static void main(String[] args) {

        Tree root = new Tree(new TreeNode(40));

        root.add(20);
        root.add(10);
        root.add(30);
        root.add(60);
        root.add(50);
        root.add(70);
        root.add(4);
        root.print(root.node);
    }
}


class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

class Tree {
    TreeNode node;

    Tree(TreeNode node) {
        this.node = node;
    }

    void add(int data) {
        if (node == null) {
            new TreeNode(data);
            return;
        }
        depthInsert(node, data);
    }

    void print(TreeNode root) {
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.remove();
            System.out.println(temp.data + "");
            if (temp.left != null)
                stack.add(temp.left);
            if (temp.right != null)
                stack.add(temp.right);
//            prev = temp.data;
        }
    }

    private TreeNode depthInsert(TreeNode node, int data) {
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(node);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.remove();

            if (data < temp.data) {
                if (temp.left != null)
                    stack.add(temp.left);
                else {
                    temp.left = new TreeNode(data);
                    break;
                }
            } else {
                if (temp.right != null)
                    stack.add(temp.right);
                else {
                    temp.right = new TreeNode(data);
                    break;
                }
            }
        }
        return node;
    }
}

