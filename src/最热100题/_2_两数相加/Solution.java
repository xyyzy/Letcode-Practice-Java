package 最热100题._2_两数相加;

class ListNode {
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

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //flag
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        int sum = 0;
        while (p1 != null || p2 != null) {
            sum = sum / 10;
            if (p1 != null) {
                //加上p1的值,指针后移
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                //加上p1的值,指针后移
                sum += p2.val;
                p2 = p2.next;
            }
            res.next = new ListNode(sum % 10);
            res = res.next;

        }
        if (sum/10==1){
            res.next = new ListNode(1);
        }
        return temp.next;
    }
}
