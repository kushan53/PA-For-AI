package deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeStringUsingDeque {

    public static boolean isPalindrome(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : s.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                deque.addLast(ch);
            }
        }

        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();
            if (first != last) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("radar"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("hello"));
    }
}
