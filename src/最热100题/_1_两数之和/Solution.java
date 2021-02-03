package 最热100题._1_两数之和;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private  static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];

    }

    public static void main(String[] args) {
        int nums[] ={2,7,11,5};
        int[] ints = twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }




}
