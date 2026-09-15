package recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

public class RecursionPatterns {

    public static int fibStandard(int n) {
        if (n <= 1) return n;
        return fibStandard(n - 1) + fibStandard(n - 2);
    }

    public static int fibTail(int n, int a, int b) {
        if (n == 0) return a;
        if (n == 1) return b;
        return fibTail(n - 1, b, a + b);
    }

    public static void headRecursionPrint(int n) {
        if (n == 0) return;
        headRecursionPrint(n - 1);
        System.out.print(n + " ");
    }

    public static void tailRecursionPrint(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        tailRecursionPrint(n - 1);
    }

    public static List<String> generateSubstrings(String s) {
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                substrings.add(s.substring(i, j));
            }
        }
        return substrings;
    }

    public static void generateSubsequences(String s, int index, String current, List<String> result) {
        if (index == s.length()) {
            result.add(current);
            return;
        }

        generateSubsequences(s, index + 1, current + s.charAt(index), result);

        generateSubsequences(s, index + 1, current, result);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("          RECURSION PATTERNS DEMONSTRATION       ");
        System.out.println("=================================================");

        int n = 7;
        System.out.println("Fibonacci(" + n + ") Standard: " + fibStandard(n));
        System.out.println("Fibonacci(" + n + ") Tail Recursive: " + fibTail(n, 0, 1));

        System.out.print("\nHead Recursion (1 to 5): ");
        headRecursionPrint(5);
        System.out.println();

        System.out.print("Tail Recursion (5 down to 1): ");
        tailRecursionPrint(5);
        System.out.println();

        String str = "abc";
        System.out.println("\nAll Substrings of \"" + str + "\" (Contiguous): " + generateSubstrings(str));

        List<String> subsequences = new ArrayList<>();
        generateSubsequences(str, 0, "", subsequences);
        System.out.println("All Subsequences of \"" + str + "\" (Include/Exclude): " + subsequences);
    }
}
