package 最热100题._78_子集;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 递归解法
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int index, ArrayList<Integer> path, ArrayList<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i, path, res);
            path.remove(path.size() - 1);
        }
    }

    /*
     * 非递归解法
     * 对res中已有的每个list元素末尾都追加新的num 即可
     * */
    public static List<List<Integer>> subsets1(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        //遍历num
        for (int num : nums) {
            // 对res中的每个list追加num
            int len = res.size();
            for (int i = 0; i < len; i++) {
                ArrayList<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = subsets1(nums);

    }
}
