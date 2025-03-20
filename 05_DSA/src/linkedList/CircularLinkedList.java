public class CircularLinkedList {
    private Node head;
    private Node tail;
    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);

        if (head == null){
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        tail.next = node;
        head = node;
    }

    public void insertLast(int val){
        Node node = new Node(val);

        node.next = head;
        tail.next = node;
        tail = node;
    }

    public void insertAt(int val, int index){
        Node node = new Node(val);
        Node temp = get(index);

        node.next = temp.next;
        temp.next = node;
    }

//    deleating methods

    public void deleteFirst(){
        int val = head.value;
        if (head == null){
            return;
        }
        tail.next = head.next;
        head = head.next;
    }

    public void deleteLast(){
        Node secondLast = get(size()-2);

        secondLast.next = head;
        tail = secondLast;
    }

    public void delete(int index){
        if (index == 0){
            deleteFirst();
            return;
        } else if (index == size()) {
            deleteLast();
            return;
        }
        Node temp = get(index-1);
        temp.next = temp.next.next;
}

    public void display(){
        Node temp = head;

        if (head != null){
            do{
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }while(temp != head);
        }
    }


    public int size(){
        Node temp = head;
        int count = 0;

        while (temp.next != head){
            count++;
            temp = temp.next;
        }
        count++;
        return count;
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
