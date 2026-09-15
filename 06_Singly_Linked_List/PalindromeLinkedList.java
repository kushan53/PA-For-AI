package singly_linked_list;

public class PalindromeLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfHead = reverseList(slow.next);

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

        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(2);
        pHead.next.next = new ListNode(2);
        pHead.next.next.next = new ListNode(1);
        System.out.println("List 1 [1, 2, 2, 1] is palindrome? " + isPalindrome(pHead));

        ListNode npHead = new ListNode(1);
        npHead.next = new ListNode(2);
        npHead.next.next = new ListNode(3);
        System.out.println("List 2 [1, 2, 3] is palindrome? " + isPalindrome(npHead));
    }
}
