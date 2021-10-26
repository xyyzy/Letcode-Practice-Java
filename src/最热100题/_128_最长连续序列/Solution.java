package 最热100题._128_最长连续序列;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    /**
     * 利用hashSet的去重效果，左边的要求一定不是存在nums -1，如果存在nums-1那一定会连续
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            //包含num-1说明起点不是num
            if (set.contains(num - 1))
                continue;
            else {
                //记录以num为左边界的连续序列长度
                int len = 0;
                while (set.contains(num++))
                    len++;
                res = Math.max(res,len);
            }
        }
        return res;
    }
}
