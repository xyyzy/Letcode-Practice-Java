package 最热100题._19_删除链表倒数第N个节点;


/**
 * 双指针 pre比after超前n个节点
 * */
public class Solution2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode after = dummy;
        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }
        while (pre != null) {
            pre = pre.next;
            after = after.next;
        }
        after.next = after.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
