package 未定标题._56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList<>();
        //加入第一个元素
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            //每次都和当前的结果中最右边的数组进行比较
            int[] peak = res.get(res.size() - 1);
            if (curInterval[0] > peak[1]) {
                res.add(curInterval);
            }else {
                peak[1] = Math.max(curInterval[1],peak[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = solution.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

}
