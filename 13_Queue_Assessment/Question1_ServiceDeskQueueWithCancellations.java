package queue_assessment;

import java.util.Iterator;
import java.util.LinkedList;

public class Question1_ServiceDeskQueueWithCancellations {

    static class Ticket {
        int id;
        String customerName;

        Ticket(int id, String customerName) {
            this.id = id;
            this.customerName = customerName;
        }

        @Override
        public String toString() {
            return "Ticket{" + id + ", '" + customerName + "'}";
        }
    }

    private LinkedList<Ticket> queue = new LinkedList<>();

    public void addTicket(int id, String customerName) {
        queue.add(new Ticket(id, customerName));
    }

    public Ticket serveNext() {
        if (queue.isEmpty()) return null;
        return queue.poll();
    }

    public boolean cancelTicket(int id) {
        Iterator<Ticket> it = queue.iterator();
        while (it.hasNext()) {
            if (it.next().id == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public void displayQueue() {
        System.out.println("Service Desk Queue: " + queue);
    }

    public static void main(String[] args) {
        Question1_ServiceDeskQueueWithCancellations desk = new Question1_ServiceDeskQueueWithCancellations();
        desk.addTicket(101, "Alice");
        desk.addTicket(102, "Bob");
        desk.addTicket(103, "Charlie");
        desk.displayQueue();

        desk.cancelTicket(102);
        desk.displayQueue();

        System.out.println("Served: " + desk.serveNext());
        desk.displayQueue();
    }
}
