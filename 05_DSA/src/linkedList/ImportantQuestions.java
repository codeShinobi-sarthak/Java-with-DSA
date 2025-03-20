public class ImportantQuestions {

    // *https://leetcode.com/problems/linked-list-cycle
    // Amazon and Microsoft
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //    find length of cycle
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = slow.next;
                while (slow != fast) {
                    slow = slow.next;
                    count++;
                }
                break;
            }
        }
        return count + 1;
    }

    // https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast == null || fast.next == null)
            return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }


    // *Google: https://leetcode.com/problems/happy-number/
    private int square(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans += rem * rem;
            n /= 10;
        }
        return ans;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = square(slow);
            fast = square(square(fast));
            if (slow == fast) return false;
        } while (slow != 1);
        return true;
    }

    //    *https://leetcode.com/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
    }
}
