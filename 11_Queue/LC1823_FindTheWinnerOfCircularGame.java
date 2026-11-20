package queue;

import java.util.LinkedList;
import java.util.Queue;

public class LC1823_FindTheWinnerOfCircularGame {

    public static int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner(6, 5));
    }
}
