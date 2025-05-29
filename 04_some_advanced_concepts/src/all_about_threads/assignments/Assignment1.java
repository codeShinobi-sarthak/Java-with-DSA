package all_about_threads.assignments;

class Thread_1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("count " + i + " in thread_1");
            System.out.println("current thread name : " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Thread_2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("count " + i + " in thread_2");
            System.out.println("current thread name : " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Assignment1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread_1());
        Thread t2 = new Thread(new Thread_2());

        t1.start();
        t2.start();

    }
}
