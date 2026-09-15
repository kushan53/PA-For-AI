package doubly_linked_list;

public class DeleteAllOccurrencesDLL {

    static class DLLNode {
        int val;
        DLLNode prev;
        DLLNode next;
        DLLNode(int val) { this.val = val; }
    }

    public static DLLNode deleteAllOccurrences(DLLNode head, int key) {
        DLLNode curr = head;

        while (curr != null) {
            if (curr.val == key) {

                if (curr == head) {
                    head = curr.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {

                    if (curr.prev != null) {
                        curr.prev.next = curr.next;
                    }

                    if (curr.next != null) {
                        curr.next.prev = curr.prev;
                    }
                }
            }
            curr = curr.next;
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

        DLLNode head = new DLLNode(10);
        DLLNode n2 = new DLLNode(20);
        DLLNode n3 = new DLLNode(10);
        DLLNode n4 = new DLLNode(30);
        DLLNode n5 = new DLLNode(10);

        head.next = n2; n2.prev = head;
        n2.next = n3;   n3.prev = n2;
        n3.next = n4;   n4.prev = n3;
        n4.next = n5;   n5.prev = n4;

        System.out.println("Original Doubly Linked List:");
        printList(head);

        int keyToDelete = 10;
        head = deleteAllOccurrences(head, keyToDelete);
        System.out.println("\nAfter deleting all occurrences of " + keyToDelete + ":");
        printList(head);
    }
}
