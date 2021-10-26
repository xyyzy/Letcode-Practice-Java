package 面试.明略科技;

import 最热100题._206_反转链表.Solution;

public class B {
    public class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     * @param head ListNode类 the head
     * @param l    int整型 left
     * @param r    int整型 right
     * @return ListNode类
     */
    public ListNode reversePartLinkedlist(ListNode head, int l, int r) {
        // write code here
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 1; i < l; i++) {
            cur = cur.next;
        }
        //指向前一个节点
        ListNode pre = cur;
        //第l个节点
        ListNode node = cur.next;
        //要反转的范围
        for (int i = l; i <r ; i++) {
            ListNode nextNode = node.next;
            node.next = nextNode.next;
            nextNode.next = cur.next;
            cur.next = nextNode;

        }
        return dummy.next;
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
}
