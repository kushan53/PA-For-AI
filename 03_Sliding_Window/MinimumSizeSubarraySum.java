package sliding_window;

import java.util.Arrays;

/**
 * Question: Implement the Sliding Window Technique to determine the minimum length
 * of a contiguous subarray whose sum is greater than or equal to a target sum. (LeetCode 209)
 * If no such subarray exists, return 0.
 *
 * Time Complexity: O(N) since both left and right pointers traverse at most N times.
 * Space Complexity: O(1)
 */
public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int minLen = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // Contract the window as long as sum >= target
            while (currentSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static void main(String[] args) {
        int target1 = 7;
        int[] nums1 = { 2, 3, 1, 2, 4, 3 };
        System.out.println("Array: " + Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("Min Subarray Length: " + minSubArrayLen(target1, nums1)); // Expected: 2 ([4, 3])

        int target2 = 4;
        int[] nums2 = { 1, 4, 4 };
        System.out.println("\nArray: " + Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("Min Subarray Length: " + minSubArrayLen(target2, nums2)); // Expected: 1 ([4])

        int target3 = 11;
        int[] nums3 = { 1, 1, 1, 1, 1, 1, 1, 1 };
        System.out.println("\nArray: " + Arrays.toString(nums3) + ", Target: " + target3);
        System.out.println("Min Subarray Length: " + minSubArrayLen(target3, nums3)); // Expected: 0
    }
}
