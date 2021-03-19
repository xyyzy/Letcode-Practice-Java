package 剑指offer._14_剪绳子II;

public class Solution {
    /*
    * 贪心：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/jian-zhi-offer-14-ii-jian-sheng-zi-iihua-r5op/
    * */
    public int cuttingRope(int n) {
        if (n < 4)
            return n - 1;
        long res = 1;
        while (n > 4) {
            res = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
