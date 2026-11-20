package stack;

public class StackUsingLinkedList {

    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    private Node top;
    private int size;

    public StackUsingLinkedList() {
        this.top = null;
        this.size = 0;
    }

    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = top.val;
        top = top.next;
        size--;
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return top.val;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(100);
        stack.push(200);
        stack.push(300);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Top element: " + stack.peek());
        System.out.println("Size: " + stack.size());
    }
}
