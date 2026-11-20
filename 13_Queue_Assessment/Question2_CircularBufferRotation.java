package queue_assessment;

public class Question2_CircularBufferRotation {

    private int[] buffer;
    private int capacity;
    private int size;
    private int head;

    public Question2_CircularBufferRotation(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.size = 0;
        this.head = 0;
    }

    public void add(int val) {
        int tail = (head + size) % capacity;
        buffer[tail] = val;
        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity;
        }
    }

    public void rotate(int k) {
        if (size == 0) return;
        k = k % size;
        head = (head - k + capacity) % capacity;
    }

    public void printBuffer() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % capacity] + (i < size - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Question2_CircularBufferRotation cb = new Question2_CircularBufferRotation(5);
        cb.add(1);
        cb.add(2);
        cb.add(3);
        cb.add(4);
        cb.add(5);
        cb.printBuffer();

        cb.rotate(2);
        cb.printBuffer();
    }
}
