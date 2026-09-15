package sorting_algorithms;

import java.util.Arrays;

/**
 * Question: Implement the Merge Sort algorithm.
 *
 * Algorithm: Divide and Conquer paradigm.
 * 1. Divide: Recursively split array into two halves until single-element subarrays remain.
 * 2. Conquer: Recursively sort each half.
 * 3. Combine: Merge the two sorted halves into a single sorted array.
 *
 * Complexities:
 * Time Complexity: O(N log N) in all cases (Best, Average, Worst)
 * Space Complexity: O(N) auxiliary space for temp arrays
 * Stability: Stable
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++) rightArr[j] = arr[mid + 1 + j];

        // Merge temp arrays back into arr[left..right]
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements of leftArr[], if any
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements of rightArr[], if any
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
        System.out.println("Original Array: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array (Merge Sort): " + Arrays.toString(arr));
    }
}
