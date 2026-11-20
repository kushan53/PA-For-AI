package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC973_KClosestPointsToOrigin {

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1])
        );

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] points1 = {{1, 3}, {-2, 2}};
        int[][] res1 = kClosest(points1, 1);
        System.out.println(Arrays.deepToString(res1));

        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] res2 = kClosest(points2, 2);
        System.out.println(Arrays.deepToString(res2));
    }
}
