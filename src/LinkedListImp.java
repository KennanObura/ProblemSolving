public class LinkedListImp {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.removeElements(list.getHead(), 1);
        list.print();
    }
}

class LinkedList {

    ListNode head;

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    LinkedList() {
        head = createLinkedList();
//        this.print();
    }

    ListNode getHead() {
        return head;
    }

    private ListNode createLinkedList() {
//        Input:  1->2->6->3->4->5->6, val = 6
        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(6);
//        node.next.next.next = new ListNode(3);
//        node.next.next.next.next = new ListNode(4);
//        node.next.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next.next = new ListNode(6);

        return node;
    }

    void print() {
        print(head);
    }

    private void print(ListNode current) {
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;

        while (head != null && head.val == val)
            head = head.next;

        ListNode current = head;
        ListNode prev = current;

        while (current != null) {
            if (current.val == val)
                prev.next = current.next;
            prev = current;
            current = current.next;
        }

        return head;
    }


}
