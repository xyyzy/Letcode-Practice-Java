package 面试.东方财富1;

import java.util.*;

public class C {
    public int CountCriticalVotes(int[] blocks, int blockIndex) {
        // write code here
        int res =0;
        List<List<Integer>> permute = permute(blocks);

        for (List<Integer> integers : permute) {

        }
        return  res;
    }


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
        int[] arr = {4,2,7,4};
        C c = new C();
        int i = c.CountCriticalVotes(arr, 1);
        System.out.println(i);
    }
}
