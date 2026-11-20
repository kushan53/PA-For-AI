package heap;

import java.util.PriorityQueue;

public class LC378_KthSmallestElementInSortedMatrix {

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        for (int r = 0; r < Math.min(n, k); r++) {
            minHeap.add(new int[]{matrix[r][0], r, 0});
        }

        int count = 0;
        int result = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            result = curr[0];
            count++;

            if (count == k) {
                return result;
            }

            int r = curr[1];
            int c = curr[2];
            if (c + 1 < n) {
                minHeap.add(new int[]{matrix[r][c + 1], r, c + 1});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        System.out.println(kthSmallest(matrix, 8));
    }
}
