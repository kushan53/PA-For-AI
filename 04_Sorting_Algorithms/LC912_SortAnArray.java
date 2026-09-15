package sorting_algorithms;

import java.util.Arrays;

public class LC912_SortAnArray {

    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;

        int n = nums.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        for (int i = n - 1; i > 0; i--) {

            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums, i, 0);
        }

        return nums;
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 5, 2, 3, 1 };
        System.out.println("Original: " + Arrays.toString(nums1));
        System.out.println("Sorted:   " + Arrays.toString(sortArray(nums1)));

        int[] nums2 = { 5, 1, 1, 2, 0, 0 };
        System.out.println("\nOriginal: " + Arrays.toString(nums2));
        System.out.println("Sorted:   " + Arrays.toString(sortArray(nums2)));
    }
}
