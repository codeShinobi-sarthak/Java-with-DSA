# **Lecture 5: Deadlocks, Locks, and Thread Pooling** 🚀.

---

### **Overview:**
In this lecture, we'll explore some **critical concurrency concepts** such as **deadlocks**, **locks**, and **thread pooling**. These are essential for writing efficient and error-free concurrent programs.

---

### **1. Deadlocks**

A **deadlock** occurs when two or more threads are blocked forever because each thread is holding a resource and waiting for the other thread to release a resource. This leads to a situation where the threads can never proceed, causing a **program freeze**.

#### 🧠 **Conditions for Deadlock:**
For a deadlock to occur, all the following conditions must hold:
1. **Mutual Exclusion**: At least one resource is held in a non-shareable mode (e.g., a lock is held by a thread).
2. **Hold and Wait**: A thread holding at least one resource is waiting for additional resources held by other threads.
3. **No Preemption**: Resources cannot be forcibly taken from threads holding them; they must be released voluntarily.
4. **Circular Wait**: A circular chain of threads exists where each thread is waiting for a resource held by the next thread.

#### 🛠️ **Example of Deadlock:**

```java
class A {
    synchronized void methodA(B b) {
        System.out.println("Thread 1: Holding lock A...");
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        System.out.println("Thread 1: Waiting for lock B...");
        b.last();
    }

    synchronized void last() {
        System.out.println("Thread 1: Inside last method of A");
    }
}

class B {
    synchronized void methodB(A a) {
        System.out.println("Thread 2: Holding lock B...");
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        System.out.println("Thread 2: Waiting for lock A...");
        a.last();
    }

    synchronized void last() {
        System.out.println("Thread 2: Inside last method of B");
    }
}

public class DeadlockDemo {
    public static void main(String[] args) {
        final A a = new A();
        final B b = new B();

        // Thread 1
        new Thread(new Runnable() {
            public void run() { a.methodA(b); }
        }).start();

        // Thread 2
        new Thread(new Runnable() {
            public void run() { b.methodB(a); }
        }).start();
    }
}
```

#### 🧪 **Explanation**:
- **Thread 1** holds lock `A` and tries to acquire lock `B`.
- **Thread 2** holds lock `B` and tries to acquire lock `A`.
- Both threads are waiting for each other, causing a **deadlock**.

---

### **2. Locks in Java**

Java provides a mechanism called **locks** for fine-grained control over resource access. **Locks** are used to ensure that only one thread can access a critical section at a time, preventing race conditions and deadlocks.

#### 🛠️ **ReentrantLock Example**:

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to " + count);
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

public class LockExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.getCount());
    }
}
```

#### 🧪 **Explanation**:
- **ReentrantLock** allows for mutual exclusion to ensure that only one thread can execute the critical section at a time.
- **lock.lock()** acquires the lock.
- **lock.unlock()** releases the lock.
- The `finally` block ensures that the lock is released, even if an exception occurs during execution.

---

### **3. Thread Pooling**

**Thread pooling** is a technique where a pool of threads is created to handle multiple tasks. Rather than creating a new thread for each task, threads are reused from the pool, which improves **performance**, reduces **overhead**, and provides better control over the execution of tasks.

#### 🧠 **Benefits of Thread Pooling:**
- **Efficiency**: Threads are reused, so you don’t need to create new threads every time.
- **Reduced Latency**: Pooling reduces the time spent on thread creation and destruction.
- **Resource Management**: You can limit the number of threads used in a program, ensuring you don't overload your system.

#### 🛠️ **Thread Pool Example**:

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private final String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " executing task: " + taskName);
    }
}

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to the executor
        executor.submit(new Task("Task 1"));
        executor.submit(new Task("Task 2"));
        executor.submit(new Task("Task 3"));
        executor.submit(new Task("Task 4"));
        executor.submit(new Task("Task 5"));

        // Shutdown the executor
        executor.shutdown();
    }
}
```

#### 🧪 **Explanation**:
- The thread pool is created using `Executors.newFixedThreadPool(3)`, which means there will be a maximum of 3 threads running concurrently.
- Tasks are submitted to the pool using `submit()`.
- The **ExecutorService** manages the threads, and once all tasks are completed, `shutdown()` is called to stop the executor.

---

### **4. Synchronization in Context of Deadlocks and Locks**

- **Synchronized Methods/Blocks**: Helps to ensure that only one thread can execute a block of code or method at a time. However, it can lead to deadlocks if not used carefully.
- **Locks (ReentrantLock)**: Provide more flexibility and finer control than `synchronized` methods/blocks. They help prevent deadlocks by allowing threads to acquire multiple locks and avoid blocking.

---

### **🧪 Assignment 5: Deadlock Simulation**
Create a deadlock scenario like the one mentioned above (where two threads are waiting for each other to release resources). You can extend the `A` and `B` classes with additional methods. Try to break the deadlock using techniques like lock ordering or using timeouts.

---

