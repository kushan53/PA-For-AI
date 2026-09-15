package doubly_linked_list;

/**
 * Question: Check for a palindrome in a Doubly Linked List using the Two-Pointer approach.
 *
 * Algorithm:
 * 1. Find the tail node of the Doubly Linked List.
 * 2. Initialize left = head, right = tail.
 * 3. While left != right and left.prev != right:
 *      If left.val != right.val -> Not a palindrome.
 *      left = left.next, right = right.prev.
 * 4. Return true if all matched.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1) Auxiliary Space
 */
public class PalindromeDLLTwoPointers {

    static class DLLNode {
        char val;
        DLLNode prev;
        DLLNode next;
        DLLNode(char val) { this.val = val; }
    }

    public static boolean isPalindrome(DLLNode head) {
        if (head == null || head.next == null) return true;

        // 1. Find tail
        DLLNode right = head;
        while (right.next != null) {
            right = right.next;
        }

        // 2. Two-pointer comparison from both ends
        DLLNode left = head;
        while (left != right && left.prev != right) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }

        return true;
    }

    public static void printList(DLLNode head) {
        DLLNode curr = head;
        System.out.print("DLL: NULL <-> ");
        while (curr != null) {
            System.out.print(curr.val + " <-> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Palindrome DLL: 'r' <-> 'a' <-> 'd' <-> 'a' <-> 'r'
        DLLNode head1 = new DLLNode('r');
        DLLNode n2 = new DLLNode('a');
        DLLNode n3 = new DLLNode('d');
        DLLNode n4 = new DLLNode('a');
        DLLNode n5 = new DLLNode('r');

        head1.next = n2; n2.prev = head1;
        n2.next = n3;   n3.prev = n2;
        n3.next = n4;   n4.prev = n3;
        n4.next = n5;   n5.prev = n4;

        printList(head1);
        System.out.println("Is Palindrome? " + isPalindrome(head1));

        // Non-Palindrome DLL: 'h' <-> 'e' <-> 'l' <-> 'l' <-> 'o'
        DLLNode head2 = new DLLNode('h');
        DLLNode h2 = new DLLNode('e');
        DLLNode h3 = new DLLNode('l');
        head2.next = h2; h2.prev = head2;
        h2.next = h3;   h3.prev = h2;

        printList(head2);
        System.out.println("Is Palindrome? " + isPalindrome(head2));
    }
}
