package sliding_window;

import java.util.Arrays;

public class FixedSizeSlidingWindowMaxSum {

    public static int maxSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid window size or array length");
        }

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;
        int startIndex = 0;

        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
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
