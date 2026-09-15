package recursion_and_backtracking;

import java.util.Arrays;

public class LC198_HouseRobber {

    public static int robMemo(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robHelper(nums, 0, memo);
    }

    private static int robHelper(int[] nums, int index, int[] memo) {
        if (index >= nums.length) return 0;
        if (memo[index] != -1) return memo[index];

        int robCurrent = nums[index] + robHelper(nums, index + 2, memo);

        int skipCurrent = robHelper(nums, index + 1, memo);

        return memo[index] = Math.max(robCurrent, skipCurrent);
    }

    public static int robDP(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0;
        int prev1 = 0;

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
