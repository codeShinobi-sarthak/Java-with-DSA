public class RotateList {
    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int length = 1;

        while(temp.next != null){
            temp = temp.next;
            length++;
        }

        temp.next = head;
        int rotate = length;

        while(rotate > 0){
            temp = temp.next;
            head = head.next;
            rotate--;
        }
        temp.next = null;
        return head;
    }

}
