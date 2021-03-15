package 剑指offer._06_从尾到头打印链表;

import java.util.ArrayDeque;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        if (head==null)
            return new int[0];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = 0;
        while (head != null) {
            n++;
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = stack.poll();
        }
        return res;
    }
}
