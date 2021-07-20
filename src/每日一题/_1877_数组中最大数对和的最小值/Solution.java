package 每日一题._1877_数组中最大数对和的最小值;

import java.util.Arrays;
import java.util.Map;

/**
 * @description: TODO
 * @author: ares
 * @modified By: ares
 * @date: Created in 2021/7/20 20:45
 * @version:v1.0
 */
public class Solution {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, nums[left] + nums[right]);
            left++;
            right--;
        }
        return max;
    }
}
