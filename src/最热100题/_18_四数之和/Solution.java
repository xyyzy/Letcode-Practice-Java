package 最热100题._18_四数之和;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        //利用set达到去重的效果
        Set<List<Integer>> set = new HashSet<>();
        //第一个数
        for (int i = 0; i < nums.length - 3; i++) {
            //第二个数
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[right] + nums[left];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        //排序查重、添加
                        Collections.sort(list);
                        set.add(list);
                        left++;
                        right--;

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    //不用set去重
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        //利用set达到去重的效果
        List<List<Integer>> set = new ArrayList<>();
        //第一个数
        for (int i = 0; i < nums.length - 3; i++) {
            //第二个数
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[right] + nums[left];
                    if (sum == target) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //去重
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        right--;
                        while (left < right && i < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return set;
    }
}
