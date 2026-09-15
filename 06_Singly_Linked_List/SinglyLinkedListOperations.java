package singly_linked_list;

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

    public void insertAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

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

    public void printList() {
        ListNode curr = head;
        System.out.print("List: ");
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : " -> NULL\n"));
            curr = curr.next;
        }
        if (head == null) System.out.println("EMPTY");
    }

    public int countNodes() {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

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

    public ListNode findMiddle() {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reverse() {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
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
