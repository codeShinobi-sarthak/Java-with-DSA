public class CircularQueue {
    private final int[] data;
    private static int front, rear;

    private final int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public void enQueue(int val) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        if (front == -1) front = 0;
        rear = (rear + 1) % capacity;
        data[rear] = val;
    }

    public int deQueue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int remove = data[front];
        if (front == rear) { //! basically when whole queue is empty
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return remove;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        if (front == 0 && rear == capacity - 1) {
            return true;
        }
        return front == rear + 1;
    }

    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }

    public void display() {
        if(isEmpty()){
            throw new IllegalStateException();
        }
        int i = front;
        do {
            System.out.print(data[i] + ", ");
            i = (i + 1) % capacity;
        }while(i != rear);
        System.out.print(data[rear] + ", ");
        System.out.println("END");
    }
}
