package arrays_and_searching;

import java.util.Arrays;

/**
 * Question: Modify binary search to find the first and last occurrences of an
 * element in a sorted array and calculate its total frequency.
 *
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
public class FirstAndLastOccurrenceFrequency {

    /**
     * Finds the first (leftmost) occurrence of target using Binary Search.
     */
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int firstIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                firstIndex = mid;
                right = mid - 1; // Keep searching in left half for earlier occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstIndex;
    }

    /**
     * Finds the last (rightmost) occurrence of target using Binary Search.
     */
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int lastIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                lastIndex = mid;
                left = mid + 1; // Keep searching in right half for later occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastIndex;
    }

    /**
     * Calculates the total frequency of target in O(log N) time.
     */
    public static int countFrequency(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        if (first == -1) {
            return 0; // Element not present
        }
        int last = findLastOccurrence(arr, target);
        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
        int target = 2;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);

        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);
        int freq = countFrequency(arr, target);

        System.out.println("First Occurrence Index: " + first);
        System.out.println("Last Occurrence Index:  " + last);
        System.out.println("Total Frequency:        " + freq);
    }
}
