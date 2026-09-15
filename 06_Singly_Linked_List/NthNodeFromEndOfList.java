package singly_linked_list;

/**
 * Question: Find the N-th node from the end of a linked list in a single pass.
 *
 * Approach: Two-Pointer Technique
 * 1. Move first pointer 'fast' N steps ahead.
 * 2. Move both 'fast' and 'slow' one step at a time until 'fast' reaches the end.
 * 3. The 'slow' pointer will then point directly to the N-th node from the end.
 *
 * Time Complexity: O(L) where L is list length (Single Pass)
 * Space Complexity: O(1)
 */
public class NthNodeFromEndOfList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode findNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return null;

        ListNode fast = head;
        ListNode slow = head;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                // n is greater than the total number of nodes
                return null;
            }
            fast = fast.next;
        }

        // Move both pointers until fast reaches null
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : " -> NULL\n"));
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        // Build list: 10 -> 20 -> 30 -> 40 -> 50
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        printList(head);

        int n1 = 2;
        ListNode res1 = findNthFromEnd(head, n1);
        System.out.println(n1 + "-th node from end: " + (res1 != null ? res1.val : "Invalid"));

        int n2 = 5;
        ListNode res2 = findNthFromEnd(head, n2);
        System.out.println(n2 + "-th node from end: " + (res2 != null ? res2.val : "Invalid"));
    }
}
