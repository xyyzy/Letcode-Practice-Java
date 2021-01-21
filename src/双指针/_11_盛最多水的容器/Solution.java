package 双指针._11_盛最多水的容器;

/**
 * 两侧指针只移动板长短的
 */
public class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
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

    //简化写法
    public int maxArea2(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
