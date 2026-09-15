package doubly_linked_list;

public class InPlaceReversalDLL {

    static class DLLNode {
        int val;
        DLLNode prev;
        DLLNode next;
        DLLNode(int val) { this.val = val; }
    }

    public static DLLNode reverseDLL(DLLNode head) {
        if (head == null || head.next == null) return head;

        DLLNode curr = head;
        DLLNode temp = null;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }

    public static void printList(DLLNode head) {
        DLLNode curr = head;
        System.out.print("DLL: NULL <-> ");
        while (curr != null) {
            System.out.print(curr.val + " <-> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        DLLNode head = new DLLNode(1);
        DLLNode n2 = new DLLNode(2);
        DLLNode n3 = new DLLNode(3);
        DLLNode n4 = new DLLNode(4);
        DLLNode n5 = new DLLNode(5);

        head.next = n2; n2.prev = head;
        n2.next = n3;   n3.prev = n2;
        n3.next = n4;   n4.prev = n3;
        n4.next = n5;   n5.prev = n4;

        System.out.println("Original Doubly Linked List:");
        printList(head);

        head = reverseDLL(head);
        System.out.println("\nAfter In-Place Reversal:");
        printList(head);
    }
}
