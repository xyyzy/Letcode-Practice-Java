package 最热100题.二分查找类型._74_搜索二维数组;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            //在第几行 可以用 mid/列数
            int rowNum = mid / col;
            int colNum = mid % col;
            if (matrix[rowNum][colNum] == target)
                return true;
            else if (matrix[rowNum][colNum] > target) {
                right = mid - 1;
            } else if (matrix[rowNum][colNum] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}
