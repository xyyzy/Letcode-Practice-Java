package 最热100题.二分查找类型._34_在排序数组中查找元素第一个位置和最后一个位置;

public class Solution_binarySearch {
    public int[] searchRange(int[] nums, int target) {
        int upper = findLastPosition(nums,target);
        int low = findFirstPosition(nums,target);
        //不存在情况
        if (upper < low) {
            return new int[]{-1,-1};
        }
        return new int[]{low,upper};

    }


    private int findFirstPosition(int[] nums, int target) {
        int mid = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            //中间值放左区间
            mid = left + (right - left) / 2;
            //当目标值小于等于nums[mid]时，继续在左区间检索，找到第一个数
            if (target <= nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return left;
    }

    private int findLastPosition(int[] nums, int target) {
        int mid = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 中间值放右区间
            mid = left + (right - left ) / 2;
            //如果中间位置小于target则，该左侧一定不是目标元素出现的第一个位置
            if (target >= nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }

        return right;
    }
}
