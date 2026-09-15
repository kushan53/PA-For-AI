package sliding_window;

import java.util.Arrays;

public class CountSubarraysWithinSumLimit {

    public static int countSubarraysSumAtMostK(int[] nums, int limit) {
        if (nums == null || nums.length == 0 || limit < 0) return 0;

        int left = 0;
        int currentSum = 0;
        int totalSubarrays = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum > limit && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            totalSubarrays += (right - left + 1);
        }

        return totalSubarrays;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int limit = 3;
        System.out.println("Array: " + Arrays.toString(nums) + ", Sum Limit: " + limit);
        System.out.println("Count of subarrays with sum <= " + limit + ": " + countSubarraysSumAtMostK(nums, limit));

        int[] nums2 = { 2, 1, 4, 3, 5 };
        int limit2 = 5;
        System.out.println("\nArray: " + Arrays.toString(nums2) + ", Sum Limit: " + limit2);
        System.out.println("Count of subarrays with sum <= " + limit2 + ": " + countSubarraysSumAtMostK(nums2, limit2));
    }
}
