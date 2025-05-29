### 🔖 **Assignment 5 Recap: Deadlock Simulation**

> **Task:**  
Create a **deadlock scenario** like the one in the lecture (two threads waiting on each other’s lock).  
✅ Extend `A` and `B` classes with **extra methods if needed**.  
✅ Then, **break the deadlock** using:
- **Lock ordering**, or
- **Timeouts**

---

### 💀 Let's Simulate the Deadlock (Step 1)

#### ✅ Step-by-step Deadlock Demo — Setup:

```java
class A {
    synchronized void methodA(B b) {
        System.out.println(Thread.currentThread().getName() + ": Locked A, trying to lock B");
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        b.last();  // Needs lock on B
    }

    synchronized void last() {
        System.out.println(Thread.currentThread().getName() + ": Inside A.last()");
    }
}

class B {
    synchronized void methodB(A a) {
        System.out.println(Thread.currentThread().getName() + ": Locked B, trying to lock A");
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        a.last();  // Needs lock on A
    }

    synchronized void last() {
        System.out.println(Thread.currentThread().getName() + ": Inside B.last()");
    }
}

public class DeadlockAssignment {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        Thread t1 = new Thread(() -> a.methodA(b), "Thread-1");
        Thread t2 = new Thread(() -> b.methodB(a), "Thread-2");

        t1.start();
        t2.start();
    }
}
```

---

### 🔁 **What This Does (In Your Words):**

- **Thread-1** locks A 🔐, then tries to lock B 🛑
- **Thread-2** locks B 🔐, then tries to lock A 🛑
- 💥 Deadlock! Neither thread can move.

---

### 🛠️ Step 2: **Fixing the Deadlock**

Let’s **break** this trap using:

---

## ✳️ OPTION 1: Lock Ordering 💡

> Always acquire locks in the **same order** to prevent circular wait.

We create a helper method that **always locks A first, then B** (no matter which thread calls it):

```java
class Locker {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void doSafeWork() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + ": Locked lock1");
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + ": Locked lock2");
                System.out.println(Thread.currentThread().getName() + ": Doing safe work...");
            }
        }
    }
}

public class LockOrderingDemo {
    public static void main(String[] args) {
        Locker locker = new Locker();

        Runnable task = () -> locker.doSafeWork();

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
```

👉 Both threads **follow the same order** → 💥 No deadlock 🎉

---

## ⏳ OPTION 2: Timeout with `tryLock()` (ReentrantLock)

> Give up if lock can't be acquired in a certain time 😌

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

class SafeTask implements Runnable {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void run() {
        try {
            if (lock1.tryLock(100, TimeUnit.MILLISECONDS)) {
                System.out.println(Thread.currentThread().getName() + ": Got lock1");
                Thread.sleep(50);
                if (lock2.tryLock(100, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + ": Got lock2");
                    System.out.println(Thread.currentThread().getName() + ": Doing work");
                    lock2.unlock();
                } else {
                    System.out.println(Thread.currentThread().getName() + ": Couldn't get lock2");
                }
                lock1.unlock();
            } else {
                System.out.println(Thread.currentThread().getName() + ": Couldn't get lock1");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TryLockDemo {
    public static void main(String[] args) {
        SafeTask task = new SafeTask();

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
```

🛡️ **Deadlock avoided**, because if one lock can’t be acquired → thread backs off.

---

### ✅ Summary of Assignment 5

| Step                  | What's Happening |
|-----------------------|------------------|
| 1️⃣ Create Deadlock     | Two threads lock A & B, then wait on each other |
| 2️⃣ Fix via Ordering   | Always lock in same order → no circular wait |
| 3️⃣ Fix via `tryLock`  | Add timeouts → no infinite waiting |

---