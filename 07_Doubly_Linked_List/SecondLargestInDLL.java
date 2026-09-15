package doubly_linked_list;

public class SecondLargestInDLL {

    static class DLLNode {
        int val;
        DLLNode prev;
        DLLNode next;
        DLLNode(int val) { this.val = val; }
    }

    public static int findSecondLargest(DLLNode head) {
        if (head == null || head.next == null) {
            throw new IllegalArgumentException("List must contain at least two distinct elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        DLLNode curr = head;
        while (curr != null) {
            if (curr.val > largest) {
                secondLargest = largest;
                largest = curr.val;
            } else if (curr.val > secondLargest && curr.val != largest) {
                secondLargest = curr.val;
            }
            curr = curr.next;
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second largest distinct element found (all elements may be identical).");
        }

        return secondLargest;
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

        DLLNode head = new DLLNode(12);
        DLLNode n2 = new DLLNode(35);
        DLLNode n3 = new DLLNode(1);
        DLLNode n4 = new DLLNode(10);
        DLLNode n5 = new DLLNode(34);
        DLLNode n6 = new DLLNode(1);

        head.next = n2; n2.prev = head;
        n2.next = n3;   n3.prev = n2;
        n3.next = n4;   n4.prev = n3;
        n4.next = n5;   n5.prev = n4;
        n5.next = n6;   n6.prev = n5;

        printList(head);
        int secondLargest = findSecondLargest(head);
        System.out.println("Second Largest Element (Without Sorting): " + secondLargest);
    }
}
