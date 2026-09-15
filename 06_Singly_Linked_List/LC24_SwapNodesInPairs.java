package singly_linked_list;

/**
 * LeetCode 24: Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 * Example:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC24_SwapNodesInPairs {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swapping pointers
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Advance prev to next pair
            prev = first;
        }

        return dummy.next;
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original List:");
        printList(head);

        head = swapPairs(head);
        System.out.println("After Swapping Pairs:");
        printList(head);
    }
}
