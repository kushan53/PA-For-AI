package queue_assessment;

import java.util.Stack;

public class Question5_BuildQueueUsingTwoStacks {

    static class QueueUsingTwoStacks {
        private Stack<Integer> inStack = new Stack<>();
        private Stack<Integer> outStack = new Stack<>();

        public void enqueue(int val) {
            inStack.push(val);
        }

        public int dequeue() {
            shiftElements();
            if (outStack.isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return outStack.pop();
        }

        public int peek() {
            shiftElements();
            if (outStack.isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return outStack.peek();
        }

        public boolean isEmpty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void shiftElements() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks q = new QueueUsingTwoStacks();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Peek: " + q.peek());
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Is Empty: " + q.isEmpty());
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Is Empty: " + q.isEmpty());
    }
}
