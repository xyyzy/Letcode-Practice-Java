package 最热100题._79_单词搜索;

public class Solution {
    private static final int[][] MOVE = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private boolean[][] visited;
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        if (rows == 0)
            return false;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /***
     *
     * @param board
     * @param word
     * @param x
     * @param y
     * @param begin 遍历word的下标
     * @return
     */
    private boolean dfs(char[][] board, String word, int x, int y, int begin) {
        //到word的最后一个字符
        if (begin == word.length()-1) {
            return board[x][y] == word.charAt(begin);
        }
        if (board[x][y] == word.charAt(begin)) {
            //访问
            visited[x][y] = true;
            for (int[] ints : MOVE) {
                int newX = x + ints[0];
                int newY = y + ints[1];
                //新坐标在board内，且未被访问过
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(board, word, newX, newY, begin + 1)) {
                        return true;
                    }
                }
            }
            //回溯
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }


}
