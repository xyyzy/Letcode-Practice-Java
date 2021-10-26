package 最热100题._206_反转链表;

/**
 * 题解链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
 */
public class Solution {
    public class ListNode {
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

    /**
     * 迭代版本
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /*
     * 递归版本
     * https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
     * */
    public ListNode reverseList2(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        //最终返回的res为最后一个节点
//        ListNode res = reverseList2(head.next);
//        head.next.next = head;
//        head.next = null;
//        return res;
        if (head == null || head.next == null)
            return head;
        //最终返回的res为最后一个节点
        ListNode res = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return res;

    }
}
