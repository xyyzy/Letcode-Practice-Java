package 最热100题._300_最长递增子序列;

import java.util.Arrays;

public class Solution {
    /**
     * 动态规划
     * dp[i]  表示以i为结尾的最长上升子序列长度
     */
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return len;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for (int j = 0; j < dp.length; j++) {
            res = Math.max(res, dp[j]);
        }
        return res;
    }

    /**
     * dp+二分查找 优化时间复杂度
     * 定义tails[i] 表示长度为i+1的所有上升子序列的结尾最小的值
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/
     */
    public static int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return len;

        //tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
        int[] tail = new int[len];
        // 遍历第 1 个数，直接放在有序数组 tail 的开头
        tail[0] = nums[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 0;

        for (int i = 1; i < len; i++) {
            // 比tail数组实际有效的末尾的那个元素还大
            if (nums[i] > tail[end]) {
                //直接添加在那个元素后面
                end++;
                tail[end] = nums[i];
            } else {
                // 使用二分查找法，在有序数组 tail 中
                // 找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
                int left = 0;
                int right = end;
                while (left < right) {
                    // 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                    // int mid = left + (right - left) / 2;
                    int mid = left + ((right - left) >>>1);
                    if (tail[mid] < nums[i]) {
                        // 中位数肯定不是要找的数，把它写在分支的前面
                        left = mid + 1;
                    }else {
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }
        }
        // 此时 end 是有序数组 tail 最后一个元素的索引
        // 题目要求返回的是长度，因此 +1 后返回
        end++;
        return end;

    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int i = lengthOfLIS1(arr);
        System.out.println(i);
    }
}
