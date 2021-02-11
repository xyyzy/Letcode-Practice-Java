package 最热100题._23_合并K个链表;

import java.util.ArrayList;
import java.util.Comparator;

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
     * 将两个链表合并成一个数组 排序之后
     * 在重新创建链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                temp.add(list.val);
                list = list.next;
            }
        }
        temp.sort(Comparator.comparingInt(o -> o));
        ListNode res = new ListNode(0);
        ListNode pre = res;
        for (int i = 0; i < temp.size(); i++) {
            ListNode node = new ListNode(temp.get(i));
            pre.next = node;
            pre = pre.next;
        }
        return res.next;
    }

    /*
     * 顺序合并，维护一个ans 遍历list 将ans和第i个链表合并保存到ans
     * */
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists1(ans, lists[i]);
        }
        return ans;
    }

    private ListNode mergeTwoLists1(ListNode ans, ListNode list) {
        if (ans == null || list == null) {
            return ans != null ? ans : list;
        }
        ListNode head = new ListNode(0);
        ListNode pre = head;
        ListNode apre = ans;
        ListNode lpre = list;
        while (apre != null && lpre != null) {
            if (apre.val < lpre.val) {
                pre.next = apre;
                apre = apre.next;
            } else {
                pre.next = lpre;
                lpre = lpre.next;
            }
            pre = pre.next;
        }
        pre.next = (apre != null ? apre : lpre);
        return head.next;
    }

    /*
    * 分治合并
    * 采用归并排序的思想
    *
    * */
    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        //二分
        int mid = (l + r) >> 1;
        return mergeTwoLists2(merge(lists, l, mid), merge(lists, mid + 1, r));
    }
    public ListNode mergeTwoLists2(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}
