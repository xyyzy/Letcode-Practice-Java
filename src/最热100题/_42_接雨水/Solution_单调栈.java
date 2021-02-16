package 最热100题._42_接雨水;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


/**
 * 单调栈
 * 当前高度小于等于栈顶高度，入栈，指针后移。
 * 当前高度大于栈顶高度，出栈，计算出当前墙和栈顶的墙之间水的多少，然后计算当前的高度和新栈的高度的关系，
 * 重复第 2 步。直到当前墙的高度不大于栈顶高度或者栈空，然后把当前墙入栈，指针后移。
 */
public class Solution_单调栈 {
    public static int trap(int[] height) {
        int length = height.length;
        if (length == 0)
            return 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int ans = 0;
        int curr = 0;
        while (curr < length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.isEmpty() && height[curr] > height[stack.peek()]) {
                //栈顶元素的高度
                int h = height[stack.peek()];
                //出栈
                stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = curr - stack.peek() - 1;
                int ansHeight = Math.min(height[curr], height[stack.peek()]);
                ans = ans + (ansHeight-h) * distance;
            }
            stack.push(curr);
            curr++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(arr);
        System.out.println(trap);
    }
}
