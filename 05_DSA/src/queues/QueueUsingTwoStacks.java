// * implementing queue using two stacks

import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        while (!queue.isEmpty()) {
            System.out.print(queue.peek() + " -> ");
        }
        System.out.println("END");

    }

    public static class QueueWithTwoStacks {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public void add(int val) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(val);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int remove() {
            if (isEmpty()) {
                throw new IllegalStateException();
            }
            return s1.pop();
        }

        public boolean isEmpty() {
            return s1.isEmpty();
        }

        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return s1.pop();
        }
    }
}

