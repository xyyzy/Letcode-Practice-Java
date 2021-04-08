package 最热100题._142_环形链表II;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    /**
     * 快慢指针
     * */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;

        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            low = low.next;
            //第一次相遇
            if (fast == low) {
                break;
            }
        }
        fast = head;
        while (fast!=low){
           fast = fast.next;
           low = low.next;
        }
        return fast;
    }

    /**
     * hash表 一个node遇到两次就是环形表入口点
     * */
    public ListNode detectCycle1(ListNode head) {
        ListNode pos =head;
        HashSet<ListNode> set = new HashSet<>();
        while (pos!=null){
            if (set.contains(pos)){
                return pos;
            }else {
                set.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
