package recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC17_LetterCombinationsOfPhone {

    private static final String[] KEYPAD = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
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
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits1 = "23";
        System.out.println("Digits: \"" + digits1 + "\" -> Combinations: " + letterCombinations(digits1));

        String digits2 = "79";
        System.out.println("Digits: \"" + digits2 + "\" -> Combinations: " + letterCombinations(digits2));
    }
}
