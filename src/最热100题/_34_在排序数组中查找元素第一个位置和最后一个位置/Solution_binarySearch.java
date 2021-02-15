package 最热100题._34_在排序数组中查找元素第一个位置和最后一个位置;

public class Solution_binarySearch {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1)
            return new int[]{-1, -1};
        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }


    private int findFirstPosition(int[] nums, int target) {
        int mid = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //中间值放左区间
            mid = left + (left - right) / 2;
            //如果中间位置小于target则，该左侧一定不是目标元素出现的第一个位置
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid;
            }
        }
        if (nums[left] == target)
            return left;
        return -1;
    }

    private int findLastPosition(int[] nums, int target) {
        int mid = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 中间值放右区间
            mid = left + (left - right + 1) / 2;
            //如果中间位置小于target则，该左侧一定不是目标元素出现的第一个位置
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] <= target) {
                left = mid;
            }
        }

        return left;
    }
}
