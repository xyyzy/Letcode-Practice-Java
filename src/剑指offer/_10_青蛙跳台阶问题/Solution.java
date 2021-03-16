package 剑指offer._10_青蛙跳台阶问题;

//青蛙跳到n阶台阶和第n-1和n-2台阶有关
//dp[n] = dp[n-1]+dp[n-2] ;
public class Solution {
    public int numWays(int n) {
        int a, b, sum;
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0)
                arr[i] = 1;
            else if (i == 1)
                arr[i] = 1;
            else {
                arr[i] = arr[i - 2] + arr[i - 1];
                arr[i] = arr[i] % 1000000007;
            }
        }
        return arr[n];
    }

    //优化空间
    public int numWays1(int n) {
        int a = 1, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
