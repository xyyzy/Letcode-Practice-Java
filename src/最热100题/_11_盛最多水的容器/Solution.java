package 最热100题._11_盛最多水的容器;

public class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        int temp = 0;
        while (i < j) {
            temp = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, temp);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
