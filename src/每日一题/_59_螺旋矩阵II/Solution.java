package 每日一题._59_螺旋矩阵II;

import java.util.ArrayList;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        circle(res, 0, 0, n - 1, n - 1, 1);
        return res;
    }

    private void circle(int[][] res, int x1, int y1, int x2, int y2, int start) {
        if (x2 < x1 || y2 < y1)
            return;
        if (x1 == x2) {
            res[x1][y1] = start;
            return;
        }

        int val = start;
        for (int i = y1; i < y2; i++) res[x1][i] = val++;
        for (int i = x1; i < x2; i++) res[i][y2] = val++;
        for (int i = y2; i > y1; i--) res[x2][i] = val++;
        for (int i = x2; i > x1; i--) res[i][y1] = val++;

        circle(res, x1 + 1, y1 + 1, x2 - 1, y2 - 1, val);
    }

    public int[][] generateMatrix1(int n) {
        int[][] res = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) res[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) res[i][r] = num++;
            r--;
            for (int i = r; i >= l; i--) res[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) res[i][l] = num++;
            l++;
        }
        return res;
    }

}
