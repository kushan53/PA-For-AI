package arrays_and_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndexNegationTechnique {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        int[] arr = nums.clone();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;

            if (arr[index] < 0) {

                duplicates.add(Math.abs(arr[i]));
            } else {

                arr[index] = -arr[index];
            }
        }
        return duplicates;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappeared = new ArrayList<>();
        int[] arr = nums.clone();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] > 0) {
                arr[index] = -arr[index];
            }
        }

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
