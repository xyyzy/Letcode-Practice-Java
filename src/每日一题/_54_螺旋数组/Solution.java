package 每日一题._54_螺旋数组;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        //行
        int m = matrix.length;
        //列
        int n = matrix[0].length;
        circle(matrix, 0, 0, m - 1, n - 1, res);
        return res;
    }

    //一圈圈遍历
    private void circle(int[][] matrix, int x1, int y1, int x2, int y2, ArrayList<Integer> res) {
        if (x2 < x1 || y2 < y1)
            return;
        //只有一行时按行遍历
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                res.add(matrix[x1][i]);
            }
            return;
        }
        //只有一列时
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                res.add(matrix[i][y1]);
            }
            return;
        }

        //环形遍历
        for (int i = y1; i < y2; i++) res.add(matrix[x1][i]);
        for (int i = x1; i < x2; i++) res.add(matrix[i][y2]);
        for (int i = y2; i > y1; i--) res.add(matrix[x2][i]);
        for (int i = x2; i > x1; i--) res.add(matrix[i][y1]);


        //下一个内圈
        circle(matrix, x1 + 1, y1 + 1, x2 - 1, y2 - 1, res);
    }


    //按照顺时针遍历
    public List<Integer> spiralOrder1(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        //定义遍历方向 顺时针，右下左上
        int[][] dis = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = matrix.length;
        int col = matrix[0].length;
        int startX = 0, startY = 0, d = 0;
        for (int i = 0; i < row * col; i++) {
            res.add(matrix[startX][startY]);
            //设置已经访问过
            matrix[startX][startY] = 101;
            //用于测试下一步是否越界
            int nX = startX + dis[d][0], nY = startY + dis[d][1];
            //越界判断说明,用于改变遍历方向
            if (nX < 0 || nY < 0 || nX >= row || nY >= col || matrix[nX][nY] == 101) {
                d = (d + 1) % 4;
            }
            startX = startX + dis[d][0];
            startY = startY + dis[d][1];
        }
        return res;
    }
}
