package 最热100题._20_有效的括号;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 栈
 *
 * */
public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                //如果栈为空，且栈顶元素与当前得到的元素不匹配说明匹配失败
                if (stack.isEmpty() || stack.peek() != pairs.get(c)) {
                    return false;
                }
                //去除顶点元素
                stack.pop();
            } else {
                //入栈
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }
}
