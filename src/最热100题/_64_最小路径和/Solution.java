package 最热100题._64_最小路径和;

/**
 * 动态规划
 * dp[i][j] 表示到达i,j位置时的最小路径和为多少
 * 当i，j左边和上边都不是边界时 dp[i][j] = min(dp[i-1][j],dp[i][j-1])+gird[i,j]
 * 当i,j左边为边界时,即i!=0,j=0,  dp[i][j] = dp[i-1]dp[j] + gird[i][j]
 * 当i,j上边为边界时,即i=0,j!=0,dp[i][j] = dp[i][j-1] + grid[i][j]
 * 当i,j左边和上边都为边界时，即i=0,j=0, dp[i][j] = gird[i][j]
 */

public class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else  grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1])+grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
