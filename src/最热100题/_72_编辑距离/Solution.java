package 最热100题._72_编辑距离;


/**
 * 动态规划
 * dp[i][j] 表示word1前i个字符转变到word2前j个字符所需的最小步数
 * 有三种做法:
 * 增 dp[i][j] = dp[i][j-1] +1;
 * 删 dp[i][j] = dp[i-1][j] +1;
 * 改 dp[i][j] = dp[i-1][j-1] +1;
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化：当 word2 长度为 0 时，将 word1 的全部删除即可
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        // 当 word1 长度为 0 时，插入所有 word2 的字符即可
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                //增
                int add = dp[i][j - 1] + 1;
                int del = dp[i - 1][j] + 1;
                int update = dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.min(Math.min(add, del), update);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
