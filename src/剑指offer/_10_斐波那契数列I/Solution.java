package 剑指offer._10_斐波那契数列I;

public class Solution {
    //动态规划
    public int fib(int n) {
        if (n == 0)
            return 0;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <=n; i++) {
            arr[i] = arr[i-1]+arr[i-2];
            arr[i] = arr[i]%1000000007;
        }
        return arr[n];
    }
}
