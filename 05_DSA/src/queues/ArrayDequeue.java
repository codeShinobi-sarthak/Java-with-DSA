
// * implementing dequeue using circular array method

public class ArrayDequeue {
    private final int[] data;
    private static int front, rear;
    private final int capacity;

    //  * initializing dequeue
    public ArrayDequeue(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public void appendFront(int val) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        if (front == -1) {
            front = rear = 0;
        } else if (front == 0) {
            front = capacity - 1;
        } else {
            front = front - 1 % capacity;
        }
        data[front] = val;
    }

    public void appendRear(int val) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        if (rear == -1) front = 0;
        rear = rear + 1 % capacity;
        data[rear] = val;
    }

    public int popFront() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int remove = data[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return remove;
    }

    public int popRear() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int remove = data[rear];
        if (front == rear) {
            front = rear = -1;
        } else {
            rear = (rear - 1) % capacity;
        }
        return remove;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }

    public void display() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int i = front;
        do {
            System.out.print(data[i] + ", ");
            i = (i + 1) % capacity;
        } while (i != rear);
        System.out.print(data[rear] + ", ");
        System.out.println("END");
    }
}
