# **Lecture 3: Synchronization & Thread Safety?**

### 🧵 **Why Synchronization?**
When **multiple threads share data**, they might mess with it *at the same time*, leading to:

- 💣 Wrong outputs
- 🐛 Race conditions
- 🤯 Hard-to-find bugs

> Threads are fast, but not polite. Synchronization teaches them manners 😅

---

### 🎯 **Goal Today**:
- Understand **race conditions**
- Learn to use `synchronized` keyword
- See a real-world relatable example

---

## 👨‍🏫 Imagine This:

> Two threads are **booking tickets** at the same time.  
> But only **1 seat is available**! Uh-oh 😨

Let’s build that step by step.

---

### ✅ **Code Example: Without Synchronization (Buggy)**

```java
package all_about_threads.lecture3;

class TicketCounter {
    int tickets = 1;

    public void bookTicket(String name) {
        if (tickets > 0) {
            System.out.println(name + " is booking a ticket...");
            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tickets--;
            System.out.println(name + " successfully booked the ticket!");
        } else {
            System.out.println(name + " tried but ticket is sold out.");
        }
    }
}

class BookingThread extends Thread {
    TicketCounter counter;
    String name;

    BookingThread(TicketCounter counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    public void run() {
        counter.bookTicket(name);
    }
}

public class WithoutSync {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        BookingThread t1 = new BookingThread(counter, "Sarthak");
        BookingThread t2 = new BookingThread(counter, "Naruto");

        t1.start();
        t2.start();
    }
}
```

---

### ❌ **Sample Output (BUG)**

```
Sarthak is booking a ticket...
Naruto is booking a ticket...
Sarthak successfully booked the ticket!
Naruto successfully booked the ticket!
```

🥲 Brooo... how did **both** book 1 ticket?

---

### ✅ **Fix It Using `synchronized`**

```java
public synchronized void bookTicket(String name) {
    // Same body
}
```

OR even better:

```java
public void bookTicket(String name) {
    synchronized (this) {
        if (tickets > 0) {
            System.out.println(name + " is booking a ticket...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tickets--;
            System.out.println(name + " successfully booked the ticket!");
        } else {
            System.out.println(name + " tried but ticket is sold out.");
        }
    }
}
```

---

### ✅ **Fixed Output**

```
Sarthak is booking a ticket...
Sarthak successfully booked the ticket!
Naruto tried but ticket is sold out.
```

💯 Threads now wait their turn. Thread safety achieved. 🛡️

---

### 🎓 Takeaways Till Now:

- 🧠 **Race condition** = multiple threads modifying shared data
- 🔒 Use `synchronized` to protect critical sections
- 🚫 Don’t overuse sync — it slows down performance

---

## 🧵 **Part 2: Synchronized Blocks**

### 🧠 Why not just make the whole method `synchronized`?

Good question! Here's why:
- ✅ You sometimes want to **only lock part of the code** (the critical section).
- ❌ Locking the entire method can be overkill and **reduce performance**.

---

## 🔒 **Syntax of Synchronized Block**

```java
synchronized (lockObject) {
    // Critical section
}
```

You can use:
- `this` → if locking current object (non-static)
- `ClassName.class` → for static context

---

### 💡 Let’s Modify the Ticket Example

Now we’ll use a **synchronized block** instead of synchronizing the whole method.

```java
package all_about_threads.lecture3;

class TicketCounter {
    int tickets = 1;

    public void bookTicket(String name) {
        System.out.println(name + " is trying to book...");

        synchronized (this) {
            if (tickets > 0) {
                System.out.println(name + " is booking a ticket...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tickets--;
                System.out.println(name + " successfully booked the ticket!");
            } else {
                System.out.println(name + " tried but ticket is sold out.");
            }
        }

        System.out.println(name + " has left the counter.\n");
    }
}
```

---

### ✅ Output (Correct & Thread-safe):

```
Sarthak is trying to book...
Naruto is trying to book...
Sarthak is booking a ticket...
Sarthak successfully booked the ticket!
Sarthak has left the counter.

Naruto tried but ticket is sold out.
Naruto has left the counter.
```

---

## 🧠 When to Use What?

| Use `synchronized method` when:         | Use `synchronized block` when:               |
|----------------------------------------|---------------------------------------------|
| Entire method must be locked           | Only part of method needs locking           |
| Simpler syntax is preferred            | Fine-tuning performance is needed           |
| Codebase is small or not performance-critical | Large apps, more concurrency sensitive |

---

## ✅ Summary So Far:

| Concept           | Done ✅ |
|-------------------|--------|
| Threads using `Runnable`  | ✅     |
| `start()` and `join()`     | ✅     |
| Thread interleaving        | ✅     |
| `synchronized` keyword     | ✅     |
| `synchronized` block       | ✅     |

---

## 🧪 Assignment Time


## 🎯 **Assignment 3: Thread Priority Exploration** (Understanding `setPriority()`)

### ✅ **Goal:**
Understand how `Thread.setPriority()` affects execution (spoiler: not always as expected).

---

### 🧩 **Your Task (Assignment 1)**

> ✅ **Create 3 threads**: High, Medium, and Low priority.  
> ✅ Each thread should **print its name 5 times**  
> ✅ Set priorities:
- High → `Thread.MAX_PRIORITY`
- Medium → `Thread.NORM_PRIORITY`
- Low → `Thread.MIN_PRIORITY`

> ✅ Print priority using `Thread.currentThread().getPriority()`

You are free to name threads however you like!

#### 📝 Sample Output Idea (not fixed):
```
[LOW] Running - Priority: 1
[LOW] Running - Priority: 1
...
[HIGH] Running - Priority: 10
...
```

> 👀 Observe if priorities actually affect execution order (and we'll discuss why/why not!)

---

## 🎯 **Assignment 4: Synchronization Race Condition**

### ✅ **Goal:**
Showcase the **difference between synchronized and non-synchronized** code.

---

### 🧩 **Your Task (Assignment 2)**

> ✅ Create a shared **counter = 0**  
> ✅ Two threads will increment the counter 1000 times  
> ✅ Print final value of the counter after both threads complete  
> 👉 Do this **in two versions**:
1. Without `synchronized` → should give wrong result
2. With `synchronized` → correct result

---

### 💡 Expected Results:

- Without sync → something like `counter = 1578` (wrong!)
- With sync → `counter = 2000` (correct!)

---

