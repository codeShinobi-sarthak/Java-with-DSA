package queues;

public class LLQueue {
    private Node head;
    private Node tail;

    public void enQueue(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = node;
        }

    }

    public int deQueue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int remove = head.val;
        head = head.next;
        if (head == tail) tail = head;
        return remove;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int head() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.val;
    }

    public void display() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private static class Node {
        private final int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}


