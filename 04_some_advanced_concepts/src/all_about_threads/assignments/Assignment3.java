package all_about_threads.assignments;


//! ⚠️ Important Note
/*
Thread priorities are just hints to the JVM and OS — they’re not guaranteed to run in that order.

🔍 Why?
- JVM may ignore priorities, especially on OS like Windows.
-Thread scheduling is handled by the underlying OS, not just Java.

So, even though High has the max priority — it doesn’t always run first or more often.
*/


class Low implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority());

        }
    }
}

class Medium implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority());

        }
    }
}

class High implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority());

        }
    }
}

public class Assignment3 {
    public static void main(String[] args) {
        Thread low = new Thread(new Low(), "Low");
        Thread medium = new Thread(new Medium(), "Medium");
        Thread high = new Thread(new High(), "High");

        high.setPriority(Thread.MAX_PRIORITY);
        medium.setPriority(Thread.NORM_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);

        low.start();
        high.start();
        medium.start();

    }
}
