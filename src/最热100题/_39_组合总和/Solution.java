package 最热100题._39_组合总和;

import java.util.*;

public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int len = candidates.length;
        if (len == 0)
            return res;

        //剪枝,排序是剪枝的前提
        Arrays.sort(candidates);
        dfs(candidates, 0, len, target, path, res);

        return res;
    }


    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */

    private static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        //尝试可行解
        for (int i = begin; i < len; i++) {
            int temp = target - candidates[i];
            //如果减去的一个数已经小于0，之后的所有数也一定小于0 所以剪掉
            if (temp<0)
                break;
            path.add(candidates[i]);
            dfs(candidates, i, len, temp, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 7};
        List<List<Integer>> list = combinationSum(arr, 7);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }
}
