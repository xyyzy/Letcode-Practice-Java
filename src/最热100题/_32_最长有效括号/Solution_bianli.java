package 最热100题._32_最长有效括号;

public class Solution_bianli {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, ans = 0;
        //先从左往右
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else right++;
            //如果右括号大于左括号 重置
            if (right > left)
                right = left = 0;

            if (left == right)
                ans = Math.max(ans, 2 * right);
        }
        left = right = 0;
        //再从右往左
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else right++;
            //如果右括号大于左括号 重置
            if (left > right)
                right = left = 0;

            if (left == right)
                ans = Math.max(ans, 2 * right);
        }
        return ans;
    }
}
