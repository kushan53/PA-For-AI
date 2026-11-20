package priority_queue;

import java.util.PriorityQueue;

public class HospitalManagementPriorityQueue {

    static class Patient implements Comparable<Patient> {
        String name;
        int severity;
        long arrivalTime;

        Patient(String name, int severity, long arrivalTime) {
            this.name = name;
            this.severity = severity;
            this.arrivalTime = arrivalTime;
        }

        @Override
        public int compareTo(Patient other) {
            if (this.severity != other.severity) {
                return Integer.compare(other.severity, this.severity);
            }
            return Long.compare(this.arrivalTime, other.arrivalTime);
        }

        @Override
        public String toString() {
            return name + " (Severity: " + severity + ")";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>();
        long time = 0;

        triageQueue.add(new Patient("John", 2, time++));
        triageQueue.add(new Patient("Alice", 5, time++));
        triageQueue.add(new Patient("Bob", 4, time++));
        triageQueue.add(new Patient("Charlie", 5, time++));

        System.out.println("Treating patients in order of priority:");
        while (!triageQueue.isEmpty()) {
            System.out.println("Treating: " + triageQueue.poll());
        }
    }
}
