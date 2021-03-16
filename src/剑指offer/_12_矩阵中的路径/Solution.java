package 剑指offer._12_矩阵中的路径;

public class Solution {
    //上下左右
    int[][] dis = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private boolean[][] visited;
    private int row;
    private int col;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    /****
     *  @param board
     * @param word
     * @param i
     * @param j
     * @param begin  遍历word下标
     * @return
     */
    private boolean dfs(char[][] board, String word, int i, int j, int begin) {
        if (begin == word.length() - 1) {
            return board[i][j] == word.charAt(begin);
        }

        //如果当前坐标的元素 和 word的值相等
        if (board[i][j] == word.charAt(begin)) {
            //标记
            visited[i][j] = true;
            //以当前点为中心访问
            for (int[] di : dis) {
                int newX = i + di[0];
                int newY = j + di[1];
                //下个节点在矩阵内，且没有访问过
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(board,word,newX,newY,begin+1)){
                        return true;
                    }
                }
            }
            //回溯
            visited[i][j] = false;
        }
        return false;

    }

    private boolean inArea(int newX, int newY) {

        return (newX >= 0 && newX <= row-1 && newY >= 0 && newY <= col-1);
    }

}
