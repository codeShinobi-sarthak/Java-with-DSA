package queues;

public class ArrayQueue {
    private final int[] data;
    private static int front, rear;

    private final int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public void enQueue(int val) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        if (front == -1) front++;
        data[++rear] = val;
    }

    public int deQueue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int remove = data[front];
        for (int i = 1; i <= rear; i++) {
            data[i - 1] = data[i];
        }
        rear--;
        return remove;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }

    public void display() {
        for (int i = 0; i <= rear; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println("END");
    }

}
