package 最热100题._224_基本计算器;

import java.util.ArrayDeque;

public class Solution {
    public int calculate(String s) {
        int ans = 0;
        char[] str = s.toCharArray();
        int length = str.length;
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        ArrayDeque<Integer> signs = new ArrayDeque<>();
        int sign = 1;
        for (int i = 0; i < length; i++) {
            //空格跳过
            if (str[i] == ' ') continue;
            //如果是符号更新
            if (str[i] == '+' || str[i] == '-')
                sign = str[i] == '+' ? 1 : -1;
            //如果是数字就计算
            if (Character.isDigit(str[i])) {
                int num = str[i] - '0';
                //取出全部的数字
                while (i < length - 1 && Character.isDigit(str[i + 1])) {
                    num = num * 10 + (str[++i] - '0');
                }
                ans += sign * num;
            }
            //如果是左括号，将符号入栈，结果暂存
            else if (str[i] == '(') {
                nums.push(ans);
                signs.push(sign);
                ans = 0;
                sign = 1;
            }
            //是又括号
            else ans = nums.pop() +ans*signs.pop();
        }
        return ans;
    }
}
