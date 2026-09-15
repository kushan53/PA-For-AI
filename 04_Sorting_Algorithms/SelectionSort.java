package sorting_algorithms;

import java.util.Arrays;

/**
 * Question: Implement the Selection Sort algorithm.
 *
 * Algorithm: Divides the input list into two parts: a sorted sublist of items
 * built up from left to right, and a sublist of the remaining unsorted items.
 * In each iteration, it finds the smallest element from the unsorted sublist
 * and swaps it with the leftmost unsorted element.
 *
 * Complexities:
 * Time Complexity: O(N^2) in all cases (Best, Average, Worst)
 * Space Complexity: O(1) Auxiliary Space
 * Stability: Unstable (default in-place implementation)
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum element in the unsorted portion [i...n-1]
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap found minimum element with element at index i
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 29, 10, 14, 37, 13 };
        System.out.println("Original Array: " + Arrays.toString(arr));

        selectionSort(arr);
        System.out.println("Sorted Array (Selection Sort): " + Arrays.toString(arr));
    }
}
