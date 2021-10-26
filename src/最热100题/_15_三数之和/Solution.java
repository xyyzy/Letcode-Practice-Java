package 最热100题._15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int len = nums.length;
        //如果长度大于3
        if (len < 3)
            return list;
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0)
                break;
            //
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //去重
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    R--;
                    L++;
                } else if (sum < 0) L++;
                else R--;
            }
        }
        return list;
    }
}
