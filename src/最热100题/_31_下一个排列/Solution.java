package 最热100题._31_下一个排列;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                //排序之后 第一个比num[i-1]大的数就是我们要找的数，排序之后更容易找到
                Arrays.sort(nums,i,len);
                for (int j = i; j < len; j++) {
                    if (nums[j]>nums[i-1]){
                        int temp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = temp;
                        return;
                    }
                }
            }
        }
        //如果没有下一个排列 返回升序排列
        Arrays.sort(nums);
    }
}
