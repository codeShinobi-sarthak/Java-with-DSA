## 🎓 **Lecture 1: Introduction to Threads in Java**

### 🧭 Objective of this lecture:
- Understand **what threads are**
- Learn **how to create threads**
- See **how Java executes threads**
- Practice with **a basic thread example**

---

### 🧠 Imagine this:

You’re at a restaurant.  
You place your order, but the chef is also the waiter — he takes the order, goes back to the kitchen, cooks it, brings it, and only then takes the next order.

**This is Single-threaded Execution** — tasks are done one after another.

Now, what if there are multiple chefs and waiters, all working at the same time?

**That’s Multi-threading!** Multiple tasks at once. Efficient. Faster.

---

### 📌 What is a Thread?

> A **thread** is a unit of execution within a program.  
> A **process** can have multiple threads.

In Java, the **main()** method itself runs on a thread — called the **main thread**.

---

### ✨ Why use Threads?

- Do multiple things **simultaneously** (like downloading files while the UI remains responsive).
- Handle **long-running tasks** without freezing the app.
- Build **efficient** and **scalable** programs.

---

## ✍️ Let’s Create Our First Thread

### ✅ **Method 1: Extending the `Thread` class**

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running 🚀");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // 👈 starts a new thread
    }
}
```

👨‍🏫 Explanation:
- `run()` → holds the task.
- `start()` → asks the JVM to create a new thread and call `run()` internally.

> ❌ **Don't call `run()` directly!** It won’t create a new thread — it will just run like a normal method.

---

### ✅ **Method 2: Implementing `Runnable` interface**

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread running 🎯");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}
```

👨‍🏫 Why is this better?
Because Java supports **single inheritance**.  
If your class already extends another class, you can’t extend `Thread`, but you can still implement `Runnable`.

---

### 🎥 Live Example: See It in Action

Let’s make a thread print numbers:

```java
class NumberPrinter extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " from " + Thread.currentThread().getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        NumberPrinter t1 = new NumberPrinter();
        t1.start();

        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}
```

🧪 Output will show both threads running!

---

## ✅ Mini Recap

| Concept | What it Means |
|--------|----------------|
| `Thread` | Class to define threads |
| `Runnable` | Interface to define threads |
| `run()` | Code to execute in thread |
| `start()` | Begins execution of thread |

---

## 🧑‍🏫 Assignment for You:

**Try this**:  
Create two threads using `Runnable`, and make each one print its name and count from 1 to 5 with a delay of 1 second using `Thread.sleep(1000)`.

---

## 👉 Coming up in Lecture 2:
- Thread Lifecycle 🎡
- Sleep, Join, and Yield
- Naming threads and setting priority