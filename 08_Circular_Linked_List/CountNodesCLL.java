package circular_linked_list;

public class CountNodesCLL {

    static class CLLNode {
        int val;
        CLLNode next;
        CLLNode(int val) { this.val = val; }
    }

    public static int countNodes(CLLNode head) {
        if (head == null) return 0;

        int count = 0;
        CLLNode curr = head;

        do {
            count++;
            curr = curr.next;
        } while (curr != head);

        return count;
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

        System.out.println("Circular Linked List created.");
        System.out.println("Total nodes count: " + countNodes(head));
    }
}
