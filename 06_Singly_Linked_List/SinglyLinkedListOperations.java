package singly_linked_list;

/**
 * Question: Implement Singly Linked List operations:
 * 1. Insertion (head, tail)
 * 2. Printing nodes
 * 3. Counting total nodes
 * 4. Linear search for a value
 * 5. Finding the middle element using Fast and Slow pointer (Tortoise and Hare)
 * 6. Iterative reversal of the linked list
 */
public class SinglyLinkedListOperations {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private ListNode head;

    // Insert at head
    public void insertAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    // Insert at tail
    public void insertAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // 1. Print all nodes
    public void printList() {
        ListNode curr = head;
        System.out.print("List: ");
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : " -> NULL\n"));
            curr = curr.next;
        }
        if (head == null) System.out.println("EMPTY");
    }

    // 2. Count total nodes
    public int countNodes() {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    // 3. Linear search
    public boolean search(int target) {
        ListNode curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.val == target) {
                System.out.println("Element " + target + " found at position index " + index);
                return true;
            }
            curr = curr.next;
            index++;
        }
        System.out.println("Element " + target + " not found in list.");
        return false;
    }

    // 4. Find middle element using Fast & Slow pointers (O(N) Time, O(1) Space)
    public ListNode findMiddle() {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // moves 1 step
            fast = fast.next.next;  // moves 2 steps
        }
        return slow;
    }

    // 5. Iterative Reversal (O(N) Time, O(1) Space)
    public void reverse() {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next; // store next node
            curr.next = prev; // reverse pointer
            prev = curr;      // move prev forward
            curr = next;      // move curr forward
        }
        head = prev;
    }

    public static void main(String[] args) {
        SinglyLinkedListOperations sll = new SinglyLinkedListOperations();

        sll.insertAtTail(10);
        sll.insertAtTail(20);
        sll.insertAtTail(30);
        sll.insertAtTail(40);
        sll.insertAtTail(50);
        sll.insertAtHead(5);

        sll.printList();
        System.out.println("Total Nodes: " + sll.countNodes());

        sll.search(30);
        sll.search(99);

        ListNode middle = sll.findMiddle();
        System.out.println("Middle Element (Fast & Slow pointer): " + (middle != null ? middle.val : "None"));

        System.out.println("\nReversing the Linked List:");
        sll.reverse();
        sll.printList();
    }
}
