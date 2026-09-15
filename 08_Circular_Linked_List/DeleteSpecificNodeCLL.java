package circular_linked_list;

/**
 * Question: Delete a specific node (by value) from a Circular Linked List.
 *
 * Edge cases handled:
 * 1. Empty list
 * 2. Only single node present which is to be deleted
 * 3. Head node to be deleted
 * 4. Middle / Tail node to be deleted
 * 5. Node value not present in list
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class DeleteSpecificNodeCLL {

    static class CLLNode {
        int val;
        CLLNode next;
        CLLNode(int val) { this.val = val; }
    }

    public static CLLNode deleteNode(CLLNode head, int key) {
        if (head == null) return null;

        // Case 1: If list contains only a single node
        if (head.val == key && head.next == head) {
            return null;
        }

        CLLNode curr = head;
        CLLNode prev = null;

        // Case 2: Head node is to be deleted
        if (head.val == key) {
            // Find the last node to update its next pointer
            CLLNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = head.next;
            head = head.next;
            return head;
        }

        // Case 3: Middle or last node is to be deleted
        do {
            prev = curr;
            curr = curr.next;

            if (curr.val == key) {
                prev.next = curr.next;
                return head;
            }
        } while (curr != head);

        System.out.println("Node with value " + key + " not found in CLL.");
        return head;
    }

    public static void printList(CLLNode head) {
        if (head == null) {
            System.out.println("CLL is EMPTY");
            return;
        }

        CLLNode curr = head;
        System.out.print("CLL: ");
        do {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        } while (curr != head);
        System.out.println("(HEAD: " + head.val + ")");
    }

    public static void main(String[] args) {
        // Build CLL: 10 -> 20 -> 30 -> 40 -> (back to 10)
        CLLNode head = new CLLNode(10);
        CLLNode n2 = new CLLNode(20);
        CLLNode n3 = new CLLNode(30);
        CLLNode n4 = new CLLNode(40);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = head;

        System.out.println("Original CLL:");
        printList(head);

        System.out.println("\nDeleting node 30 (middle node):");
        head = deleteNode(head, 30);
        printList(head);

        System.out.println("\nDeleting node 10 (head node):");
        head = deleteNode(head, 10);
        printList(head);

        System.out.println("\nDeleting node 40 (tail node):");
        head = deleteNode(head, 40);
        printList(head);
    }
}
