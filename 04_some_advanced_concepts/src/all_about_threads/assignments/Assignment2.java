package all_about_threads.assignments;

class Ping implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("ping " + i);
            System.out.println("current thread name : " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Pong implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("pong " + i);
            System.out.println("current thread name : " + Thread.currentThread().getName());
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Assignment2 {
    public static void main(String[] args) throws InterruptedException {
        Thread ping = new Thread(new Ping(), "Ping");
        Thread pong = new Thread(new Pong(), "Pong");


        ping.start();
        pong.start();

        ping.join();
        pong.join();


//?        just discovering
//?      well 🔁 That’s not true multithreading — just single-threaded   behavior in disguise 🕵️
//        ping.start();
//        ping.join();
//
//        pong.start();
//        pong.join();

        System.out.println("This will print after both the Threads are Finished");
    }
}
