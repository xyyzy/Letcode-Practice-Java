package 最热100题._35_搜索插入位置;

public class Solution__binarySearch {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (nums[len-1]<target)
            return len;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            //中间值往左区间
            mid = left + (right - left + 1) / 2;
            if (nums[mid] > target)
                right = mid;
            else left = mid-1;
        }
        return left;
    }
}
