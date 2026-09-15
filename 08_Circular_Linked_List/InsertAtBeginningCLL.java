package circular_linked_list;

/**
 * Question: Insert a new node at the beginning of a Circular Linked List.
 *
 * Approach:
 * 1. Create a new node.
 * 2. If list is empty, point newNode.next to itself and return as head.
 * 3. Otherwise, traverse to the last node (whose .next == head).
 * 4. Point lastNode.next to newNode, newNode.next to head, and update head = newNode.
 *
 * Time Complexity: O(N) (or O(1) if maintaining a tail pointer)
 * Space Complexity: O(1)
 */
public class InsertAtBeginningCLL {

    static class CLLNode {
        int val;
        CLLNode next;
        CLLNode(int val) { this.val = val; }
    }

    public static CLLNode insertAtBeginning(CLLNode head, int val) {
        CLLNode newNode = new CLLNode(val);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        // Find the last node
        CLLNode last = head;
        while (last.next != head) {
            last = last.next;
        }

        // Update links
        newNode.next = head;
        last.next = newNode;
        head = newNode; // Make newNode the new head

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
        CLLNode head = null;

        System.out.println("Inserting elements at beginning:");
        head = insertAtBeginning(head, 30);
        head = insertAtBeginning(head, 20);
        head = insertAtBeginning(head, 10);
        head = insertAtBeginning(head, 5);

        printList(head);
    }
}
