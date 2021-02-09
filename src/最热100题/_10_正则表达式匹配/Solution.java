package 最热100题._10_正则表达式匹配;

import java.util.Stack;

/**
 * 动态规划
 * 题解链接：https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-di-gui-xiang-jie-by-tin-oycu/
 *
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];

        dp[0][0] = true;
        //初始化 s为空串的时候
        for (int i = 2; i <= pLength; i++) {
            dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];
        }
        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (j > 1 && s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                }
            }
        }
        return dp[sLength][pLength];

    }
}
