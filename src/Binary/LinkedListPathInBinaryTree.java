package Binary;

public class LinkedListPathInBinaryTree {
    public static void main(String[] args) {

        LinkedNode linkedNode = new LinkedNode(4);
        linkedNode.next = new LinkedNode(2);
        linkedNode.next.next = new LinkedNode(8);
        linkedNode.next.next.next = new LinkedNode(1);


        BinaryNode binaryNode = new BinaryNode(1);
        binaryNode.left = new BinaryNode(4);
        binaryNode.right = new BinaryNode(4);
        binaryNode.left.right = new BinaryNode(2);
        binaryNode.left.right.right = new BinaryNode(8);
        binaryNode.left.right.right.left = new BinaryNode(1);
        binaryNode.right.left = new BinaryNode(2);

        Tree tree = new Tree(binaryNode, linkedNode);
        tree.searchNode();
    }

    private static class BinaryNode {
        private BinaryNode(int data) {
            this.data = data;
        }

        private final int data;
        BinaryNode left;
        BinaryNode right;
    }

    private static class LinkedNode {
        private LinkedNode(int data) {
            this.data = data;
        }

        private final int data;
        LinkedNode next;
    }


    private static class Tree {
        final private BinaryNode rootBinary;
        final private LinkedNode headOfList;

        Tree(BinaryNode rootBinary, LinkedNode headOfList) {
            this.headOfList = headOfList;
            this.rootBinary = rootBinary;
        }

        private void searchNode() {
            if (searchNode(rootBinary, headOfList)) System.out.println("Found");
            else System.out.println("Not Found");
        }

        private boolean searchNode(BinaryNode rootBinary, LinkedNode headOfList) {
            if (rootBinary == null) return false;

            if (rootBinary.data == headOfList.data) {
                if (headOfList.next == null) return true;

                return isPathDownward(rootBinary, headOfList.next);
            }

            if (rootBinary.left != null)
                return searchNode(rootBinary.left, headOfList);
            if (rootBinary.right != null)
                return searchNode(rootBinary.right, headOfList);

            return false;

        }

        private boolean isPathDownward(BinaryNode rootBinary, LinkedNode headOfList) {

            if (rootBinary == null) return false;

            if (headOfList == null) return true;


            if (rootBinary.left != null && rootBinary.left.data == headOfList.data)
                return isPathDownward(rootBinary.left, headOfList.next);

            if (rootBinary.right != null && rootBinary.right.data == headOfList.data) {
                System.out.println(rootBinary.right.data + " ---" + headOfList.data);
                return isPathDownward(rootBinary.right, headOfList.next);
            }
            return false;
        }

    }


}