### **🧪 Assignment 6: Using Reentrant Locks**
Modify the `Counter` class example to create two counters, `counter1` and `counter2`, and use **ReentrantLock** to synchronize their increment operations. Ensure that the `increment` method of `counter1` cannot be executed while `counter2` is being updated, and vice versa.

---

### **Next Steps:**
1. **Deadlock Handling**: We'll explore methods to **avoid and recover** from deadlocks in future lectures.
2. **Using More Advanced Locks**: We can explore **ReadWriteLock** for concurrent read operations.
3. **Thread Pooling Strategies**: We'll also go deeper into how thread pool sizes affect performance in multi-threaded applications.




---

# So Little Bit Detailed BreakDown

## 💥 The Deadlock Code (from Lecture 5)

### Let's look at this snippet again 👇

```java
class A {
    synchronized void methodA(B b) {
        System.out.println("Thread 1: Holding lock A...");
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        System.out.println("Thread 1: Waiting for lock B...");
        b.last();  // 🔒 trying to get lock on object B
    }

    synchronized void last() {
        System.out.println("Thread 1: Inside last method of A");
    }
}

class B {
    synchronized void methodB(A a) {
        System.out.println("Thread 2: Holding lock B...");
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        System.out.println("Thread 2: Waiting for lock A...");
        a.last();  // 🔒 trying to get lock on object A
    }

    synchronized void last() {
        System.out.println("Thread 2: Inside last method of B");
    }
}
```

---

### 🧠 Step-by-Step Breakdown of the Locking

#### 1️⃣ What does `synchronized` mean?
It means: **Lock the object** so no one else can use it until I’m done with it 🔐

---

### 🚦 Now, Let’s Simulate the Deadlock Step by Step:

#### 🧵 Thread 1 calls `a.methodA(b)`
- It **locks object `a`** (because `methodA()` is synchronized on `A`)
- Then it **sleeps** for 100ms
- After sleeping, it says: _"Hey, I want to call `b.last()`"_ 🔓
- But `b.last()` is **synchronized**, so it needs the **lock on `b`**

👉 So now Thread 1 is:
- Holding lock on `A`
- Waiting for lock on `B`

---

#### 🧵 Thread 2 calls `b.methodB(a)`
- It **locks object `b`** (because `methodB()` is synchronized on `B`)
- Then it **sleeps** for 100ms
- After sleeping, it says: _"Hey, I want to call `a.last()`"_ 🔓
- But `a.last()` is **synchronized**, so it needs the **lock on `A`**

👉 So now Thread 2 is:
- Holding lock on `B`
- Waiting for lock on `A`

---

### 💣 Boom! Deadlock!
Both threads are like this:

```
Thread 1: holds lock A ➡ wants lock B
Thread 2: holds lock B ➡ wants lock A
```

Neither can proceed.
Each is **waiting forever** for the other to release a lock.
That's your **classic deadlock** 🍝 — tangled up like spaghetti 🍜.

---

### 🧠 So, the locks are happening because:

- `synchronized` on `methodA()` → locks object `a`
- `synchronized` on `methodB()` → locks object `b`
- Then each one **tries to enter the other's locked method**, and gets stuck 🚫

---

### 🧩 Want to Visualize It?

```plaintext
Thread 1                Thread 2
---------               ---------
Locks A                 Locks B
↓                       ↓
Sleeps                  Sleeps
↓                       ↓
Wants B (blocked)       Wants A (blocked)
```

Deadlock baby! 💀

---

### 🤔 So… What **object** is getting locked when we use `synchronized`?

In Java:

```java
synchronized void methodA(B b) {
    // ...
}
```

This means the method is **locking the object it's called on** — in this case, the instance of **`A`**.

---

### 🔐 Here's the golden rule:

> **When you call a `synchronized` method, the thread acquires a lock on the object the method belongs to.**

So let's map it to our example:

---

## 🔎 Breaking it down:

```java
a.methodA(b); // called by Thread 1
```

➡️ `methodA` is synchronized, so Thread 1 **locks the object `a`**  
Then it tries to call `b.last()`, which is also synchronized  
➡️ So it tries to **lock object `b`** (but it's already locked by Thread 2 😬)

---

```java
b.methodB(a); // called by Thread 2
```

➡️ `methodB` is synchronized, so Thread 2 **locks the object `b`**  
Then it tries to call `a.last()`, which is also synchronized  
➡️ So it tries to **lock object `a`** (but it's already locked by Thread 1 😩)

---

### 🔒 Summary of Object Locks:

| Thread   | Method Called   | Locks This Object |
|----------|------------------|-------------------|
| Thread 1 | `a.methodA(b)`   | `a`               |
| Thread 2 | `b.methodB(a)`   | `b`               |
| Thread 1 | wants to call `b.last()` | needs lock on `b` |
| Thread 2 | wants to call `a.last()` | needs lock on `a` |

So the exact **objects** being locked are:
- `a` → by Thread 1
- `b` → by Thread 2

And they’re both **waiting for each other’s locked object**, which creates the deadlock 🔁