package singly_linked_list;

/**
 * LeetCode 142: Linked List Cycle II
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * Algorithm: Floyd's Cycle Detection with Starting Point Math:
 * 1. Detect intersection point using slow (1 step) and fast (2 steps) pointers.
 * 2. If slow == fast, reset an entry pointer to head while keeping slow at intersection.
 * 3. Move both entry and slow by 1 step at a time. The point where they meet is the starting node of the cycle!
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC142_LinkedListCycleII {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) return null;

        // Step 2: Find the starting node of cycle
        ListNode entry = head;
        while (entry != slow) {
            entry = entry.next;
            slow = slow.next;
        }

        return entry;
    }

    public static void main(String[] args) {
        // Create cyclic list: 3 -> 2 -> 0 -> -4 -> (loops back to node 2)
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // cycle starts at node2 (val=2)

        ListNode cycleStart = detectCycle(node1);
        System.out.println("Cycle start node value: " + (cycleStart != null ? cycleStart.val : "No cycle"));
    }
}
