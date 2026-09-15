package arrays_and_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question: Implement the two-pointer approach to find pairs of elements in a
 * sorted array that sum up to a specific target value.
 *
 * Time Complexity: O(N) where N is the length of the sorted array.
 * Space Complexity: O(1) auxiliary space (excluding result list).
 */
public class TwoPointerTargetSum {

    /**
     * Finds all unique pairs in a sorted array that sum up to target.
     */
    public static List<int[]> findPairsWithTargetSum(int[] arr, int target) {
        List<int[]> result = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {
                result.add(new int[] { arr[left], arr[right] });
                
                // Move left pointer and avoid duplicates
                int leftVal = arr[left];
                while (left < right && arr[left] == leftVal) {
                    left++;
                }

                // Move right pointer and avoid duplicates
                int rightVal = arr[right];
                while (left < right && arr[right] == rightVal) {
                    right--;
                }
            } else if (currentSum < target) {
                left++; // Increase sum by moving left pointer right
            } else {
                right--; // Decrease sum by moving right pointer left
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] sortedArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11 };
        int target = 10;

        System.out.println("Array: " + Arrays.toString(sortedArr));
        System.out.println("Target Sum: " + target);

        List<int[]> pairs = findPairsWithTargetSum(sortedArr, target);
        System.out.println("Pairs found:");
        for (int[] pair : pairs) {
            System.out.println("  (" + pair[0] + ", " + pair[1] + ")");
        }
    }
}
