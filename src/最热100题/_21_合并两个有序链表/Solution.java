package 最热100题._21_合并两个有序链表;

import java.util.List;

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
     * 迭代
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dumy = res;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                dumy.next = l2;
                l2 = l2.next;
            } else {
                dumy.next = l1;
                l1 = l1.next;
            }
            dumy = dumy.next;
        }
        if (l1 == null) {
            dumy.next = l2;
        }
        if (l2 == null) {
            dumy.next = l1;
        }
        return res.next;

    }

    /*
     * 递归
     * */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
