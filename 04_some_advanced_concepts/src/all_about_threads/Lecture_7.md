#  **Lecture 7: Inter-thread Communication, Wait-Notify, and Producer-Consumer Pattern** 🚦🧵
---

### ✅ **Why Inter-thread Communication?**

Sometimes, multiple threads need to coordinate with each other. For example:
- One thread is **producing** data.
- Another thread is **consuming** it.

To prevent **race conditions** or **busy waiting**, Java provides ways for threads to communicate using:

### 🔁 **Key Methods (from Object class):**
| Method     | Description |
|------------|-------------|
| `wait()`   | Causes the current thread to wait until another thread invokes `notify()` or `notifyAll()` on the same object. |
| `notify()` | Wakes up a single thread that is waiting on that object’s monitor. |
| `notifyAll()` | Wakes up all threads waiting on that object’s monitor. |

> ☝️ These must be called **inside synchronized blocks** to work properly.

---

### 💡 **Real-Life Analogy**
Imagine a chef and a waiter:
- The **chef (producer)** prepares a dish and places it on the counter.
- The **waiter (consumer)** picks it up when it's ready.

---

### 🛠️ **Simple Wait-Notify Example**

```java
class SharedResource {
    boolean valueSet = false;

    synchronized void produce() {
        while (valueSet) {
            try { wait(); } catch (InterruptedException e) { }
        }
        System.out.println("Produced");
        valueSet = true;
        notify();
    }

    synchronized void consume() {
        while (!valueSet) {
            try { wait(); } catch (InterruptedException e) { }
        }
        System.out.println("Consumed");
        valueSet = false;
        notify();
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) resource.produce();
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) resource.consume();
        });

        producer.start();
        consumer.start();
    }
}
```

---

### 🔄 **Explanation:**
- `produce()` waits if the item is already produced (valueSet = true).
- `consume()` waits if there’s nothing to consume (valueSet = false).
- `notify()` wakes up the waiting thread once the state changes.

---

### 🍱 **Producer-Consumer with Buffer (Queue-based Version)**

```java
import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(value);
        System.out.println("Produced: " + value);
        notifyAll(); // Wake up consumer(s)
    }

    public synchronized void consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int val = queue.remove();
        System.out.println("Consumed: " + val);
        notifyAll(); // Wake up producer(s)
    }
}

public class PCWithQueue {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.produce(i);
                } catch (InterruptedException e) { }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.consume();
                } catch (InterruptedException e) { }
            }
        });

        producer.start();
        consumer.start();
    }
}
```

---

### 🧠 **Things to Keep in Mind**
- Always use `wait()` and `notify()` in synchronized blocks.
- Use a **loop** (not if) to check the condition before calling `wait()`.
- Prefer `notifyAll()` if multiple threads are waiting (e.g., multiple producers/consumers).

---

### 📝 **Assignment for Lecture 7**

#### **Assignment 1: Simple Chat App (Wait/Notify)**
Create two threads: one that types a message (`Sender`) and another that reads it (`Receiver`). Use `wait()` and `notify()` to coordinate that the receiver only reads after the sender has typed.

#### **Assignment 2: Bounded Buffer**
Build a class with a bounded buffer (size = 3). Make a producer thread and consumer thread that use `wait/notifyAll()` for coordination.

---