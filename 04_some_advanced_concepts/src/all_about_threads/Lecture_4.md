## 🧠 **Thread Interruption in Java** — Overview

In a multi-threaded program, you sometimes need a thread to stop its execution prematurely. For example, a thread might be waiting for some resource or performing a long-running task, and you need to interrupt it to handle specific conditions (like user requests, timeouts, etc.).

In Java, **interrupting a thread** is how you tell it to stop what it’s doing and terminate or handle a situation like "I'm done, please stop!"

---

### 🚨 **What Does Interrupting a Thread Do?**

When you call `thread.interrupt()`, it sets the **interrupted status** of the thread to `true`. This **won't immediately stop** the thread. It's just a signal for the thread to check periodically whether it should **stop its execution**.

---

### ⚡ **Key Methods for Interruption:**

1. **`Thread.interrupt()`**
    - This method sets the interrupt flag of the thread. If the thread is **blocked** (in `sleep()`, `wait()`, `join()`, etc.), it will immediately throw an `InterruptedException`. Otherwise, it won’t stop unless you explicitly check for the interrupt flag in your thread’s code.

2. **`Thread.isInterrupted()`**
    - This method checks the interrupt status of the thread. It returns `true` if the thread has been interrupted.

3. **`Thread.interrupted()`**
    - This static method checks and clears the interrupt flag of the current thread.

---

### 🚀 **Example of Interrupting a Thread**

Let’s create a simple example where we simulate a long-running task (a `sleep` method), and we will **interrupt** it from the main thread.

---

### 🔧 **Example: Interrupting a Thread**

```java
package all_about_threads.assignments;

class LongRunningTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread started: " + Thread.currentThread().getName());
        try {
            for (int i = 0; i < 10; i++) {
                // Simulating long-running task
                System.out.println("Task running: " + i);
                Thread.sleep(1000);  // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            // Thread was interrupted during sleep
            System.out.println("Thread was interrupted during sleep");
        }
        System.out.println("Thread finished: " + Thread.currentThread().getName());
    }
}

public class Assignment4_Interruption {
    public static void main(String[] args) throws InterruptedException {
        Thread longTaskThread = new Thread(new LongRunningTask());
        
        longTaskThread.start(); // Start the thread
        
        // Let the thread run for a while
        Thread.sleep(3000); // Main thread sleeps for 3 seconds
        
        // Interrupt the long-running task thread
        System.out.println("Interrupting the thread...");
        longTaskThread.interrupt();
        
        // Wait for the thread to finish
        longTaskThread.join();
        
        System.out.println("Main thread finished.");
    }
}
```

---

### 🧪 **Expected Output:**

```
Thread started: Thread-0
Task running: 0
Task running: 1
Task running: 2
Interrupting the thread...
Thread was interrupted during sleep
Thread finished: Thread-0
Main thread finished.
```

### 🧠 **How it Works:**
1. **LongRunningTask** starts executing and goes through the loop, printing the task status and sleeping.
2. **Main thread** sleeps for 3 seconds, then interrupts the `longTaskThread`.
3. When `longTaskThread` is in `sleep()`, it **catches the `InterruptedException`** and prints "Thread was interrupted during sleep".
4. After the interruption, the `longTaskThread` finishes its execution.

---

### 🚨 **Important Notes:**

- Interrupting a thread doesn’t stop it immediately — it’s up to the thread to **check the interrupt flag** and respond accordingly.
- If a thread is **blocked** (waiting, sleeping, joining), it’ll throw an `InterruptedException`.
- If it's **not blocked**, you'll need to manually check for `Thread.interrupted()` or `Thread.isInterrupted()` inside the thread’s code.

---