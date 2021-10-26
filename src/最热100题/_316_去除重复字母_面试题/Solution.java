package 最热100题._316_去除重复字母_面试题;

import java.util.ArrayDeque;

public class Solution {
    String removeDuplicateLetters(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int[] count = new int[256];
        //每个元素的个数
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            //每个遍历过的元素都减去
            count[c]--;
            //已经存在栈中 ，直接跳过
            if (inStack[c]) continue;
            while (!stack.isEmpty() && stack.peek() > c) {
                //若之后不在有该元素，则停止pop()
                if (count[stack.peek()] == 0) {
                    break;
                }
                //否则 pop出去
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
