package singly_linked_list;

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

        for (int i = 0; i < n; i++) {
            if (fast == null) {

                return null;
            }
            fast = fast.next;
        }

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
