package arrays_and_searching;

import java.util.Arrays;

public class LC34_FindFirstAndLastPosition {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 };
        if (nums == null || nums.length == 0) return result;

        result[0] = findBound(nums, target, true);
        if (result[0] != -1) {
            result[1] = findBound(nums, target, false);
        }

        return result;
    }

    private static int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }

    public static void main(String[] args) {
        int[] nums1 = { 5, 7, 7, 8, 8, 10 };
        int target1 = 8;
        System.out.println("Nums: " + Arrays.toString(nums1) + ", Target: " + target1 + " -> Result: " + Arrays.toString(searchRange(nums1, target1)));

        int[] nums2 = { 5, 7, 7, 8, 8, 10 };
        int target2 = 6;
        System.out.println("Nums: " + Arrays.toString(nums2) + ", Target: " + target2 + " -> Result: " + Arrays.toString(searchRange(nums2, target2)));

        int[] nums3 = {};
        int target3 = 0;
        System.out.println("Nums: " + Arrays.toString(nums3) + ", Target: " + target3 + " -> Result: " + Arrays.toString(searchRange(nums3, target3)));
    }
}
