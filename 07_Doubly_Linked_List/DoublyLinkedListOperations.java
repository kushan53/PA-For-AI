package doubly_linked_list;

public class DoublyLinkedListOperations {

    public static class DLLNode {
        public int val;
        public DLLNode prev;
        public DLLNode next;

        public DLLNode(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private DLLNode head;
    private DLLNode tail;
    private int size;

    public DoublyLinkedListOperations() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtHead(int val) {
        DLLNode newNode = new DLLNode(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertAtTail(int val) {
        DLLNode newNode = new DLLNode(val);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void deleteAtHead() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void deleteAtTail() {
        if (tail == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void printForward() {
        System.out.print("Forward:  NULL <-> ");
        DLLNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " <-> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public void printBackward() {
        System.out.print("Backward: NULL <-> ");
        DLLNode curr = tail;
        while (curr != null) {
            System.out.print(curr.val + " <-> ");
            curr = curr.prev;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DoublyLinkedListOperations dll = new DoublyLinkedListOperations();

        dll.insertAtHead(20);
        dll.insertAtHead(10);
        dll.insertAtTail(30);
        dll.insertAtTail(40);

        System.out.println("Initial Doubly Linked List:");
        dll.printForward();
        dll.printBackward();

        System.out.println("\nDeleting from head:");
        dll.deleteAtHead();
        dll.printForward();

        System.out.println("\nDeleting from tail:");
        dll.deleteAtTail();
        dll.printForward();
    }
}
