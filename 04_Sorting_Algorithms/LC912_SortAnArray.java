package sorting_algorithms;

import java.util.Arrays;

/**
 * LeetCode 912: Sort an Array
 * Given an array of integers nums, sort the array in ascending order and return it.
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity
 * and with the smallest corresponding space complexity possible.
 *
 * Implemented using Heap Sort for O(N log N) time and O(1) auxiliary space.
 */
public class LC912_SortAnArray {

    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;

        int n = nums.length;

        // 1. Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // 2. Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // Call max heapify on the reduced heap
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

            // Recursively heapify the affected sub-tree
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
