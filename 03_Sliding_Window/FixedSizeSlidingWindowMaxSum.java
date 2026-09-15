package sliding_window;

import java.util.Arrays;

/**
 * Question: Implement the Fixed-Size Sliding Window technique to calculate
 * the maximum sum of a fixed-size (k) contiguous subarray.
 *
 * Algorithm:
 * 1. Calculate the sum of the first window of size k.
 * 2. Slide the window one element forward at a time by adding the new incoming element
 *    and subtracting the outgoing element from the left.
 * 3. Update the maximum sum at each step.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class FixedSizeSlidingWindowMaxSum {

    public static int maxSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid window size or array length");
        }

        // 1. Calculate sum of first window of size k
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;
        int startIndex = 0;

        // 2. Slide the window across the rest of the array
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k]; // add incoming, remove outgoing
            if (windowSum > maxSum) {
                maxSum = windowSum;
                startIndex = i - k + 1;
            }
        }

        System.out.println("Maximum sum window starts at index " + startIndex + " -> "
                + Arrays.toString(Arrays.copyOfRange(nums, startIndex, startIndex + k)));
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 5, 1, 3, 2 };
        int k = 3;

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Window Size (k): " + k);

        int maxSum = maxSubarraySum(nums, k);
        System.out.println("Maximum Subarray Sum of size " + k + ": " + maxSum);
    }
}
