package TutorialHorizon;

import org.jetbrains.annotations.Nullable;

public class DoublyLinkedListFromMatrix {
    public static void main(String[] args) {

        int [][]matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        DoublyLinkedList list = new DoublyLinkedList(matrix);
        list.toList();
        list.display(list.getHead());

    }

    private static class Node {
        Node(int data) {
            this.data = data;
        }

        int data;
        Node next;
        Node prev;
        Node up;
        Node down;
    }

    private static class DoublyLinkedList {

        int[][] matrix;
        Node head;

        DoublyLinkedList(int[][] matrix) {
            this.matrix = matrix;
            head = null;
        }

        Node getHead(){
            return head;
        }

        void toList() {
            head = createList(head, matrix.length, 0, 0, null);
        }

        /**
         * 1<->2<->3->null
         * ^
         * |
         * 4
         */

        private @Nullable
        Node createList(Node head, int length, int i, int j, Node current) {
            if (i >= length || j >= length) return null;

            head = new Node(matrix[i][j]);

            head.prev = current;
            head.up = current;

            head.next = createList(head, length, i , j+1, head);
            head.down = createList(head, length, i+1, j, head);


            return head;
        }

        void display(Node head) {
            // pointer to move right
            Node rPtr;

            // pointer to move down
            Node dPtr = head;

            // loop till node.down is not null
            while (dPtr != null) {

                rPtr = dPtr;

                // loop till node.right is not null
                while (rPtr != null) {
                    System.out.print(rPtr.data + " -");
                    rPtr = rPtr.next;
                }

                System.out.print("\n");
                dPtr = dPtr.down;
            }
        }
    }
}
