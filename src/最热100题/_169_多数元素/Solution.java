package 最热100题._169_多数元素;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    /**
     * 1.排序/
     * 因为一定存在多数，所以排序之后中间值一定是多数
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 2.map解决
     */
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            if (count >= len / 2) {
                return nums[i];
            }
            map.put(nums[i], count);
        }
        return -1;
    }

    /**
     * 3.摩尔投票法
     */
    public int majorityElement2(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                //前面都消耗完了，在重新赋值
                count++;
                major = nums[i];
            }else if (major==nums[i]){
                //自己人，count就加1
                count++;
            }else {
                //不是自己人就同归于尽，消掉一个
                count--;
            }
        }
        return major;
    }
}
