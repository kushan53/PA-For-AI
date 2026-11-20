package queue_assessment;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question4_DequeBasedPalindromeChecker {

    public static boolean checkPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : text.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                deque.addLast(ch);
            }
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPalindrome("Racecar"));
        System.out.println(checkPalindrome("No lemon, no melon"));
        System.out.println(checkPalindrome("Hello World"));
    }
}
