//
//import java.util.ArrayDeque;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Main {
//    public static void main(String[] args) {
//// * collection frameword implementation
////        Queue<Integer> q = new LinkedList<>();
//        Queue<Integer> q = new ArrayDeque<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        q.add(6);
//
//        while (!q.isEmpty()){
//            System.out.print(q.peek() + " -> ");
//            q.remove();
//        }
//        System.out.println("END");
//
////// *        Normal queue using array
////        ArrayQueue queue = new ArrayQueue(10);
////
////        queue.enQueue(23);
////        queue.enQueue(2);
////        queue.enQueue(3);
////        queue.enQueue(13);
////        queue.enQueue(63);
////        queue.enQueue(19);
////
////        queue.display();
////
////        System.out.println(queue.deQueue());
////
////        queue.display();
//
//
////// *        circular queue
////        CircularQueue queue = new CircularQueue(5);
////
////        queue.enQueue(23);
////        queue.enQueue(2);
////        queue.enQueue(3);
////        queue.enQueue(13);
////        queue.enQueue(63);
////
////        queue.display();
////
////        System.out.println(queue.deQueue());
////
////        queue.enQueue(19);
////        queue.display();
//
//
////// *     List queue
////        LLQueue queue = new LLQueue();
////
////        queue.enQueue(23);
////        queue.enQueue(2);
////        queue.enQueue(3);
////        queue.enQueue(13);
////        queue.enQueue(63);
////
////        queue.display();
////
////        System.out.println(queue.deQueue());
//////
////        queue.enQueue(19);
////        queue.display();
//
////// *     array dequeue
////        ArrayDequeue queue = new ArrayDequeue(10);
////
////        queue.appendRear(23);
////        queue.appendRear(2);
////        queue.appendRear(11);
////        queue.appendFront(1);
////        queue.appendFront(2);
////        System.out.println(queue.popRear());
////
////        queue.display();
//    }
//}