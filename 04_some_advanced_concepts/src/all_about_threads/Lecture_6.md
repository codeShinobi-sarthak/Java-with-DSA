## 🧠 **Executor Framework in Java** — Overview

The **Executor Framework** in Java is a more **advanced and flexible way** to manage threads compared to directly creating and managing threads with `Thread` and `Runnable`. It provides an abstraction for handling thread pools and tasks, which makes it easier to work with concurrent programs.

### Why Use the Executor Framework?
- **Efficiency**: It allows you to reuse existing threads instead of creating new ones every time you need to execute a task.
- **Scalability**: You can manage a pool of threads for executing tasks, which can scale better with increased workload.
- **Ease of Use**: Simplifies the management of multiple threads by providing higher-level interfaces.

---

### 🚀 **Key Components of the Executor Framework**:

1. **Executor Interface**:
    - The base interface for all executor services. It provides the `execute()` method to run a task asynchronously.

2. **ExecutorService Interface**:
    - Extends `Executor` and adds methods for managing the lifecycle of the executor, such as `shutdown()`, `submit()`, etc.

3. **ThreadPoolExecutor**:
    - A commonly used implementation of `ExecutorService` that uses a pool of threads to execute tasks.

4. **ScheduledExecutorService**:
    - Extends `ExecutorService` and allows for tasks to be scheduled with a fixed-rate or fixed-delay execution policy (great for recurring tasks).

5. **Future**:
    - Represents the result of an asynchronous computation. It provides methods to check if the task is complete and retrieve its result.

---

### ⚡ **Example Using `ExecutorService`**

Let's start by using the `ExecutorService` to manage a pool of threads. We'll use a simple example where multiple tasks are submitted to an executor for execution.

```java
package all_about_threads.assignments;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Runnable {
    private final String taskName;
    
    public MyTask(String taskName) {
        this.taskName = taskName;
    }
    
    @Override
    public void run() {
        System.out.println(taskName + " is running in thread: " + Thread.currentThread().getName());
    }
}

public class Assignment5_ExecutorFramework {
    public static void main(String[] args) {
        // Create a thread pool of 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        // Submit tasks to the executor
        executorService.submit(new MyTask("Task 1"));
        executorService.submit(new MyTask("Task 2"));
        executorService.submit(new MyTask("Task 3"));
        executorService.submit(new MyTask("Task 4"));
        executorService.submit(new MyTask("Task 5"));

        // Shut down the executor once all tasks are completed
        executorService.shutdown();
    }
}
```

### 🧪 **Expected Output:**

```
Task 1 is running in thread: pool-1-thread-1
Task 2 is running in thread: pool-1-thread-2
Task 3 is running in thread: pool-1-thread-3
Task 4 is running in thread: pool-1-thread-1
Task 5 is running in thread: pool-1-thread-2
```

### 🧠 **Explanation:**

1. **ExecutorService** is created with a fixed thread pool of 3 threads using `Executors.newFixedThreadPool(3)`.
2. **Tasks are submitted**: `submit()` method submits tasks to the executor.
3. The **executor assigns tasks** to the available threads in the pool.
4. Once all tasks are completed, we call `shutdown()` to gracefully shut down the executor.

---

### 🧪 **Next Exercise for You: (optional)**

Modify the above code:
- **Submit at least 5 tasks** but ensure that **only 3 tasks run concurrently**.
- **Observe and print the task completion** (e.g., print something when a task finishes).
- **Use `submit()` and store the `Future` objects** to monitor the completion status of tasks (e.g., check if tasks are completed).

---