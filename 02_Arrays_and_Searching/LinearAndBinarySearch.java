package arrays_and_searching;

import java.util.Arrays;

/**
 * Question: Implement Linear and Binary Search algorithms in Java.
 * Includes both Iterative and Recursive implementations of Binary Search.
 *
 * Complexities:
 * Linear Search: Time: O(N), Space: O(1)
 * Binary Search (Iterative): Time: O(log N), Space: O(1)
 * Binary Search (Recursive): Time: O(log N), Space: O(log N) due to recursion stack
 */
public class LinearAndBinarySearch {

    /**
     * Linear Search: Sequentially checks each element.
     * Works on both sorted and unsorted arrays.
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found target at index i
            }
        }
        return -1; // Not found
    }

    /**
     * Binary Search (Iterative): Requires array to be sorted.
     */
    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents potential integer overflow

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Not found
    }

    /**
     * Binary Search (Recursive) helper.
     */
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Base case: search space exhausted
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] unsortedArray = { 64, 25, 12, 22, 11 };
        int[] sortedArray = { 11, 12, 22, 25, 64, 90, 105 };
        int target = 22;

        System.out.println("Unsorted Array: " + Arrays.toString(unsortedArray));
        System.out.println("Linear Search for " + target + ": Index " + linearSearch(unsortedArray, target));

        System.out.println("\nSorted Array: " + Arrays.toString(sortedArray));
        System.out.println("Binary Search (Iterative) for " + target + ": Index " + binarySearchIterative(sortedArray, target));
        System.out.println("Binary Search (Recursive) for " + target + ": Index " + binarySearchRecursive(sortedArray, target, 0, sortedArray.length - 1));

        int notFoundTarget = 99;
        System.out.println("\nSearching for non-existing element " + notFoundTarget + ":");
        System.out.println("Binary Search result: " + binarySearchIterative(sortedArray, notFoundTarget));
    }
}
