## 🎓 **Lecture 2: Java Thread Lifecycle & Useful Methods**

---

### 🧠 What’s the lifecycle of a thread?

> A thread goes through **various states** — just like a student: born, studying, waiting, maybe sleeping in class 🥱, and finally graduating!

---

### 🌀 **Java Thread Lifecycle Diagram**

```text
          +----------------------+
          |     NEW              |
          +----------------------+
                     |
                  start()
                     ↓
          +----------------------+
          |    RUNNABLE          |
          +----------------------+
         /                        \
   Waiting/Blocked/Sleeping       ↓
        ↖                   +-------------+
                            |   TERMINATED |
                            +-------------+
```

---

### 📌 Thread States Explained:

| State        | Description |
|--------------|-------------|
| `NEW`        | Thread object is created but not started |
| `RUNNABLE`   | Thread is ready to run, waiting for CPU |
| `RUNNING`    | Thread is executing |
| `BLOCKED`    | Waiting to access a locked resource |
| `WAITING`    | Waiting indefinitely for another thread to signal |
| `TIMED_WAITING` | Waiting for a specific time (e.g., sleep) |
| `TERMINATED` | Thread has finished or crashed |

---

## 🛠️ Key Thread Methods (used in real projects)

### 1. **`start()`**
Starts a new thread — invokes `run()` in a new call stack.

```java
t1.start(); // launches a new thread
```

---

### 2. **`sleep(milliseconds)`**
Pauses current thread for specified time.

```java
Thread.sleep(1000); // sleep for 1 second
```

🔍 Used to simulate time delay or reduce CPU usage.

---

### 3. **`join()`**
Waits for a thread to finish.

```java
t1.join(); // main thread waits until t1 finishes
```

🧠 Imagine you're doing group work — you can’t move on until your teammate is done.

---

### 4. **`setName()` and `getName()`**

```java
t1.setName("Downloader");
System.out.println(t1.getName());
```

---

### 5. **`setPriority()` and `getPriority()`**

Java allows 3 levels:

```java
Thread.MIN_PRIORITY  // 1
Thread.NORM_PRIORITY // 5 (default)
Thread.MAX_PRIORITY  // 10
```

But JVM *may ignore* priority hints depending on OS.

```java
t1.setPriority(Thread.MAX_PRIORITY);
```

---

## 💻 Example: join(), sleep(), getName()

```java
class MyTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("🧵 " + Thread.currentThread().getName() + " → Count: " + i);
            try {
                Thread.sleep(1000); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask(), "Alpha");
        Thread t2 = new Thread(new MyTask(), "Beta");

        t1.start();
        t2.start();

        try {
            t1.join(); // wait for Alpha
            t2.join(); // wait for Beta
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("✅ Main thread finished after Alpha & Beta");
    }
}
```

---

## 🧾 Sample Output

```
🧵 Alpha → Count: 1
🧵 Beta → Count: 1
🧵 Alpha → Count: 2
🧵 Beta → Count: 2
🧵 Alpha → Count: 3
🧵 Beta → Count: 3
✅ Main thread finished after Alpha & Beta
```

(Note: The order may vary since threads run in parallel!)

---

## ✅ Assignment Time (assignment 2)

1. Create 2 threads named `"Ping"` and `"Pong"` using `Runnable`.
2. `"Ping"` should print "Ping" 5 times with 500ms delay.
3. `"Pong"` should print "Pong" 5 times with 700ms delay.
4. Use `join()` in main so that `"Main thread done"` is printed only after both threads finish.


---

## 🧵 **Daemon Threads in Java – Full Notes**

### 🔰 **Definition**
A **daemon thread** is a background thread that provides services to **user threads**. It runs in the background and **does not prevent** the Java Virtual Machine (JVM) from exiting when all **user threads** have finished.

> “As soon as all user threads finish, daemon threads are abandoned and the JVM exits.”

---

### 💡 **Key Characteristics**
| Property                         | Description                                                                 |
|----------------------------------|-----------------------------------------------------------------------------|
| **Runs in background**          | Performs low-priority tasks like garbage collection, timers, logging, etc. |
| **Dies with JVM**               | JVM will exit when only daemon threads are running.                        |
| **Service provider threads**    | Supports user threads with auxiliary services.                             |
| **Must be set before start()**  | You must call `setDaemon(true)` before starting the thread.               |

---

### 🛠️ **How to Create a Daemon Thread**
```java
Thread daemonThread = new Thread(() -> {
    while (true) {
        System.out.println("Background running...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            break;
        }
    }
});

daemonThread.setDaemon(true); // Must be before start()
daemonThread.start();
```

---

### ✅ **Key Methods**
- `setDaemon(true/false)` → Sets the thread as daemon.
- `isDaemon()` → Checks whether a thread is a daemon.

---

### 📌 **User Thread vs Daemon Thread**
| Feature             | User Thread                 | Daemon Thread                       |
|---------------------|-----------------------------|--------------------------------------|
| **Priority**        | Usually higher              | Usually lower                        |
| **Stops JVM?**      | Keeps JVM running           | JVM exits when only daemon threads remain |
| **Use case**        | Main application logic      | Background services                  |
| **Example**         | Main thread, worker threads | GC thread, timer thread              |

---

### ❗ **Important Notes**
- Once a thread is started, its daemon status **cannot be changed**.
- Daemon threads are **not meant** to hold important resources like database connections or files.
- JVM **does not wait** for daemon threads to finish when shutting down.

---

### 🤔 **Real-World Use Cases**
- 🧹 **Garbage Collection Thread** (automatically runs as daemon)
- ⏱️ **Timer threads**
- 🧾 **Logging systems**
- 🔁 **Idle connection monitors in servers**
