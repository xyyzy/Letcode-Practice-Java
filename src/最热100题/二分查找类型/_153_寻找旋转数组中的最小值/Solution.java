package 最热100题.二分查找类型._153_寻找旋转数组中的最小值;

public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            //单调递增时直接返回
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            int mid = left + ((right - left) >>> 1);
            //mid  和 left  之间单调则最小值一定不在这个之间
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            }
            //必存在最小值的情况，但是需要注意right == mid
            else if (nums[left] > nums[mid]) {
                right = mid;
            }
        }
        return -1;
    }
}
