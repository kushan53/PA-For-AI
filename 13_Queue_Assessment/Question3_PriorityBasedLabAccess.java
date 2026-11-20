package queue_assessment;

import java.util.PriorityQueue;

public class Question3_PriorityBasedLabAccess {

    static class UserRequest implements Comparable<UserRequest> {
        String userName;
        int rolePriority;
        long timestamp;

        UserRequest(String userName, int rolePriority, long timestamp) {
            this.userName = userName;
            this.rolePriority = rolePriority;
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(UserRequest other) {
            if (this.rolePriority != other.rolePriority) {
                return Integer.compare(other.rolePriority, this.rolePriority);
            }
            return Long.compare(this.timestamp, other.timestamp);
        }

        @Override
        public String toString() {
            return userName + " (Priority: " + rolePriority + ")";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<UserRequest> labQueue = new PriorityQueue<>();
        long time = 0;

        labQueue.add(new UserRequest("Student_A", 1, time++));
        labQueue.add(new UserRequest("Professor_X", 3, time++));
        labQueue.add(new UserRequest("Researcher_Y", 2, time++));
        labQueue.add(new UserRequest("Student_B", 1, time++));

        System.out.println("Lab Access Granted In Order:");
        while (!labQueue.isEmpty()) {
            System.out.println("Accessing Lab: " + labQueue.poll());
        }
    }
}
