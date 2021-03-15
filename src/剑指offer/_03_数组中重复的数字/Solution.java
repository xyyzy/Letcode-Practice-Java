package 剑指offer._03_数组中重复的数字;

import java.util.HashSet;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 *
 * */
public class Solution {
    //方法一：集合
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int res = -1;
        for (int num : nums) {
            if (!set.add(num)){
               res = num;
               break;
            }
        }
        return res;
    }

    //方法二：原地置换 如果没有重复的数，则数值i应该在第i个位置
    public int findRepeatNumber1(int[] nums) {
        int temp =0;
        for (int i = 0; i < nums.length; i++) {
            //只要条件不成就一直循环
            while (nums[i]!=i){
                if (nums[i]==nums[nums[i]]){
                  return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
