package 最热100题._84_柱状图中最大的矩阵;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    /**
     * 暴力法
     */
    public static int largestRectangleArea(int[] heights) {
        /*int max = 0;
        int leftArea = 0;
        int rightArea = 0;
        if(heights.length==1){
            return heights[0];
        }
        for (int i = 0; i < heights.length; i++) {
            //往左扫描
            leftArea =0;
            for (int j = i; j >= 0; j--) {
                if (heights[j] >= heights[i]) {
                    leftArea = (i - j + 1) * heights[i];
                }
               else {
                   break;
                }
            }
            //往右扫描
            rightArea=0;
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] >= heights[i]) {
                    rightArea = (j - i ) * heights[i];
                }
                else {
                    break;
                }
            }
            if (max < leftArea + rightArea)
                max = leftArea + rightArea ;
        }
        return max;*/

        //暴力法更简便写法
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            // 找左边最后 1 个大于等于 heights[i] 的下标
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] > curHeight)
                left--;

            // 找右边最后 1 个大于等于 heights[i] 的索引
            int right = i;
            while (right < len - 1 && heights[right + 1] >= curHeight)
                right++;

            int width = right - left + 1;
            res = Math.max(width * curHeight, res);

        }
        return res;
    }

    /**
     * 单调栈
     *
     *
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/
     */
    public static int largestRectangleArea1(int[] heights) {
        int res = 0;
        int[] new_heights = new int[heights.length + 2];
        //存放的是下标，而不是高度
        Deque<Integer> stack = new ArrayDeque<Integer>();
        //头尾都初始化为0！！！很重要
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }

        for (int i = 0; i < new_heights.length; i++) {
            //如果单调栈非空，且当前下标的元素小于栈顶元素，就弹出栈顶元素计算面积
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                //弹出栈顶元素
                int cur = stack.pop();
                //左边界
                int left = stack.peek();
                //有边界
                int right = i;
                res= Math.max(res,(right-left-1)*new_heights[cur]);
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        int i = largestRectangleArea1(arr);
        System.out.println(i);
    }
}
