package singly_linked_list;

/**
 * Question: Check if a singly linked list is a palindrome. (LeetCode 234)
 *
 * Algorithm:
 * 1. Find the middle of the linked list using slow and fast pointers.
 * 2. Reverse the second half of the linked list in-place.
 * 3. Compare values of first half and reversed second half.
 * 4. (Optional) Restore list to original state.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1) Auxiliary Space
 */
public class PalindromeLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. Find the middle (slow will be at the mid point)
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half starting from slow.next
        ListNode secondHalfHead = reverseList(slow.next);

        // 3. Compare first half and second half
        ListNode firstHalf = head;
        ListNode secondHalf = secondHalfHead;
        boolean isPalin = true;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                isPalin = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // 4. Restore the list
        slow.next = reverseList(secondHalfHead);

        return isPalin;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Palindrome: 1 -> 2 -> 2 -> 1
        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(2);
        pHead.next.next = new ListNode(2);
        pHead.next.next.next = new ListNode(1);
        System.out.println("List 1 [1, 2, 2, 1] is palindrome? " + isPalindrome(pHead));

        // Non-palindrome: 1 -> 2 -> 3
        ListNode npHead = new ListNode(1);
        npHead.next = new ListNode(2);
        npHead.next.next = new ListNode(3);
        System.out.println("List 2 [1, 2, 3] is palindrome? " + isPalindrome(npHead));
    }
}
