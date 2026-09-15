package sorting_algorithms;

import java.util.Arrays;

/**
 * LeetCode 75: Sort Colors (Dutch National Flag Problem)
 * Given an array nums with n objects colored red, white, or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We use integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * Must be solved in-place in one pass O(N) time and O(1) space.
 */
public class LC75_SortColors {

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0: // Color Red -> Move to left section
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1: // Color White -> Middle section, just advance
                    mid++;
                    break;
                case 2: // Color Blue -> Move to right section
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] colors1 = { 2, 0, 2, 1, 1, 0 };
        System.out.println("Original: " + Arrays.toString(colors1));
        sortColors(colors1);
        System.out.println("Sorted (Dutch Flag): " + Arrays.toString(colors1));

        int[] colors2 = { 2, 0, 1 };
        System.out.println("\nOriginal: " + Arrays.toString(colors2));
        sortColors(colors2);
        System.out.println("Sorted: " + Arrays.toString(colors2));
    }
}
