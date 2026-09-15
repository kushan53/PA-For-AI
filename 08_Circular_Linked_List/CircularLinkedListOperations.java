package circular_linked_list;

public class CircularLinkedListOperations {

    public static class CLLNode {
        public int val;
        public CLLNode next;

        public CLLNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private CLLNode head;

    public void insertAtEnd(int val) {
        CLLNode newNode = new CLLNode(val);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        CLLNode curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = head;
    }

    public void printList() {
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

    public void printReverse() {
        if (head == null) return;
        System.out.print("CLL in Reverse: ");
        printReverseHelper(head, head);
        System.out.println();
    }

    private void printReverseHelper(CLLNode curr, CLLNode start) {
        if (curr.next != start) {
            printReverseHelper(curr.next, start);
        }
        System.out.print(curr.val + " ");
    }

    public CLLNode findMiddle() {
        if (head == null) return null;

        CLLNode slow = head;
        CLLNode fast = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static int josephusProblem(int n, int k) {
        if (n <= 0 || k <= 0) return -1;

        CLLNode head = new CLLNode(1);
        CLLNode prev = head;
        for (int i = 2; i <= n; i++) {
            prev.next = new CLLNode(i);
            prev = prev.next;
        }
        prev.next = head;

        CLLNode ptr1 = head, ptr2 = head;
        while (ptr1.next != ptr1) {

            for (int count = 1; count < k; count++) {
                ptr2 = ptr1;
                ptr1 = ptr1.next;
            }

            ptr2.next = ptr1.next;
            ptr1 = ptr2.next;
        }

        return ptr1.val;
    }

    public static void main(String[] args) {
        CircularLinkedListOperations cll = new CircularLinkedListOperations();

        cll.insertAtEnd(10);
        cll.insertAtEnd(20);
        cll.insertAtEnd(30);
        cll.insertAtEnd(40);
        cll.insertAtEnd(50);

        cll.printList();
        cll.printReverse();

        CLLNode mid = cll.findMiddle();
        System.out.println("Middle Element of CLL: " + (mid != null ? mid.val : "None"));

        int n = 7, k = 3;
        int survivor = josephusProblem(n, k);
        System.out.println("\nJosephus Survivor for n = " + n + ", k = " + k + " is Person #" + survivor);
    }
}
