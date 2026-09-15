package recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Question: Implement recursive patterns:
 * 1. Fibonacci (Basic Recursion vs Tail Recursion vs Memoization)
 * 2. Substrings vs. Subsequences Generation
 * 3. Head Recursion vs. Tail Recursion
 */
public class RecursionPatterns {

    // -------------------------------------------------------------
    // 1. FIBONACCI PATTERNS
    // -------------------------------------------------------------

    /**
     * Standard Tree-Recursion for Nth Fibonacci number.
     * Time: O(2^N), Space: O(N)
     */
    public static int fibStandard(int n) {
        if (n <= 1) return n;
        return fibStandard(n - 1) + fibStandard(n - 2);
    }

    /**
     * Tail Recursive Fibonacci.
     * Time: O(N), Space: O(N) stack frames (optimizable to O(1) in tail-call optimizers)
     */
    public static int fibTail(int n, int a, int b) {
        if (n == 0) return a;
        if (n == 1) return b;
        return fibTail(n - 1, b, a + b);
    }

    // -------------------------------------------------------------
    // 2. HEAD VS TAIL RECURSION
    // -------------------------------------------------------------

    /**
     * Head Recursion: Recursive call is made BEFORE doing other work.
     * Prints numbers in ascending order 1 to N.
     */
    public static void headRecursionPrint(int n) {
        if (n == 0) return;
        headRecursionPrint(n - 1);
        System.out.print(n + " ");
    }

    /**
     * Tail Recursion: Recursive call is the LAST operation in the function.
     * Prints numbers in descending order N down to 1.
     */
    public static void tailRecursionPrint(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        tailRecursionPrint(n - 1);
    }

    // -------------------------------------------------------------
    // 3. SUBSTRINGS VS SUBSEQUENCES
    // -------------------------------------------------------------

    /**
     * Substrings: Contiguous slices of a string.
     */
    public static List<String> generateSubstrings(String s) {
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                substrings.add(s.substring(i, j));
            }
        }
        return substrings;
    }

    /**
     * Subsequences: Can be non-contiguous (maintains relative order).
     * Generated recursively via Include/Exclude decision tree.
     */
    public static void generateSubsequences(String s, int index, String current, List<String> result) {
        if (index == s.length()) {
            result.add(current);
            return;
        }

        // Choice 1: Include current character
        generateSubsequences(s, index + 1, current + s.charAt(index), result);

        // Choice 2: Exclude current character
        generateSubsequences(s, index + 1, current, result);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("          RECURSION PATTERNS DEMONSTRATION       ");
        System.out.println("=================================================");

        // 1. Fibonacci
        int n = 7;
        System.out.println("Fibonacci(" + n + ") Standard: " + fibStandard(n));
        System.out.println("Fibonacci(" + n + ") Tail Recursive: " + fibTail(n, 0, 1));

        // 2. Head vs Tail Recursion
        System.out.print("\nHead Recursion (1 to 5): ");
        headRecursionPrint(5);
        System.out.println();

        System.out.print("Tail Recursion (5 down to 1): ");
        tailRecursionPrint(5);
        System.out.println();

        // 3. Substrings vs Subsequences
        String str = "abc";
        System.out.println("\nAll Substrings of \"" + str + "\" (Contiguous): " + generateSubstrings(str));

        List<String> subsequences = new ArrayList<>();
        generateSubsequences(str, 0, "", subsequences);
        System.out.println("All Subsequences of \"" + str + "\" (Include/Exclude): " + subsequences);
    }
}
