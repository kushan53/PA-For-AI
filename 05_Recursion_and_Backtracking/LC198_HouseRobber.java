package recursion_and_backtracking;

import java.util.Arrays;

/**
 * LeetCode 198: House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * Adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Implements:
 * 1. Recursive + Memoization approach: O(N) Time, O(N) Space
 * 2. Bottom-up Space-Optimized Dynamic Programming: O(N) Time, O(1) Space
 */
public class LC198_HouseRobber {

    /**
     * Approach 1: Recursive with Memoization (Top-Down)
     */
    public static int robMemo(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robHelper(nums, 0, memo);
    }

    private static int robHelper(int[] nums, int index, int[] memo) {
        if (index >= nums.length) return 0;
        if (memo[index] != -1) return memo[index];

        // Choice 1: Rob current house and move to index + 2
        int robCurrent = nums[index] + robHelper(nums, index + 2, memo);

        // Choice 2: Skip current house and move to index + 1
        int skipCurrent = robHelper(nums, index + 1, memo);

        return memo[index] = Math.max(robCurrent, skipCurrent);
    }

    /**
     * Approach 2: Bottom-Up Dynamic Programming with O(1) Space
     */
    public static int robDP(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0; // max money up to i-2
        int prev1 = 0; // max money up to i-1

        for (int num : nums) {
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] houses1 = { 1, 2, 3, 1 };
        System.out.println("Houses: " + Arrays.toString(houses1));
        System.out.println("Max Loot (Memoization): " + robMemo(houses1));
        System.out.println("Max Loot (Space-Optimized DP): " + robDP(houses1));

        int[] houses2 = { 2, 7, 9, 3, 1 };
        System.out.println("\nHouses: " + Arrays.toString(houses2));
        System.out.println("Max Loot (Memoization): " + robMemo(houses2));
        System.out.println("Max Loot (Space-Optimized DP): " + robDP(houses2));
    }
}
