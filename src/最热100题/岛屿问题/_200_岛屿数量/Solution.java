package 最热100题.岛屿问题._200_岛屿数量;

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_isLands = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    num_isLands++;
                    dfs(grid, i, j);
                }
            }
        }
        return num_isLands;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (!inArea(grid, x, y)) return;
        //表示访问过
        grid[x][y] = '0';
        //上下左右
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }

    boolean inArea(char[][] grid, int x, int y) {
        //坐标合法且没有被访问过
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] == '1';
    }
}
