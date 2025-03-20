package linkedList;
//Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
// leaving only distinct numbers from the original list.
// Return the linked list sorted as wel

// ! Definition for singly-linked list.
/*
 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
*/


public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {

    }

/*    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null; // Edge case: empty list

        ListNode dummy = new ListNode(0, head); // Dummy node before head
        ListNode prev = dummy; // Pointer to track last distinct node

        while (head != null) {
            // If head has duplicates, skip them
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next; // Skip all duplicates
                }
                prev.next = head.next; // Remove duplicates
            } else {
                prev = prev.next; // Move prev forward
            }
            head = head.next; // Move head forward
        }

        return dummy.next; // Return the modified list
    }*/



}

