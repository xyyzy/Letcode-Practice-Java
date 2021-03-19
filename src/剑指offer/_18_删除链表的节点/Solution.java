package 剑指offer._18_删除链表的节点;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode res = new ListNode(0);
        if (head==null)
            return null;
        res.next = head;
        ListNode first = res;
        ListNode second = res.next;
        while (second != null) {
            if (second.val == val) {
                first.next = second.next;
                second.next = null;
            }
            second = second.next;
            first = first.next;
        }
        return res.next;
    }
}
