package 最热100题._25_K个一翻转链表;

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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        //假节点的next指向head。
        // dummy->1->2->3->4->5
        dummy.next = head;
        //初始化pre和end都指向dummy。pre指每次要翻转的链表的头结点的上一个节点。end指每次要翻转的链表的尾节点
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
            if (end == null) {
                break;
            }
            //记录未翻转区的第一个节点, 方便断开后链接
            ListNode next = end.next;
            //先断开链接
            end.next = null;
            ListNode start = pre.next;
            //反转[start...end]之间的链表
            pre.next = resver(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    /**
     * 翻转链表
     * */
    private ListNode resver(ListNode start) {
        if (start == null || start.next == null) {
            return start;
        }
        //最终返回的res为最后一个节点
        ListNode res = resver(start.next);
        start.next.next = start;
        start.next = res.next;
        return res;
    }

}
