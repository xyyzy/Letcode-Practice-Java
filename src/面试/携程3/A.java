package 面试.携程3;

import java.util.*;

public class A {
    static int procee(int[] scores, int[] cards) {
        List<List<Integer>> permute = permute(cards);
        int max = Integer.MIN_VALUE;
        for (List<Integer> integers : permute) {
            int temp = scores[0];
            int i = 0;
            for (Integer integer : integers) {
                i+=integer;
                temp += scores[i];
            }
            max = Math.max(temp,max);
        }
        return max;

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

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _scores_size = 0;
        _scores_size = Integer.parseInt(in.nextLine().trim());
        int[] _scores = new int[_scores_size];
        int _scores_item;
        for(int _scores_i = 0; _scores_i < _scores_size; _scores_i++) {
            _scores_item = Integer.parseInt(in.nextLine().trim());
            _scores[_scores_i] = _scores_item;
        }

        int _cards_size = 0;
        _cards_size = Integer.parseInt(in.nextLine().trim());
        int[] _cards = new int[_cards_size];
        int _cards_item;
        for(int _cards_i = 0; _cards_i < _cards_size; _cards_i++) {
            _cards_item = Integer.parseInt(in.nextLine().trim());
            _cards[_cards_i] = _cards_item;
        }

        res = procee(_scores, _cards);
        System.out.println(String.valueOf(res));

    }
}
