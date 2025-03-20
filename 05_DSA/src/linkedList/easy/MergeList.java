package easy;

// * leatcode 83 soluton only
//! make sure to run it in leatcode
// * link: https://leetcode.com/problems/merge-two-sorted-lists/description/

public class MergeList {
    public static void main(String[] args) {

    }

//        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//            if (list1 == null) {
//                return list2;
//            } else if (list2 == null) {
//                return list1;
//            }
//
//            ListNode result = new ListNode();
//            ListNode ans = result;
//
//            while (list1 != null && list2 != null) {
//                if (list1.val > list2.val) {
//                    ans.next = list2;
//                    list2 = list2.next;
//                } else {
//                    ans.next = list1;
//                    list1 = list1.next;
//                }
//                ans = ans.next;
//            }
//            ans.next = (list1 != null) ? list1 : list2;
//            return result.next;
//        }

}
