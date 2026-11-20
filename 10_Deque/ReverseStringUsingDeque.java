package deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseStringUsingDeque {

    public static String reverseString(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            deque.addLast(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeLast());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
        System.out.println(reverseString("DataStructures"));
    }
}
