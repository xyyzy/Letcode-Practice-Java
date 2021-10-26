package 最热100题.岛屿问题._463_岛屿的周长;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1)
                    return dfs(grid, r, c);
            }

        }
        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        // 从一个岛屿方格走向网格边界，周长加 1
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return 1;
        }
        // 从一个岛屿方格走向水域方格，周长加
        if (grid[r][c] == 0)
            return 1;
        //已经访问过的陆地 为0
        if (grid[r][c] != 1)
            return 0;
        //表示该陆地已经访问过
        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);

    }

    //解法2

    /**
     * 每个岛正常的周长为4；但若与其它岛相连，那么周长就要减二。
     * 如：两个岛不相连为 2 * 4 =8；若相连则为 (2 * 4) - (n * 2)，n为相邻的边数；
     * 则问题转化为求岛的总数以及相邻边的数量；
     * <p>
     * 每个岛都只负责自己有没有与后面和下面相邻，若有则边数加1；
     * 特殊情况：最后和最下面的岛不用计算相邻边数；
     * <p>
     * 作者：liumian97
     * 链接：https://leetcode-cn.com/problems/island-perimeter/solution/xun-huan-bian-li-qiu-jie-dao-yu-zhou-cha-bvbr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int islandPerimeter1(int[][] grid) {
        int totolCount = 0;
        int sideCount = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    totolCount++;
                    if (x < grid.length - 1) {
                        if (grid[x + 1][y] == 1)
                            sideCount++;
                    }
                    if (y < grid[0].length - 1) {
                        if (grid[x][y+1]==1)
                            sideCount++;
                    }
                }
            }
        }
        return totolCount*4 - sideCount*2;
    }
}
