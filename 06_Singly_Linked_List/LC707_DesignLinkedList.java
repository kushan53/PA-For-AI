package singly_linked_list;

/**
 * LeetCode 707: Design Linked List
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 *
 * Implement the MyLinkedList class:
 * - MyLinkedList() Initializes the MyLinkedList object.
 * - int get(int index) Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * - void addAtHead(int val) Add a node of value val before the first element of the linked list.
 * - void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * - void addAtIndex(int index, int val) Add a node of value val before the index-th node in the linked list.
 * - void deleteAtIndex(int index) Delete the index-th node in the linked list, if the index is valid.
 */
public class LC707_DesignLinkedList {

    static class MyLinkedList {
        static class Node {
            int val;
            Node next;
            Node(int val) { this.val = val; }
        }

        private Node head;
        private int size;

        public MyLinkedList() {
            head = null;
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr.val;
        }

        public void addAtHead(int val) {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public void addAtTail(int val) {
            if (head == null) {
                addAtHead(val);
                return;
            }
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(val);
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) return;
            if (index == 0) {
                addAtHead(val);
                return;
            }
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            Node newNode = new Node(val);
            newNode.next = curr.next;
            curr.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            if (index == 0) {
                head = head.next;
                size--;
                return;
            }
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
            size--;
        }

        public void print() {
            Node curr = head;
            System.out.print("Current List (size " + size + "): ");
            while (curr != null) {
                System.out.print(curr.val + (curr.next != null ? " -> " : " -> NULL\n"));
                curr = curr.next;
            }
            if (head == null) System.out.println("EMPTY");
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
        myLinkedList.print();

        System.out.println("Element at index 1: " + myLinkedList.get(1)); // returns 2
        myLinkedList.deleteAtIndex(1);  // now the linked list is 1->3
        myLinkedList.print();
        System.out.println("Element at index 1: " + myLinkedList.get(1)); // returns 3
    }
}
