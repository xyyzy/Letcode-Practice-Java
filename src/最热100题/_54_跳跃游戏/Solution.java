package 最热100题._54_跳跃游戏;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0)
            return true;
        //能到达的最远距离
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            //如果当前结点能到达的位置大于max则更新
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }
}
