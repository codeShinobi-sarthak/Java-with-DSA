package all_about_threads.assignments;

//! this is to dee deadlock in action
//class ResourceA {
//    synchronized void methodA(ResourceB b) {
//        System.out.println("Thread 1: Locked ResourceA, waiting for ResourceB...");
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
//        b.last();
//    }
//
//    synchronized void last() {
//        System.out.println("Thread 1: Inside ResourceA.last()");
//    }
//}
//
//class ResourceB {
//    synchronized void methodA(ResourceA a) {
//        System.out.println("Thread 2: Locked ResourceB, waiting for ResourceA...");
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
//        a.last();
//    }
//
//    synchronized void last() {
//        System.out.println("Thread 2: Inside ResourceB.last()");
//    }
//}


class FixedResource {
    private final Object lockA = new Object();
    private final Object lockB = new Object();

    public void thread1Task() {
        synchronized (lockA) {
            System.out.println("Thread 1: Locked lockA");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            synchronized (lockB) {
                System.out.println("Thread 1: Locked lockB");
                System.out.println("Thread 1: Performing task");
            }
        }
    }

    public void thread2Task() {
        synchronized (lockA) { // same order!
            System.out.println("Thread 2: Locked lockA");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            synchronized (lockB) {
                System.out.println("Thread 2: Locked lockB");
                System.out.println("Thread 2: Performing task");
            }
        }
    }
}



public class assignment5 {
    public static void main(String[] args) {
        FixedResource resource = new FixedResource();

        Thread t1 = new Thread(() -> resource.thread1Task());
        Thread t2 = new Thread(() -> resource.thread2Task());

        t1.start();
        t2.start();

    }
}
