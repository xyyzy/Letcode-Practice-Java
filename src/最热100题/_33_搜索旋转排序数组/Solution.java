package 最热100题._33_搜索旋转排序数组;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        int len = nums.length;
        if (len == 0) return -1;
        if (len == 1) return nums[0] == target ? 0 : -1;

        while (left < right) {
            //分到右边
            mid = left + (right - left + 1) / 2;
            if (nums[mid] == target)
                return mid;
            //右半区间有序
            if (nums[mid] < nums[right]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else
                    right = mid - 1;
            } else {
                // [left, mid] 有序，但是为了和上一个 if 有同样的收缩行为，
                // 我们故意只认为 [left, mid - 1] 有序
                // 当区间只有 2 个元素的时候 int mid = (left + right + 1) >>> 1; 一定会取到右边
                // 此时 mid - 1 不会越界，就是这么刚刚好
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                } else
                    left = mid;

            }
        }
        if (nums[left] == target)
            return left;
        return -1;
    }
}
