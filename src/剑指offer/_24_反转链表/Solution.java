package 剑指offer._24_反转链表;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        //先写递归出口
        if (head==null||head.next==null)
            return head;

        //递归逻辑，只写每次递归里该干什么
        //1.将当前节点的写个节点的next指向当前节点
        //2.将当前节点的next指向null
        ListNode res = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }



}
