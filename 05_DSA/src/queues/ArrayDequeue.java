package queues;

// * Implementing Deque using Circular Array

public class ArrayDequeue {
    private final int[] data;
    private int front, rear;
    private final int capacity;

    // * Constructor to initialize the deque
    public ArrayDequeue(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    // * Insert at front
    public void appendFront(int val) {
        if (isFull()) {
            throw new IllegalStateException("Deque is full");
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        data[front] = val;
    }

    // * Insert at rear
    public void appendRear(int val) {
        if (isFull()) {
            throw new IllegalStateException("Deque is full");
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        data[rear] = val;
    }

    // * Remove from front
    public int popFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }

        int removed = data[front];

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        return removed;
    }

    // * Remove from rear
    public int popRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }

        int removed = data[rear];

        if (front == rear) {
            front = rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }

        return removed;
    }

    // * Check if deque is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // * Check if deque is full
    public boolean isFull() {
        return ((rear + 1) % capacity) == front;
    }

    // * Peek at the front element
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }

        return data[front];
    }

    // * Display all elements from front to rear
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.print("Deque: ");
        int i = front;
        while (true) {
            System.out.print(data[i] + " ");
            if (i == rear) break;
            i = (i + 1) % capacity;
        }
        System.out.println("<-- END");
    }
}
