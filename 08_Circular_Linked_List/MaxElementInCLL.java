package circular_linked_list;

/**
 * Question: Find the maximum element in a Circular Linked List.
 *
 * Algorithm:
 * 1. Initialize max with Integer.MIN_VALUE or head.val.
 * 2. Traverse each node until the pointer wraps back to head.
 * 3. Update max if curr.val > max.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class MaxElementInCLL {

    static class CLLNode {
        int val;
        CLLNode next;
        CLLNode(int val) { this.val = val; }
    }

    public static int findMax(CLLNode head) {
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
        }

        int maxVal = head.val;
        CLLNode curr = head.next;

        while (curr != head) {
            if (curr.val > maxVal) {
                maxVal = curr.val;
            }
            curr = curr.next;
        }

        return maxVal;
    }

    public static void main(String[] args) {
        // Build CLL: 14 -> 52 -> 8 -> 99 -> 37 -> (back to 14)
        CLLNode head = new CLLNode(14);
        CLLNode n2 = new CLLNode(52);
        CLLNode n3 = new CLLNode(8);
        CLLNode n4 = new CLLNode(99);
        CLLNode n5 = new CLLNode(37);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = head;

        System.out.println("Finding maximum element in Circular Linked List:");
        System.out.println("Maximum Element: " + findMax(head));
    }
}
