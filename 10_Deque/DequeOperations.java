package deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeOperations {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        deque.addLast(30);

        System.out.println("Deque: " + deque);
        System.out.println("First element: " + deque.peekFirst());
        System.out.println("Last element: " + deque.peekLast());

        System.out.println("Removed first: " + deque.removeFirst());
        System.out.println("Removed last: " + deque.removeLast());
        System.out.println("Deque after removals: " + deque);

        System.out.println("Is empty: " + deque.isEmpty());
        System.out.println("Size: " + deque.size());
    }
}
