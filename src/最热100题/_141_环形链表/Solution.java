package 最热100题._141_环形链表;

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next!=null) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast.val == slow.val) {
                return true;
            }
        }
        return false;
    }
}
