package 剑指offer._04_二维数组中的查找;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int j = 0;
        //从左下角开始，小于上移，大于右移
        while (row >= 0 && j < matrix[0].length) {
            if (matrix[row][j] < target) j++;
            else if (matrix[row][j] > target) row--;
            else return true;
        }
        return false;

    }
}
