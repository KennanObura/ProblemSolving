package LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.insertAtEnd(1);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(8);
        linkedList.insertAtEnd(9);
        linkedList.print();

        System.out.println("Deleting item");
        linkedList.reverse();
//        linkedList.deleteAt(1);
        linkedList.print();

    }
}

class LinkedList {
    Node<Integer> root;

    LinkedList() {
    }


    void insertAtEnd(int item) {
        root = insertAtEnd(root, item);
    }

    void deleteAt(int k) {
        root = deleteAt(root, k);
    }

    void print() {
        print(root);
    }

    void reverse(){
        root = reverse(root);
    }

    private Node<Integer> insertAtEnd(Node<Integer> head, int item) {
        if (head == null) return new Node<Integer>(item);
        Node<Integer> current = head;
        while (current.next != null)
            current = current.next;

        current.next = new Node<Integer>(item);
        return head;
    }

    private Node<Integer> deleteAt(Node<Integer> head, int k) {
        if (head == null) return null;

        if(head.data == k){
            head = head.next;
            return head;
        }

        Node<Integer> prev = new Node<Integer>(-1);

        prev.next = head;
        Node<Integer> current = prev.next;



        while (current != null) {
            if (current.data == k)
                prev.next = current.next;
            prev = current;
            current = current.next;
        }

        return head;
    }

    private void print(Node<Integer> head) {
        while (head != null) {
            System.out.println(head.data + "  ");
            head = head.next;
        }
    }

    private Node<Integer> reverse(Node<Integer> head){
        if(head == null) return null;
        Node<Integer> current = head;
        Node<Integer> nextNode;
        Node<Integer> prev = null;

        while (current != null){
            nextNode = current.next;
            current.next = prev;

            prev = current;
            current = nextNode;

        }

        return prev;
    }

}
