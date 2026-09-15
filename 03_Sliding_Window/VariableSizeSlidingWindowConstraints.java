package sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Question: Implement the Variable-Sized Sliding Window technique to solve
 * complex continuous subarray constraints:
 * 1. Longest subarray with sum <= target (positive integers).
 * 2. Longest contiguous subarray with at most K distinct elements.
 *
 * Variable-Size Window Pattern:
 * - Expand the right pointer to include elements into the window.
 * - When the constraint is violated, shrink from the left pointer until valid again.
 * - Update the optimal result at each valid window state.
 *
 * Time Complexity: O(N) since each pointer moves at most N times.
 * Space Complexity: O(K) where K is distinct elements limit.
 */
public class VariableSizeSlidingWindowConstraints {

    /**
     * Finds the maximum length of a contiguous subarray whose sum is <= target.
     * All array elements are positive.
     */
    public static int longestSubarrayWithSumAtMostK(int[] nums, int target) {
        int left = 0;
        int currentSum = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // Shrink window if constraint is violated
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            // Window [left...right] is now valid
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Finds the maximum length of a subarray having at most K distinct characters/elements.
     */
    public static int longestSubarrayWithAtMostKDistinct(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            // Shrink window if distinct elements count > k
            while (freqMap.size() > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 0, 1, 1, 0 };
        int target = 4;
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Longest subarray with sum <= " + target + ": Length "
                + longestSubarrayWithSumAtMostK(nums, target));

        int[] distinctTest = { 1, 2, 1, 2, 3, 3, 4, 1 };
        int k = 2;
        System.out.println("\nArray: " + Arrays.toString(distinctTest));
        System.out.println("Longest subarray with at most " + k + " distinct elements: Length "
                + longestSubarrayWithAtMostKDistinct(distinctTest, k));
    }
}
