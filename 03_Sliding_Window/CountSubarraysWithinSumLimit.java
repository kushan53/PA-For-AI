package sliding_window;

import java.util.Arrays;

/**
 * Question: Implement the Sliding Window Technique to count valid contiguous
 * subarrays whose sum does not exceed a specific limit (Sum <= K).
 *
 * Mathematical Insight:
 * When the window [left...right] has sum <= K, all subarrays ending at 'right'
 * starting from any index in [left...right] are also valid.
 * The number of such new subarrays added is (right - left + 1).
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class CountSubarraysWithinSumLimit {

    public static int countSubarraysSumAtMostK(int[] nums, int limit) {
        if (nums == null || nums.length == 0 || limit < 0) return 0;

        int left = 0;
        int currentSum = 0;
        int totalSubarrays = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // If current sum exceeds limit, shrink window from left
            while (currentSum > limit && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            // Number of valid subarrays ending at index 'right'
            totalSubarrays += (right - left + 1);
        }

        return totalSubarrays;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int limit = 3;
        System.out.println("Array: " + Arrays.toString(nums) + ", Sum Limit: " + limit);
        System.out.println("Count of subarrays with sum <= " + limit + ": " + countSubarraysSumAtMostK(nums, limit));
        // Valid subarrays: [1] (sum=1), [2] (sum=2), [3] (sum=3), [1, 2] (sum=3) -> Total 4

        int[] nums2 = { 2, 1, 4, 3, 5 };
        int limit2 = 5;
        System.out.println("\nArray: " + Arrays.toString(nums2) + ", Sum Limit: " + limit2);
        System.out.println("Count of subarrays with sum <= " + limit2 + ": " + countSubarraysSumAtMostK(nums2, limit2));
    }
}
