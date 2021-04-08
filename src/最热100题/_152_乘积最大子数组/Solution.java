package 最热100题._152_乘积最大子数组;

import org.junit.experimental.max.MaxCore;

public class Solution {
    //dp[i]
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[nums.length];
        int[] minF = new int[nums.length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; i++) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; i++) {
            ans = Math.max(ans,maxF[i]);
        }
        return ans;
    }
}
