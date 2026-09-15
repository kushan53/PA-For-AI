package singly_linked_list;

/**
 * Question: Reverse nodes of a linked list in groups of K. (LeetCode 25)
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * Example:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1) Auxiliary Space
 */
public class ReverseNodesInKGroup {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        // Dummy node initialization
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {
            // Check if there are at least k nodes remaining
            ListNode kthNode = getKthNode(prevGroupEnd, k);
            if (kthNode == null) {
                break;
            }

            ListNode nextGroupStart = kthNode.next;
            ListNode groupStart = prevGroupEnd.next;

            // Reverse current group of k nodes
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;
            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect previous group to reversed group head
            prevGroupEnd.next = kthNode;
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    private static ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : " -> NULL\n"));
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        // List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int k = 2;
        head = reverseKGroup(head, k);
        System.out.println("After Reversing in groups of k = " + k + ":");
        printList(head);
    }
}
