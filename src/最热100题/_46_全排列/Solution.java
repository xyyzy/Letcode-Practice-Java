package 最热100题._46_全排列;

import java.util.*;

public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0)
            return res;
        //存放路径 用栈
        Deque<Integer> path = new ArrayDeque<Integer>();
        //是否使用过
        boolean[] used = new boolean[len];
        dfs(nums, res, len, 0, used, path);
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, int len, int depth, boolean[] used, Deque<Integer> path) {
        //递归出口
        if (len == depth) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                //递归
                dfs(nums, res, len, depth + 1, used, path);
                //回溯 之前做了什么这里做逆操作
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        List<List<Integer>> permute = permute(nums);
    }


}
