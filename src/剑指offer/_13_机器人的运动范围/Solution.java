package 剑指offer._13_机器人的运动范围;

public class Solution {
    int m;
    int n;
    int[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bitSum(i) + bitSum(j) > k) {
                    visited[i][j] = 1;
                }
            }
        }
        return dfs(0, 0);
    }

    private int dfs(int x, int y) {
        if (x >= 0 && x <= m - 1 && y >= 0 && y <= n - 1 && visited[x][y] == 0) {
            visited[x][y] = 1;
            return dfs(x + 1, y) + dfs(x, y + 1) + 1;
        }
        return 0;
    }


    private int bitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
