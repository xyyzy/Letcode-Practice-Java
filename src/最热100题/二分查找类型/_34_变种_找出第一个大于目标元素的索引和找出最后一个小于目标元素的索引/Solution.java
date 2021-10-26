package 最热100题.二分查找类型._34_变种_找出第一个大于目标元素的索引和找出最后一个小于目标元素的索引;

public class Solution {
    //找出第一个大于目标元素的索引
    public static int lowBoundnum(int[] nums, int target, int left, int right) {

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            //大于目标值的情况
            if (nums[mid] > target) {
                //考虑 元素不在数组中,且元素中所有元素都比target大
                if (mid == 0 || nums[mid - 1] <= target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] <= target) {
                left = mid +1;
            }
        }
        //所有元素都小于目标元素
        return -1;
    }

    //找出最后一个小于目标元素的索引
    public static int upperBoundnum(int[] nums, int target, int left, int right) {

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            //小于目标值
            if (nums[mid] < target) {
                //看看是不是当前区间的最后一位，如果当前小于，后面一位大于，返回当前值即可
                if (mid == right || nums[mid+1] >= target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] >= target) {
                right = mid-1;
            }
        }
        //所有元素都小于目标元素
        return -1;
    }

    public static void main(String[] args) {
        int []nums = {1,3,5,5,6,6,8,9,11};
        int target = 0;
        int i = lowBoundnum(nums, 5, 0, nums.length - 1);
        int i1 = upperBoundnum(nums, 7, 0, nums.length - 1);
        System.out.println(i);
        System.out.println(i1);
    }
}
