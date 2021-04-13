package 最热100题.打家劫舍系列._213_打家劫舍II_笔试题;

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)), myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre+num,cur);
            pre = tmp;
        }
        return cur;
    }



    //另一种写法
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if(length ==2){
            return Math.max(nums[0],nums[1]);
        }
        //确保下面两端子数组的长度都是大于1的(最短也为2)；因此在rob1中就省略了特判；
        //如果将上述特判的情况写在下面的函数rob1中也可以；

        int p1 = Myrob1(Arrays.copyOfRange(nums,0,length-1));   //不选最后一个
        int p2 = Myrob1(Arrays.copyOfRange(nums,1,length));     //不选第一个


        return Math.max(p1,p2);
    }

    public int Myrob1(int[] nums) {
        int length = nums.length;

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }


}
