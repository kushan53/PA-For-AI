package recursion_and_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC78_Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            current.add(nums[i]);

            backtrack(nums, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println("Input: " + Arrays.toString(nums));

        List<List<Integer>> powerSet = subsets(nums);
        System.out.println("Power Set (" + powerSet.size() + " subsets):");
        for (List<Integer> subset : powerSet) {
            System.out.println("  " + subset);
        }
    }
}
