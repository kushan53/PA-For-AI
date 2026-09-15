package recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 401: Binary Watch
 * A binary watch has 4 LEDs on the top (hours 0-11) and 6 LEDs on the bottom (minutes 0-59).
 * Given an integer turnedOn which represents the number of LEDs that are currently on,
 * return all possible times the watch could represent.
 *
 * Implements:
 * 1. Backtracking approach (generating combinations of LEDs)
 * 2. Bit Counting approach (Integer.bitCount)
 *
 * Time Complexity: O(1) as total watch states are fixed (12 * 60 = 720 states)
 * Space Complexity: O(1) auxiliary space
 */
public class LC401_BinaryWatch {

    /**
     * Bit count approach
     */
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
