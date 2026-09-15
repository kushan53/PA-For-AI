package doubly_linked_list;

/**
 * Question: In-place reversal of a Doubly Linked List.
 *
 * Algorithm:
 * Swap `prev` and `next` pointers for all nodes in the DLL.
 * Update the head pointer to the last processed node (which was original tail).
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
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

        // Swap next and prev for all nodes of DLL
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            // Move to next node (which is now curr.prev due to swap)
            curr = curr.prev;
        }

        // After the loop, temp points to the prev of the last processed node
        // so temp.prev is the new head
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
        // Build DLL: 1 <-> 2 <-> 3 <-> 4 <-> 5
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
