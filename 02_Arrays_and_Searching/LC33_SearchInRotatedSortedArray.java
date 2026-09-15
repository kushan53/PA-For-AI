package arrays_and_searching;

import java.util.Arrays;

/**
 * LeetCode 33: Search in Rotated Sorted Array
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k.
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
public class LC33_SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half [left...mid] is sorted
            if (nums[left] <= nums[mid]) {
                // Target lies in the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Otherwise, right half [mid...right] must be sorted
            else {
                // Target lies in the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target1 = 0;
        int target2 = 3;

        System.out.println("Rotated Array: " + Arrays.toString(nums));
        System.out.println("Search " + target1 + ": Index " + search(nums, target1));
        System.out.println("Search " + target2 + ": Index " + search(nums, target2));
    }
}
