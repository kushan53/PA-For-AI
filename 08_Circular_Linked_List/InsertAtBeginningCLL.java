package circular_linked_list;

public class InsertAtBeginningCLL {

    static class CLLNode {
        int val;
        CLLNode next;
        CLLNode(int val) { this.val = val; }
    }

    public static CLLNode insertAtBeginning(CLLNode head, int val) {
        CLLNode newNode = new CLLNode(val);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        CLLNode last = head;
        while (last.next != head) {
            last = last.next;
        }

        newNode.next = head;
        last.next = newNode;
        head = newNode;

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
        CLLNode head = null;

        System.out.println("Inserting elements at beginning:");
        head = insertAtBeginning(head, 30);
        head = insertAtBeginning(head, 20);
        head = insertAtBeginning(head, 10);
        head = insertAtBeginning(head, 5);

        printList(head);
    }
}
