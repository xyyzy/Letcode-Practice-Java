package 最热100题._42_接雨水;

/**
 * 按列求  只求当前列最多可以存放多少水所有列相加就是总存水量
 * 先分别找出当前列左右两边最大的列 再比较找出较小的列和当前相减就是 当前列存水量
 */
public class Solution {
    public int trap(int[] height) {
        int sum = 0;
        //两侧不会有存水量 所有从1 ~ len-1
        for (int i = 1; i < height.length - 1; i++) {
            //左侧高点
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft)
                    maxLeft = height[j];
            }
            //右侧高点
            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > maxRight)
                    maxRight = height[j];
            }

            //找出较小的
            int min = Math.min(maxLeft, maxRight);
            //只有当最小列 大于当前列时才能储水
            if (min > height[i]) sum = sum + (min - height[i]);
        }
        return sum;
    }

    /**
     * 动态规划优化
     */
    public int trap1(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }


}
