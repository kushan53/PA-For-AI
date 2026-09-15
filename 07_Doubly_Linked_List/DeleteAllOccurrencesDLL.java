package doubly_linked_list;

/**
 * Question: Delete all occurrences of a given value 'key' in a Doubly Linked List.
 *
 * Handles:
 * 1. Head node matches key.
 * 2. Middle nodes match key.
 * 3. Tail node matches key.
 * 4. Multiple consecutive matching nodes.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
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
                // If it's head node
                if (curr == head) {
                    head = curr.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    // Update previous node's next pointer
                    if (curr.prev != null) {
                        curr.prev.next = curr.next;
                    }
                    // Update next node's prev pointer
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
        // Build DLL: 10 <-> 20 <-> 10 <-> 30 <-> 10
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
