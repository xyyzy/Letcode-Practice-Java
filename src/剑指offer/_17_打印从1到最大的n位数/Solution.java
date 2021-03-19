package 剑指offer._17_打印从1到最大的n位数;

public class Solution {
    public int[] printNumbers(int n) {
        //n位的最大值位 10^n -1
        int end = (int) Math.pow(10,n)-1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i+1;
        }
        return res;
    }
}
