package 最热100题.岛屿问题._695_岛屿的最大面积;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int res = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == 1) {
                    int a = dfs(grid, i, j);
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (!inArea(grid, x, y)||grid[x][y]!=1) {
            return 0;
        }

        //表示已经访问过
        grid[x][y] =0;

        return 1+dfs(grid,x+1,y)
                +dfs(grid,x-1,y)
                +dfs(grid,x,y+1)
                +dfs(grid,x,y-1);
    }

    private boolean inArea(int[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }
}
