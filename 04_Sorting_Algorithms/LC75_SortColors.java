package sorting_algorithms;

import java.util.Arrays;

public class LC75_SortColors {

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
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
