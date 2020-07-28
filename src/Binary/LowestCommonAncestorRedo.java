package Binary;

import TutorialHorizon.Binary.BinaryNode;

import java.util.ArrayList;

public class LowestCommonAncestorRedo {
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
        tree.lowestCommonAncestorUsingArrayPaths(10, 70);
    }


    private static class Tree {

        Tree(BinaryNode root) {
            this.root = root;
        }

        final BinaryNode root;

        void lowestCommonAncestor(int nodeA, int nodeB) {
            BinaryNode lca = lowestCommonAncestor(root, nodeA, nodeB);
            if (lca != null) System.out.println(lca.val);
        }

        private BinaryNode lowestCommonAncestor(BinaryNode root, int nodeA, int nodeB) {
            if (root == null) return null;

            if (root.val == nodeA || root.val == nodeB) return root;

            BinaryNode left = lowestCommonAncestor(root.left, nodeA, nodeB);
            BinaryNode right = lowestCommonAncestor(root.right, nodeA, nodeB);

            if (left != null && right != null) return root;

            return (left != null ? left : right);
        }

        private void lowestCommonAncestorUsingArrayPaths(int nodeA, int nodeB){
            BinaryNode result = lowestCommonAncestorUsingArrayPaths(root, nodeA, nodeB);
            System.out.println(result.val);
        }

        private BinaryNode lowestCommonAncestorUsingArrayPaths(BinaryNode root, int nodeA, int nodeB) {
            if (root == null) return null;

            ArrayList<BinaryNode> pathA = new ArrayList<>();
            ArrayList<BinaryNode> pathB = new ArrayList<>();
            boolean pathAExist = findPath(root, new BinaryNode(nodeA), pathA);
            boolean pathBExist = findPath(root, new BinaryNode(nodeB), pathB);

            if (!pathAExist || !pathBExist) return null;


            int count = 0;
            while (count < pathA.size() && count < pathB.size()) {
                if (!pathA.get(count).equals(pathB.get(count)))
                    break;
                count++;
            }


            return pathA.get(count - 1);
        }


        private boolean findPath(BinaryNode root, BinaryNode key, ArrayList<BinaryNode> path) {
            if (root == null || key == null) return false;
            path.add(root);

            if (root.val == key.val) return true;

            if (findPath(root.left, key, path)) return true;
            if (findPath(root.right, key, path)) return true;

            path.remove(path.size() - 1);

            return false;
        }
    }


}
