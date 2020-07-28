package Binary;

import java.util.ArrayList;
import java.util.List;

/**
 * The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has
 * both v and w as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Tree tree = new Tree(root);
        tree.lowestCommonAncestor(root.left.left, root.left.right);

        tree.lowestCommonAncestor_b(root.left.left, root.left.right);
    }

    private static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static class Tree {
        Node root;

        Tree(Node root) {
            this.root = root;
        }

        /**
         * Find and store paths from root to nodeA
         * Find and store paths from root to nodeB
         * <p>
         * Traverse the list to find the common nodes in both vectors
         */
        void lowestCommonAncestor(Node nodeA, Node nodeB) {
            if (nodeA == null || nodeB == null) return;

            List<Node> pathA = new ArrayList<>();
            List<Node> pathB = new ArrayList<>();

            boolean pathExist = findPath(root, nodeB, pathB);
            boolean pathAExist = findPath(root, nodeA, pathA);

            if(pathAExist && pathExist)
                for (int i = 0; i < pathA.size() && i < pathB.size(); i++)
                    if(!pathA.get(i).equals(pathB.get(i))) {
                        System.out.println(pathA.get(i-1).data);
                        break;
                    }



//            printPath(pathA);
//                    System.out.println(" ");
//            printPath(pathB);


        }

        private void printPath(List<Node> path) {
            for (Node node : path)
                System.out.print(node.data);
        }

        private boolean findPath(Node root, Node nodeA, List<Node> path) {
            if (root == null) return false;
            path.add(root);

            if (root.data == nodeA.data) return true;
            if (findPath(root.left, nodeA, path)) return true;
            if (findPath(root.right, nodeA, path)) return true;

            path.remove(path.size() - 1);
            return false;
        }


        /**
         * Method 2 (Using Single Traversal)
         * The method 1 finds LCA in O(n) time, but requires three tree traversals plus extra spaces for path arrays.
         * If we assume that the keys n1 and n2 are present in Binary Tree, we can find LCA using single traversal of
         * Binary Tree and without extra storage for path arrays.
         *
         *
         * The idea is to traverse the tree starting from root. If any of the given keys (n1 and n2) matches with root,
         * then root is LCA (assuming that both keys are present). If root doesn’t match with any of the keys,
         * we recur for left and right subtree. The node which has one key present in its left subtree and the other key
         * present in right subtree is the LCA.
         * If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.
         */

        void lowestCommonAncestor_b(Node nodeA, Node nodeB) {
            Node lca = lowestCommonAncestor_b(root, nodeA, nodeB);
            System.out.println(lca.data +" ==" );
        }

        private Node lowestCommonAncestor_b(Node root, Node nodeA, Node nodeB) {
            if(root == null) return null;

            if (root.data == nodeA.data || root.data == nodeB.data)
                return root;

            Node left = lowestCommonAncestor_b(root.left, nodeA, nodeB);
            Node right = lowestCommonAncestor_b(root.right, nodeA, nodeB);

            if(left != null && right != null) return root;

            return (left != null ? left : right);
        }

    }
}


