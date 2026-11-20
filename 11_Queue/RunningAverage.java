package queue;

import java.util.LinkedList;
import java.util.Queue;

public class RunningAverage {

    private Queue<Double> window;
    private int period;
    private double sum;

    public RunningAverage(int period) {
        this.period = period;
        this.window = new LinkedList<>();
        this.sum = 0;
    }

    public double addNumber(double num) {
        sum += num;
        window.add(num);

        if (window.size() > period) {
            sum -= window.poll();
        }

        return sum / window.size();
    }

    public static void main(String[] args) {
        RunningAverage ra = new RunningAverage(3);
        double[] stream = {10.0, 20.0, 30.0, 40.0, 50.0};
        for (double val : stream) {
            System.out.println("Added: " + val + ", Running Avg: " + ra.addNumber(val));
        }
    }
}
