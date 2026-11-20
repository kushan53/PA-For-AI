package queue;

public class CircularQueueImplementation {

    private int[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueueImplementation(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean enqueue(int val) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        data[rear] = val;
        size++;
        return true;
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        int val = data[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    public int front() {
        if (isEmpty()) return -1;
        return data[front];
    }

    public int rear() {
        if (isEmpty()) return -1;
        return data[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CircularQueueImplementation cq = new CircularQueueImplementation(3);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        System.out.println("Enqueue 40: " + cq.enqueue(40));
        System.out.println("Front: " + cq.front());
        System.out.println("Rear: " + cq.rear());
        System.out.println("Dequeued: " + cq.dequeue());
        cq.enqueue(40);
        System.out.println("Rear after enqueue 40: " + cq.rear());
    }
}
