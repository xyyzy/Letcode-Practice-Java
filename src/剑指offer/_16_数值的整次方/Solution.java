package 剑指offer._16_数值的整次方;

public class Solution {
    /*
     * 快速幂:二分思想
     * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
     * */
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        long b = n;
        double res = 1.0;
        //如果幂为负数 先取反
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            //即 b%2==1,为奇数
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }


    /**
     * 递归
     *https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/jian-zhi-offer-16-shu-zhi-de-zheng-shu-c-rgqy/
     */
    public double myPow1(double x, int n) {
        if (n == 0)
            return 1;
        else if (n<0){
            return 1/(x * myPow(x,-n-1));
        }else if (n%2==1){
            return x*myPow(x,n-1);
        }else {
            return myPow(x*x,n/2);
        }
    }
}
