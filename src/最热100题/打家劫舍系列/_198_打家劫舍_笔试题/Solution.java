package 最热100题.打家劫舍系列._198_打家劫舍_笔试题;

public class Solution {
    //dp
    public static int rob(int[] nums) {
        int len = nums.length;
        //[0]的情况
        if (len==1){
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        //处理[1,1]情况
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < len; i++) {
            if (i>=3){
                dp[i] = Math.max(dp[i-2]+nums[i],dp[i-3]+nums[i]);
            }
            else
                dp[i] = dp[i-2]+nums[i];
            max = Math.max(dp[i],max);
        }
        return max;
    }
    //dp另一种写法
    public int rob1(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        //dp[1] 存的是num[0]
        dp[1] = nums[0];
        for(int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[len];
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int rob = rob(arr);
        System.out.println(rob);
    }
}
