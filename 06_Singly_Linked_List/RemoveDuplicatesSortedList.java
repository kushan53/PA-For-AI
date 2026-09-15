package singly_linked_list;

/**
 * Question: Remove duplicates from a sorted linked list.
 * Given the head of a sorted linked list, delete all duplicates such that
 * each element appears only once.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class RemoveDuplicatesSortedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                // Skip the duplicate node
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

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
        // List: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        System.out.println("Original Sorted List with Duplicates:");
        printList(head);

        head = deleteDuplicates(head);
        System.out.println("After Removing Duplicates:");
        printList(head);
    }
}
