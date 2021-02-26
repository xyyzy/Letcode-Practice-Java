package 最热100题._85_最大矩形;


import static 最热100题._84_柱状图中最大的矩阵.Solution.largestRectangleArea1;

/**
 * 把每一行都看作是
 * */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int[] res = new int[matrix[0].length];
        int max = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    res[col] += 1;
                } else {
                    res[col] = 0;
                }
            }
            //调用84题的算法
            max = Math.max(max,largestRectangleArea1(res));
        }
        return max;

    }
}
