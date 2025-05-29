package all_about_threads.assignments;

class Counter {
    int count = 0;

    //    with sync
    public synchronized void increment() {
        count++;
    }

//     without sync
//    public void increment() {
//        count++;
//    }
}

public class assignment4 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count (without sync): " + counter.count);
        System.out.println("Final Count (with sync): " + counter.count);
    }
}
