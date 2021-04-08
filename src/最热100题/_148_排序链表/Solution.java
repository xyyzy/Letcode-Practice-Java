package 最热100题._148_排序链表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

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

    //利用优先级队列 小根堆
    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        //new PriorityQueue<>() 自动会对加入的元素进行排序，默认为小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode p = head;
        while (p != null) {
            pq.offer(p.val);
            p = p.next;
        }
        ListNode q = new ListNode(0);
        ListNode resHead = q;
        while (pq.size() > 0) {
            q.val = pq.poll();
            if (pq.size() > 0) {
                ListNode temp = new ListNode(0);
                q.next = temp;
            }
            q = q.next;
        }
        return resHead;
    }

    //归并排序
    public ListNode sortList1(ListNode head) {
        if (head == null)
            return null;
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        //快慢指针找到中点
        ListNode fast = head;
        ListNode slow = head;
        //找到重点
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = mergeSort(slow.next);
        //断开
        slow.next = null;
        ListNode left = mergeSort(head);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        //哑节点
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        //合并
        while (left != null && right != null) {
            if (left.val <= right.val) {
                p.next = left;
                left = left.next;
            }else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        //有一方多余的情况
        if (left!=null) p.next = left;
        if (right!=null) p.next = right;
        return dummyHead.next;
    }

}
