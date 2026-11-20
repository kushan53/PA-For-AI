package queue;

import java.util.LinkedList;
import java.util.Queue;

public class LC346_MovingAverageFromDataStream {

    static class MovingAverage {
        private Queue<Integer> queue;
        private int size;
        private double sum;

        public MovingAverage(int size) {
            this.size = size;
            this.queue = new LinkedList<>();
            this.sum = 0;
        }

        public double next(int val) {
            if (queue.size() == size) {
                sum -= queue.poll();
            }
            queue.add(val);
            sum += val;
            return sum / queue.size();
        }
    }

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        System.out.println(ma.next(1));
        System.out.println(ma.next(10));
        System.out.println(ma.next(3));
        System.out.println(ma.next(5));
    }
}
