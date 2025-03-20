package stack;

public class ArrayStack {
    protected int[] data;
    private int capacity = 10;
    private int ptr = -1;

    public ArrayStack() {
        this.data = new int[capacity];
    }

    public ArrayStack(int size) {
        this.data = new int[size];
        this.capacity = size;
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public boolean isFull() {
        return ptr == capacity - 1;
    }

    public void push(int item) throws StackException {
        if (isFull()) {
            throw new StackException("Stack is already full");
        }
        data[++ptr] = item;
    }

    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("stack is empty can not pop");
        }
        return data[ptr--];
    }

    public int peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot peek from an empty stack!!");
        }
        return data[ptr];
    }

    void print() {
        for (int i = 0; i < capacity; i++) {
            System.out.println(data[i]);
        }
    }

}
