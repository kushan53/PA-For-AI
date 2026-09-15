package sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VariableSizeSlidingWindowConstraints {

    public static int longestSubarrayWithSumAtMostK(int[] nums, int target) {
        int left = 0;
        int currentSum = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static int longestSubarrayWithAtMostKDistinct(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

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
