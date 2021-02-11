package 最热100题._46_全排列II;


import java.util.*;

/**
 * 回溯+剪枝
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0)
            return res;
        //存放路径 用栈
        Deque<Integer> path = new ArrayDeque<Integer>();
        //是否使用过
        boolean[] used = new boolean[len];
        //排序 方便剪枝
        Arrays.sort(nums);
        dfs(res, nums, len, 0, path, used);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int len, int depth, Deque<Integer> path, boolean[] used) {
        //递归出口
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
                // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                path.addLast(nums[i]);
                used[i] = true;
                dfs(res, nums, len, depth + 1, path, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
