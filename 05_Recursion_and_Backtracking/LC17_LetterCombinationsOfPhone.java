package recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 17: Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent. Return the answer in any order.
 *
 * Mapping:
 * 2 -> "abc", 3 -> "def", 4 -> "ghi", 5 -> "jkl", 6 -> "mno",
 * 7 -> "pqrs", 8 -> "tuv", 9 -> "wxyz"
 *
 * Time Complexity: O(4^N * N) where N is length of digits string
 * Space Complexity: O(N) recursion stack
 */
public class LC17_LetterCombinationsOfPhone {

    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return combinations;

        backtrack(digits, 0, new StringBuilder(), combinations);
        return combinations;
    }

    private static void backtrack(String digits, int index, StringBuilder current, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, combinations);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        String digits1 = "23";
        System.out.println("Digits: \"" + digits1 + "\" -> Combinations: " + letterCombinations(digits1));

        String digits2 = "79";
        System.out.println("Digits: \"" + digits2 + "\" -> Combinations: " + letterCombinations(digits2));
    }
}
