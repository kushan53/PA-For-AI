package queue;

public class LC2073_TimeNeededToBuyTickets {

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], tickets[k]);
            } else {
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        int[] tickets1 = {2, 3, 2};
        System.out.println(timeRequiredToBuy(tickets1, 2));

        int[] tickets2 = {5, 1, 1, 1};
        System.out.println(timeRequiredToBuy(tickets2, 0));
    }
}
