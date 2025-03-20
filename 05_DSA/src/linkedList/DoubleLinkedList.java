public class DoubleLinkedList {

    private Node head;
    static class Node{
        int value;
        Node next;
        Node pre;

        public Node(int value) {
            this.value = value;
        }
    }

    //    inserting methods
    public void insertFirst(int val){
        Node node = new Node(val);

        node.next = head;
        node.pre = null;
        if(head != null) head.pre = node;
        head = node;

    }

    public void insertLast(int val){
        Node node = new Node(val);
        Node last = lastNode();

        node.pre = last;
        last.next = node;
        node.next = null;
    }

    public void insertAt(int val, int index){
        Node node = new Node(val);
        Node temp = get(index);

        node.next = temp;
        node.pre= temp.pre;
        temp.pre.next = node;
        temp.pre = node;
    }

//    deleating methods

    public void deleteFirst(){
        int val = head.value;
        if (head == null){
            head = null;
            return;
        }
        head = head.next;
    }

    public void deleteLast(){
        Node secondLast = get(size()-2);
        secondLast.next = null;
    }

    public void delete(int index){
        if (index == 0){
            deleteFirst();
            return;
        } else if (index == size()) {
            deleteLast();
            return;
        }

        Node temp = get(index);
        temp.pre.next = temp.next;
        temp.next.pre = temp.next;
    }

    public void display(){
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
            System.out.println("End");
    }

    public void displayReverse(){
        Node temp = lastNode();

        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.pre;
        }

        System.out.println("End");
    }

    public int size(){
        DoubleLinkedList.Node temp = head;
        int count = 0;

        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public Node lastNode(){
        Node last = head;

        while(last.next != null) {
            last = last.next;
        }
        return last;
    }

    public Node get(int index){
        Node temp = head;
        int count =0;

        while(count < index){
            temp = temp.next;
            count++;
        }

        return temp;
    }
}
