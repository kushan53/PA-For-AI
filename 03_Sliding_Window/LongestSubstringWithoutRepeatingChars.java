package sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * Question: Implement the Sliding Window Technique with a HashSet to find
 * the longest substring with non-repeating (unique) characters. (LeetCode 3)
 *
 * Algorithm:
 * - Maintain a HashSet storing characters in the current window [left...right].
 * - When encountering a duplicate character s[right], remove characters from s[left]
 *   and increment left until the duplicate is eliminated.
 * - Add s[right] and update the maximum window size.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(min(N, M)) where M is the charset size.
 */
public class LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        Set<Character> seen = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        int bestStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // While character is already in the window, shrink from the left
            while (seen.contains(currentChar)) {
                seen.remove(s.charAt(left));
                left++;
            }

            // Add current character to window
            seen.add(currentChar);

            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                bestStart = left;
            }
        }

        System.out.println("Longest unique substring: \"" + s.substring(bestStart, bestStart + maxLength) + "\"");
        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println("Input: \"" + s1 + "\" -> Length: " + lengthOfLongestSubstring(s1));

        String s2 = "bbbbb";
        System.out.println("\nInput: \"" + s2 + "\" -> Length: " + lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println("\nInput: \"" + s3 + "\" -> Length: " + lengthOfLongestSubstring(s3));
    }
}
