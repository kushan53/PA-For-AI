package heap;

import java.util.Arrays;

public class LC621_TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        Arrays.sort(freq);
        int maxFreq = freq[25];
        int maxCount = 0;

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == maxFreq) {
                maxCount++;
            } else {
                break;
            }
        }

        int intervals = (maxFreq - 1) * (n + 1) + maxCount;
        return Math.max(intervals, tasks.length);
    }

    public static void main(String[] args) {
        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(tasks1, 2));

        char[] tasks2 = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(tasks2, 0));
    }
}
