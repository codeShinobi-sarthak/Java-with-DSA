/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//public class SplitLinkedListInParts {
//    public static void main(String[] args) {
//
//    }
//
//    public ListNode[] splitListToParts(ListNode head, int k) {
//        // Calculate the total length of the linked list
//        int length = 0;
//        ListNode temp = head;
//        while (temp != null) {
//            length++;
//            temp = temp.next;
//        }
//
//        // Determine the size of each part and the number of parts that will be larger
//        int partSize = length / k; // Base size of each part
//        int extraParts = length % k; // Number of parts that need to be one node larger
//
//        // Array to hold the parts
//        ListNode[] parts = new ListNode[k];
//        ListNode current = head;
//
//        for (int i = 0; i < k; i++) {
//            // Head of the current part
//            ListNode partHead = current;
//            // Determine the size of the current part
//            int currentPartSize = partSize + (i < extraParts ? 1 : 0);
//
//            // Traverse to the end of the current part
//            for (int j = 1; j < currentPartSize; j++) {
//                if (current != null) {
//                    current = current.next;
//                }
//            }
//
//            // Split the list
//            if (current != null) {
//                ListNode nextPartHead = current.next;
//                current.next = null; // End the current part
//                current = nextPartHead; // Move to the start of the next part
//            }
//
//            // Store the head of the current part
//            parts[i] = partHead;
//        }
//
//        return parts;
//    }
//}
