package heap;

import java.util.Arrays;

public class CustomMaxHeapImplementation {

    private int[] heap;
    private int size;
    private int capacity;

    public CustomMaxHeapImplementation(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    public void insert(int val) {
        if (size == capacity) {
            capacity *= 2;
            heap = Arrays.copyOf(heap, capacity);
        }
        heap[size] = val;
        heapifyUp(size);
        size++;
    }

    private void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int extractMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    public int getMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return heap[0];
    }

    private void heapifyDown(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        CustomMaxHeapImplementation maxHeap = new CustomMaxHeapImplementation(10);
        maxHeap.insert(10);
        maxHeap.insert(40);
        maxHeap.insert(15);
        maxHeap.insert(50);
        maxHeap.insert(30);

        System.out.println("Max element: " + maxHeap.getMax());
        System.out.println("Extract Max: " + maxHeap.extractMax());
        System.out.println("Max element: " + maxHeap.getMax());
    }
}
