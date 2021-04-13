package 最热100题.二分查找类型._81_搜索旋转排序数组II;

public class Solution {
    //跟33题相比多了重复的元素，当遇到重复的元素就跳过
    //如果nums[left] == nums[right] 则让 left++，并退出本次循环，其余部分完全相同

    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left]) {
                left++;
                continue;
            }
            //右边有序
            if (nums[mid] > nums[left]) {
                //判断在有序情况下 放哪边
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1};
        boolean search = search(arr, 1);
        System.out.println(search);
    }
}
