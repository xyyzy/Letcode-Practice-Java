package 每日一题.M62_圆圈中最后剩下的数字;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public int lastRemaining(int n, int m) {
        LinkedList<Integer> lists = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            lists.add(i);
        }
        while (lists.size() != 1) {
            for (int i = 0; i < m; i++) {
                Integer pre = lists.pollFirst();
                if (i != m - 1) {
                    lists.add(pre);
                }

            }
        }
        return lists.pollFirst();
    }
}
