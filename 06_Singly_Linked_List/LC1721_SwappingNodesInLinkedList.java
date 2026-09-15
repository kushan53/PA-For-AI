package singly_linked_list;

/**
 * LeetCode 1721: Swapping Nodes in a Linked List
 * You are given the head of a linked list, and an integer k.
 * Return the head of the linked list after swapping the values of the kth node
 * from the beginning and the kth node from the end (the list is 1-indexed).
 *
 * Time Complexity: O(N) (Single Pass)
 * Space Complexity: O(1)
 */
public class LC1721_SwappingNodesInLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode swapNodes(ListNode head, int k) {
        if (head == null) return null;

        ListNode firstK = head;
        // Move firstK pointer to kth node from start
        for (int i = 1; i < k; i++) {
            firstK = firstK.next;
        }

        // Set up two pointers to locate kth node from end
        ListNode curr = firstK;
        ListNode secondK = head;

        while (curr.next != null) {
            curr = curr.next;
            secondK = secondK.next;
        }

        // Swap the values of the two nodes
        int temp = firstK.val;
        firstK.val = secondK.val;
        secondK.val = temp;

        return head;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : " -> NULL\n"));
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5, k = 2 (swap 2 and 4)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int k = 2;
        head = swapNodes(head, k);
        System.out.println("After Swapping kth from start and end (k=" + k + "):");
        printList(head);
    }
}
