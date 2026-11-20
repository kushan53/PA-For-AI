package queue;

public class LC641_DesignCircularDeque {

    static class MyCircularDeque {
        private int[] data;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public MyCircularDeque(int k) {
            capacity = k;
            data = new int[k];
            front = 0;
            rear = 0;
            size = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;
            front = (front - 1 + capacity) % capacity;
            data[front] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;
            data[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) return -1;
            return data[front];
        }

        public int getRear() {
            if (isEmpty()) return -1;
            return data[(rear - 1 + capacity) % capacity];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        System.out.println(deque.insertLast(1));
        System.out.println(deque.insertLast(2));
        System.out.println(deque.insertFront(3));
        System.out.println(deque.insertFront(4));
        System.out.println(deque.getRear());
        System.out.println(deque.isFull());
        System.out.println(deque.deleteLast());
        System.out.println(deque.insertFront(4));
        System.out.println(deque.getFront());
    }
}
