package arrays_and_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question: Implement the Index Negation Technique to find:
 * 1. Duplicate numbers in an array where elements are in the range [1, n].
 * 2. Disappeared / Missing numbers in the range [1, n].
 *
 * Concept: Since numbers range from 1 to n, each number 'val' maps to index |val| - 1.
 * Negating the value at that index marks the number as "seen" without using extra memory.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space (modifying array in-place).
 */
public class IndexNegationTechnique {

    /**
     * Finds all duplicate numbers in an array of size n containing values [1, n].
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        int[] arr = nums.clone(); // Clone to preserve original array

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;

            if (arr[index] < 0) {
                // Already negative -> duplicate found!
                duplicates.add(Math.abs(arr[i]));
            } else {
                // Mark as visited by making it negative
                arr[index] = -arr[index];
            }
        }
        return duplicates;
    }

    /**
     * Finds all disappeared (missing) numbers in an array of size n containing values [1, n].
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappeared = new ArrayList<>();
        int[] arr = nums.clone(); // Clone to preserve original array

        // Step 1: Mark visited indices as negative
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] > 0) {
                arr[index] = -arr[index];
            }
        }

        // Step 2: Any positive index i+1 was never visited
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                disappeared.add(i + 1);
            }
        }
        return disappeared;
    }

    public static void main(String[] args) {
        int[] sampleArray = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println("Original Array: " + Arrays.toString(sampleArray));

        List<Integer> duplicates = findDuplicates(sampleArray);
        System.out.println("Duplicate numbers found: " + duplicates);

        List<Integer> disappeared = findDisappearedNumbers(sampleArray);
        System.out.println("Disappeared (Missing) numbers [1 to " + sampleArray.length + "]: " + disappeared);
    }
}
