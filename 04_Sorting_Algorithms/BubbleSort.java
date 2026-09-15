package sorting_algorithms;

import java.util.Arrays;

/**
 * Question: Implement the Bubble Sort algorithm.
 *
 * Algorithm: Repeatedly steps through the list, compares adjacent elements,
 * and swaps them if they are in the wrong order. An optimization flag `swapped`
 * allows O(N) best case when the array is already sorted.
 *
 * Complexities:
 * Time Complexity: Best: O(N), Average: O(N^2), Worst: O(N^2)
 * Space Complexity: O(1) Auxiliary Space
 * Stability: Stable
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: If no elements were swapped, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.println("Original Array: " + Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println("Sorted Array (Bubble Sort): " + Arrays.toString(arr));
    }
}
