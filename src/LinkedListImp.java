import java.util.List;

public class LinkedListImp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        ListNode node = new ListNode(6);
        list.insert(new ListNode(1));
        list.insert(new ListNode(2));
        list.insert(new ListNode(3));
        list.insert(node);
        list.insert(new ListNode(7));
        list.insert(new ListNode(9));

//        list.removeElements(2);
        list.deleteWithoutHeadPointer(node);
        list.print();
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class LinkedList {

    ListNode head;
    LinkedList() {
        head = null;
    }

     void insert(ListNode node){
        head = createLinkedList(head, node);
    }

    ListNode getHead() {
        return head;
    }

    private ListNode createLinkedList(ListNode head, ListNode new_node) {
        if(head == null) return new_node;
        /*
        Add to last
         */
        ListNode dummy = head;
        while (dummy.next != null)
            dummy = dummy.next;
        dummy.next = new_node;

        return head;
    }

    void print() {
        print(head);
    }

    private void print(ListNode current) {
        while (current != null) {
//            System.out.print(String.format("%o ->", current.val));
            System.out.print( current.val + "->");
            current = current.next;
        }
    }

    public ListNode deleteWithoutHeadPointer(ListNode node){
        /* assuming its not empty and node to be deleted is not last
            1. copy the node to be deleted
            2. move one step forward,
            3. delete by conventional deletion
         */

//        ListNode copy = node.next;
        node.val = node.next.val;
        node.next = node.next.next;
        System.gc();

        return head;


    }

    public ListNode removeElements(int val) {
        if(head == null)
            return null;

        if (head.val == val)
            head = head.next;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        ListNode prev = current;

        while (current != null) {
            if (current.val == val)
                prev.next = current.next;
            prev = current;
            current = current.next;
        }

        head = dummy.next;
        return head;
    }


}
