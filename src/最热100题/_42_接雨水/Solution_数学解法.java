package 最热100题._42_接雨水;

public class Solution_数学解法 {
    /**
     * https://leetcode-cn.com/problems/trapping-rain-water/solution/wei-en-tu-jie-fa-zui-jian-dan-yi-dong-10xing-jie-j/
     * */
    public int trap(int[] height) {
        //韦恩图解法
        int n = height.length;
        int s1 =0 ,s2 = 0 , sum = 0;
        int maxLeft = 0,maxRight = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > maxLeft){
                maxLeft = height[i];
            }
            if (height[n-i-1] > maxRight){
                maxRight = height[n-i-1];
            }
            s2 += maxRight;
            s1 += maxLeft;
            sum += height[i];
        }
        return s1 +s2 -maxLeft * n -sum;
    }
}
