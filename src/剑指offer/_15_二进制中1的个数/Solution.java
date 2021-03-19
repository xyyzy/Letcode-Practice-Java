package 剑指offer._15_二进制中1的个数;

public class Solution {
    //移位运算

    /**
     * x:  10101010
     * x-1:10101001  &
     * 10101000
     * <p>
     * 10101000
     * 10100111  &
     * 10100000
     * <p>
     * 每次-1都会将最低为1变为0
     */
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            n = n & (n - 1);
            sum++;
        }
        return sum;
    }


    public int hammingWeight1(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n & 1;
            //无符号右移
            n >>>= 1;
        }
        return sum;
    }
}
