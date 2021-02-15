package 最热100题._32_最长有效括号;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 从前往后扫描字符串 s。使用 i 来记录当前遍历到的位置，使用 j 来记录最近的最长有效括号的开始位置。
 * <p>
 * 只对 '(' 进行入栈（入栈的是对应的下标），当遍历到 ) 的时候，由于栈中只有 '('，所以可以直接弹出一个 ( 与之匹配（如果有的话）。
 * <p>
 * 再检查栈中是否还有 (，如果有使用栈顶元素的下标来计算长度，否则使用 j 下标来计算长度。
 *
 *
 * 题解:https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
 */
public class Solution_Stack {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return  ans;
    }

}
