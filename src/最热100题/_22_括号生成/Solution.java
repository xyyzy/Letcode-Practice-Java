package 最热100题._22_括号生成;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0)
            return res;
        int lc = 0;
        int rc = 0;
        dfs(res, "", n, lc, rc);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号已经用了几个
     * @param right  右括号已经用了几个
     * @param n      左括号、右括号一共得用几个
     * @param res    结果集
     */
    public void dfs(List<String> res, String curStr, int n, int left, int right) {
        //左右括号全部加入退出循环
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        //左括号数量大于右括号
        if (left < right) {
            return;
        }
        if (left < n) {
            dfs(res, curStr + "(", n, left + 1, right);
        }
        if (right < n) {
            dfs(res, curStr + ")", n, left, right + 1);
        }

    }

}
