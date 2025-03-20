import org.w3c.dom.Node;

public class SinglyLinkedList{

    private Node head;
    //    private Node tail;
    private int size = 0;

    // * node class
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

////  constructor for SingleLinkedList class
//    public SinglyLinkedList() {
//        this.size = 0;
//    }

    // *    insertion methods
    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (head == null) {
            head = head;
        }
        size++;
    }

    public void insertEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node = last;
        size++;
    }

    public void insert(int value, int index) {
        Node node = new Node(55);

        if (index == size()) {
            insertEnd(value);
            return;
        }

        Node temp = head;
        int count = 1;
        while (count < index) {
            temp = temp.next;
            count++;
        }

        node.next = temp.next;
        temp.next = node;
        size++;
    }

    //  * insert using recursion
    public void insertRec(int value, int index) {
        insertRec(value, index, head);
    }

    private void insertRec(int value, int index, Node temp) {
        if (index == 1) {
            Node node = new Node(value);
            node.next = temp.next;
            temp.next = node;
            return;
        }
        insertRec(value, index - 1, temp.next);
    }

    //  *  delete methods
    public void deleteFirst() {
        int val = head.value;
        if (head == null) {
            head = null;
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteLast() {
//        Node temp = head;
//        int count = 1;
//        while(count < size()-1){
//            temp = temp.next;
//            count++;
//        }
//        temp.next = null;

        Node secondLast = get(size() - 2);
        secondLast.next = null;
        size--;
    }

    public void delete(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        } else if (index == size()) {
            deleteLast();
            return;
        }

        Node pre = get(index - 1);
        pre.next = get(index + 1);
        size--;
    }

    //    * display linked list
    public void displayList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    //    * get size of linked list
    public int size() {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    //    * get a particular node
    public Node get(int index) {
        Node temp = head;
        int count = 1;
        while (count <= index) {
            temp = temp.next;
            count++;
        }
        return temp;
    }

//   * get middle of list

    public Node middleNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
//        System.out.println(slow.value);
        return slow;
    }

    //  * bubble sort by swapping values
    public Node bubbleSortValue() {
        boolean swapped = true;

        do {
            swapped = false;
            Node current = head;

            while (current.next != null) {
                if (current.value > current.next.value) {
                    // Swap value (conceptual, actual swapping requires node manipulation)
                    int temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        return head;
    }

    //  * bubble sort by changing nodes
    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.value > second.value) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }

    //  * reverse linked list
    public void reverseList() {
        reverseList(head);
    }

    protected Node reverseList(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    //    * palindrome check
    public boolean isPalindrome() {
        Node temp = head;
        Node newHead = middleNode();
        Node revNewHead = reverseList(newHead);

        while (revNewHead.next != null) {
            if (temp.value != revNewHead.value) return false;

            temp = temp.next;
            revNewHead = revNewHead.next;
        }
        return true;
    }
}
