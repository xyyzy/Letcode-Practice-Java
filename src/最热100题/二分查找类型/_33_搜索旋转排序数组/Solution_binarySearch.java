package 最热100题.二分查找类型._33_搜索旋转排序数组;

public class Solution_binarySearch {
    /**
     * 由于数组在某个点发生了旋转，因此数组是部分有序，也是可以采用二分查找，只是要判断是在左边还是右边
     * 情况1：如果[1.mid-1]有序，且target在[l,mid]范围内 则讲搜索范围缩小至[1.mid-1] 否则 在[mid+1,r]
     * 情况2：如果[mid+1.r]有序，且target在[mid+1,r]范围内 则讲搜索范围缩小至[mid+1.r] 否则 在[1,mid-1]
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            //判断右边是否有序
            if (nums[left] <= nums[mid]) {
                //判断target的取值
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{4,5,6,7,0,1,2};
        search(arr,0);

    }
}
