package 最热100题._75_颜色分类;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        if (nums.length <= 2)
            return;
        // all in [0, zero) = 0
        // all in [zero, i) = 1
        // all in [two, len - 1] = 2

        // 循环终止条件是 i == two，那么循环可以继续的条件是 i < two
        // 为了保证初始化的时候 [0, zero) 为空，设置 zero = 0，
        // 所以下面遍历到 0 的时候，先交换，再加
        int zero = 0;
        int two = nums.length;
        int i = 0;
        // 为了保证初始化的时候 [two, len - 1] 为空，设置 two = len
        // 所以下面遍历到 2 的时候，先减，再交换

        // 当 i == two 上面的三个子区间正好覆盖了全部数组
        // 因此，循环可以继续的条件是 i < two
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                i++;
                zero++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums, two, i);
            }
        }

    }

    private void swap(int[] nums, int i, int zero) {
        int temp = nums[i];
        nums[i] = nums[zero];
        nums[zero] = temp;
    }
}
