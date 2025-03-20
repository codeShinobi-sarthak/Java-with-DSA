import java.util.EmptyStackException;

public class LLStack {
    private Node top;

    private static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public void push(int val) {
        Node temp = new Node(val);
        temp.next = top;
        top = temp;
    }


    // Pop operation (throws EmptyStackException for underflow)
    public int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node temp = top;
        top = top.next;
        return temp.val;
    }

    public int peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.val;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        Node temp = top;
        int count = 1;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void print() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
            if (temp != null) {
                System.out.print(" -> ");
            }
        }
    }
}
