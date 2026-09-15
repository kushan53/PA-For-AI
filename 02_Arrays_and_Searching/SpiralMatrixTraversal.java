package arrays_and_searching;

import java.util.ArrayList;
import java.util.List;

/**
 * Question: Implement Spiral Matrix Traversal.
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Time Complexity: O(M * N)
 * Space Complexity: O(1) auxiliary space (excluding result list)
 */
public class SpiralMatrixTraversal {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1. Traverse Right along the top boundary
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // 2. Traverse Down along the right boundary
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // 3. Traverse Left along the bottom boundary (if still within bounds)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // 4. Traverse Up along the left boundary (if still within bounds)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            { 1,  2,  3,  4 },
            { 5,  6,  7,  8 },
            { 9, 10, 11, 12 }
        };

        System.out.println("Original Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }

        List<Integer> spiral = spiralOrder(matrix);
        System.out.println("\nSpiral Order Traversal:");
        System.out.println(spiral);
    }
}
