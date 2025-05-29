# 🎓 Lecture 5 Roadmap: Mastering Advanced Concurrency


### ✅ 1. **ReentrantLock vs Synchronized**

**🔹 Synchronized**
- It's the classic way to control access to critical sections.
- Simple to use: just add `synchronized` to a method or block.
- But lacks advanced features like timed locks or interruptible waits.

**🔹 ReentrantLock**
- Think of it as a more powerful version of `synchronized`.
- You manually `lock()` and `unlock()` the section.
- Has cool features:
    - `tryLock()` – attempts to get lock without blocking.
    - `lockInterruptibly()` – allows you to cancel waiting for a lock.
    - You can even try getting the lock for a certain time.

🧠 **Why care?**  
More control = better performance and safety in complex apps.

```java
import java.util.concurrent.locks.ReentrantLock;

class Shared {
    ReentrantLock lock = new ReentrantLock();

    void printData() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " got the lock");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockDemo {
    public static void main(String[] args) {
        Shared obj = new Shared();

        Runnable task = () -> obj.printData();

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
```

---

### ✅ 2. **Volatile Keyword**

**What it does:**  
When one thread changes a `volatile` variable, all other threads immediately see the updated value.

🧠 Without `volatile`, a thread might keep using a *cached* value and not see updates from other threads.

📌 Use it when:
- Multiple threads **read/write a flag or signal**.
- You **don’t need locking** but just need visibility.

```java
class VolatileExample extends Thread {
    private static volatile boolean flag = true;

    public void run() {
        while (flag) {
        }
        System.out.println("Thread Stopped");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample t = new VolatileExample();
        t.start();
        Thread.sleep(1000);
        flag = false;
    }
}
```

🧪 Try removing `volatile` and the thread might never stop!

---

### ✅ 3. **Atomic Variables**

- Classes like `AtomicInteger`, `AtomicLong`, etc.
- Provide **atomic operations** like incrementing, without locks.
- Internally uses **compare-and-swap (CAS)**, which is fast!

📌 Use it instead of:
```java
synchronized {
  count++;
}
```

Just do:
```java
count.incrementAndGet();
```

✅ Great for counters, ID generation, stats, etc.

```java
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                count.incrementAndGet();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final Count: " + count.get());
    }
}
```

---

### ✅ 4. **ThreadLocal**

Each thread gets its own **independent copy** of a variable.

📦 Use cases:
- User sessions
- Logging trace IDs
- Caching small things per thread

🧠 Why it rocks?  
No need to synchronize — **data is not shared!**

```java
public class ThreadLocalExample {
    static ThreadLocal<Integer> userId = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = () -> {
            userId.set((int)(Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + " has userId: " + userId.get());
        };

        new Thread(task, "User-1").start();
        new Thread(task, "User-2").start();
    }
}
```

---

### ✅ 5. **Concurrent Collections**

Traditional collections (`HashMap`, `ArrayList`, etc.) are **not thread-safe**.

💣 If you modify them from multiple threads: expect crashes or corrupted data.

🔐 Use these instead:
- `ConcurrentHashMap`
- `CopyOnWriteArrayList`
- `ConcurrentLinkedQueue`

They handle synchronization **internally**, so no need for you to worry!

```java
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapDemo {
    static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            map.put(Thread.currentThread().getName(), (int)(Math.random()*100));
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Map contents: " + map);
    }
}
```


---
## 🎒 Assignments (Post-Lecture Practice)

### 📌 Assignment : `ReentrantLock Bank System`
- Create a `BankAccount` class
- Use `ReentrantLock` for `deposit()` and `withdraw()`
- Start multiple threads trying to access these methods

### 📌 Assignment : `ThreadLocal User Tracker`
- Simulate a login system where each thread simulates a user login
- Store and print user IDs using `ThreadLocal`
