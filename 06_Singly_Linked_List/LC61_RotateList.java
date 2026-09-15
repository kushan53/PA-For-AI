package singly_linked_list;

/**
 * LeetCode 61: Rotate List
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Algorithm:
 * 1. Find the length and link the tail node to the head (forming a circular ring).
 * 2. Find the new tail node at position (length - k % length - 1).
 * 3. Break the circular ring at new tail to form the new list.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class LC61_RotateList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1. Calculate length and find tail
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Effective rotations needed
        k = k % length;
        if (k == 0) return head;

        // 2. Connect tail to head to form ring
        tail.next = head;

        // 3. Find new tail: (length - k) steps from head
        int stepsToNewTail = length - k;
        ListNode newTail = tail;
        while (stepsToNewTail > 0) {
            newTail = newTail.next;
            stepsToNewTail--;
        }

        // 4. Break ring and set new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : " -> NULL\n"));
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        // List: 1 -> 2 -> 3 -> 4 -> 5, k = 2 -> Output: 4 -> 5 -> 1 -> 2 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int k = 2;
        head = rotateRight(head, k);
        System.out.println("After Rotating Right by " + k + " places:");
        printList(head);
    }
}
