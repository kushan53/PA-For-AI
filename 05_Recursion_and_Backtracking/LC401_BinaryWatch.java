package recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC401_BinaryWatch {

    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();
        if (turnedOn < 0 || turnedOn > 8) return times;

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }

    public static void main(String[] args) {
        int turnedOn1 = 1;
        System.out.println("Turned On LEDs: " + turnedOn1);
        System.out.println("Possible times: " + readBinaryWatch(turnedOn1));

        int turnedOn2 = 2;
        System.out.println("\nTurned On LEDs: " + turnedOn2);
        System.out.println("Possible times: " + readBinaryWatch(turnedOn2));
    }
}
