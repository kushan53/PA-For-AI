package circular_linked_list;

/**
 * Question: Search for an element in a Circular Linked List.
 * Returns the 0-based index if found, or -1 if not found.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class SearchElementCLL {

    static class CLLNode {
        int val;
        CLLNode next;
        CLLNode(int val) { this.val = val; }
    }

    public static int search(CLLNode head, int target) {
        if (head == null) return -1;

        CLLNode curr = head;
        int index = 0;

        do {
            if (curr.val == target) {
                return index;
            }
            curr = curr.next;
            index++;
        } while (curr != head);

        return -1; // Target not found
    }

    public static void main(String[] args) {
        // Build CLL: 15 -> 25 -> 35 -> 45 -> (back to 15)
        CLLNode head = new CLLNode(15);
        CLLNode n2 = new CLLNode(25);
        CLLNode n3 = new CLLNode(35);
        CLLNode n4 = new CLLNode(45);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = head;

        int target1 = 35;
        System.out.println("Search for " + target1 + ": Position Index " + search(head, target1));

        int target2 = 99;
        System.out.println("Search for " + target2 + ": Position Index " + search(head, target2));
    }
}
