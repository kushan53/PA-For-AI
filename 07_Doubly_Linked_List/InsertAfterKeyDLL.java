package doubly_linked_list;

public class InsertAfterKeyDLL {

    static class DLLNode {
        int val;
        DLLNode prev;
        DLLNode next;
        DLLNode(int val) { this.val = val; }
    }

    public static boolean insertAfter(DLLNode head, int key, int newData) {
        DLLNode curr = head;

        while (curr != null && curr.val != key) {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Key " + key + " not found in the Doubly Linked List.");
            return false;
        }

        DLLNode newNode = new DLLNode(newData);
        newNode.next = curr.next;
        newNode.prev = curr;

        if (curr.next != null) {
            curr.next.prev = newNode;
        }
        curr.next = newNode;

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

        DLLNode head = new DLLNode(10);
        DLLNode n2 = new DLLNode(20);
        DLLNode n3 = new DLLNode(30);

        head.next = n2; n2.prev = head;
        n2.next = n3;   n3.prev = n2;

        System.out.println("Original Doubly Linked List:");
        printList(head);

        System.out.println("\nInserting 25 after key 20:");
        insertAfter(head, 20, 25);
        printList(head);

        System.out.println("\nInserting 35 after key 30 (tail):");
        insertAfter(head, 30, 35);
        printList(head);
    }
}
