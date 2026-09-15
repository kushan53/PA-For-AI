package sorting_algorithms;

import java.util.Arrays;

/**
 * LeetCode 88: Merge Sorted Array
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 *
 * Algorithm: Three-pointer backward traversal to avoid overwriting elements in nums1.
 * Time Complexity: O(M + N)
 * Space Complexity: O(1) Auxiliary Space
 */
public class LC88_MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;        // Pointer for nums1 valid elements
        int p2 = n - 1;        // Pointer for nums2 elements
        int p = m + n - 1;     // Pointer for placing largest elements from back of nums1

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // If nums2 still has remaining elements, place them in nums1
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;

        System.out.println("nums1: " + Arrays.toString(nums1) + " (m=" + m + ")");
        System.out.println("nums2: " + Arrays.toString(nums2) + " (n=" + n + ")");

        merge(nums1, m, nums2, n);
        System.out.println("Merged nums1: " + Arrays.toString(nums1));
    }
}
