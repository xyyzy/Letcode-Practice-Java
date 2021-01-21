package 达西面试题.两数相加;

/**
 * 给定两个⾮空链表， 分别表⽰两个⾮负整数。 整数的每⼀位数字逆序保存在链表
 * 的每⼀个结 点中。 请将这两个⾮负整数相加， 结果以链表形式返回。
 */
     /*ListNode p1 = new ListNode(0);
            ListNode p2 = new ListNode(0);
            int sum = 0;
            int num1 = 0; //l1中的值
            int num2 = 0; //l2中的值
            p1 = l1; //遍历l1
            p2 = l2; //遍历l2
            int n = 0;
            int m = 0;
            while (p1 != null) {
                n++;
                p1 = p1.next;
            }
            while (p2 != null) {
                m++;
                p2 = p2.next;
            }
            //回到头
            p1 = l1;
            p2 = l2;
            for (int i = 0; i < n; i++) {
                num1 = (int) (p1.val * Math.pow(10, i)) + num1;
            }
            for (int i = 0; i < m; i++) {
                num2 = (int) ((p2.val * Math.pow(10, i)) + num2);
            }
            sum =num1+num2;*/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;

    }

    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode temp = new ListNode(0);
            ListNode rs = temp;
            int sum = 0;
            while (p1 != null || p2 != null) {
                sum = sum / 10;
                if (p1 != null) {
                    sum += p1.val;
                    p1 = p1.next;
                }
                if (p2 != null) {
                    sum += p2.val;
                    p2 = p2.next;
                }
                rs.next = new ListNode(sum % 10);
                rs = rs.next;
            }
            if (sum / 10 == 1) {
                rs.next = new ListNode(1);
            }
            return temp.next;
        }
    }


}
