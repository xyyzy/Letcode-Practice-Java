package BFS._542_01矩阵_BFS_动态规划;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*
* 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。
* */
public class Solution {
    public static int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return null;

        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];//结果集
        boolean[][] visited = new boolean[m][n];//记录已经计算过的位置
        Queue<int[]> queue = new LinkedList<>();//广搜队列
        //遍历，将等于0的位置计入结果集并入队
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //四个方向广搜
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//上下左右
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    res[newX][newY] = res[x][y] + 1;
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arry = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] ans = updateMatrix(arry);
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
