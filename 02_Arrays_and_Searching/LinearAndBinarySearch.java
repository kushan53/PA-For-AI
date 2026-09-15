package arrays_and_searching;

import java.util.Arrays;

public class LinearAndBinarySearch {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
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
