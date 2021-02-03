package 最热100题._5_最长回文子串;

public class Solution1 {

    /**
     * 动态规划
     *
     * 状态转移方程 dp[i][j] = (s[i]==s[j]) and dp[i+1][j-1]
     * 字串的有效区间,边界条件 (j-1)-(i+1)+1<2  -> j-i<3
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        int max = 1;
        int begin = 0;
        if (len < 2)
            return s;
        //表示第s[i...j] 串是否为回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //先行后列
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                // 如果i,j不是回文串赋值为false
                if (s.charAt(i) != s.charAt(j))
                    dp[i][j] = false;
                else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+max);

    }
}
