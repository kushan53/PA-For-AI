package singly_linked_list;

/**
 * LeetCode 141: Linked List Cycle
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * Algorithm: Floyd's Tortoise and Hare (Cycle-Finding) Algorithm
 * - Slow pointer moves 1 step at a time.
 * - Fast pointer moves 2 steps at a time.
 * - If they meet at any node, a cycle exists.
 * - If fast reaches null or fast.next is null, no cycle exists.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC141_LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle
    }

    public static void main(String[] args) {
        // Create cyclic list: 3 -> 2 -> 0 -> -4 -> (loops back to 2)
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // cycle here

        System.out.println("Cycle list detected? " + hasCycle(node1));

        // Create acyclic list: 1 -> 2 -> 3
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;

        System.out.println("Acyclic list detected? " + hasCycle(a1));
    }
}
