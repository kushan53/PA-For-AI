package circular_linked_list;

public class DeleteSpecificNodeCLL {

    static class CLLNode {
        int val;
        CLLNode next;
        CLLNode(int val) { this.val = val; }
    }

    public static CLLNode deleteNode(CLLNode head, int key) {
        if (head == null) return null;

        if (head.val == key && head.next == head) {
            return null;
        }

        CLLNode curr = head;
        CLLNode prev = null;

        if (head.val == key) {

            CLLNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = head.next;
            head = head.next;
            return head;
        }

        do {
            prev = curr;
            curr = curr.next;

            if (curr.val == key) {
                prev.next = curr.next;
                return head;
            }
        } while (curr != head);

        System.out.println("Node with value " + key + " not found in CLL.");
        return head;
    }

    public static void printList(CLLNode head) {
        if (head == null) {
            System.out.println("CLL is EMPTY");
            return;
        }

        CLLNode curr = head;
        System.out.print("CLL: ");
        do {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        } while (curr != head);
        System.out.println("(HEAD: " + head.val + ")");
    }

    public static void main(String[] args) {

        CLLNode head = new CLLNode(10);
        CLLNode n2 = new CLLNode(20);
        CLLNode n3 = new CLLNode(30);
        CLLNode n4 = new CLLNode(40);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = head;

        System.out.println("Original CLL:");
        printList(head);

        System.out.println("\nDeleting node 30 (middle node):");
        head = deleteNode(head, 30);
        printList(head);

        System.out.println("\nDeleting node 10 (head node):");
        head = deleteNode(head, 10);
        printList(head);

        System.out.println("\nDeleting node 40 (tail node):");
        head = deleteNode(head, 40);
        printList(head);
    }
}
