package 剑指offer._21_调整数组顺序使奇数位于偶数前;

public class Solution {
    public int[] exchange(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            if (nums[left] % 2 == 1) {
                left++;
                continue;
            }
            if (nums[right] % 2 == 0) {
                right--;
                continue;
            }
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;

        }
        return nums;
    }
}
