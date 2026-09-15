package singly_linked_list;

/**
 * Question: Delete the middle node of a linked list. (LeetCode 2095)
 * If the list contains 2*k nodes, delete the node at index k (0-indexed).
 * If the list has only 1 node, return null.
 *
 * Approach: Fast and Slow pointer with 'prev' pointer.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class DeleteMiddleNode {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // Empty or single-node list becomes null
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now pointing to middle node; unlink it
        prev.next = slow.next;

        return head;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : " -> NULL\n"));
            curr = curr.next;
        }
        if (head == null) System.out.println("EMPTY LIST");
    }

    public static void main(String[] args) {
        // List: 1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.println("Original List:");
        printList(head);

        head = deleteMiddle(head);
        System.out.println("After Deleting Middle Node:");
        printList(head);
    }
}
