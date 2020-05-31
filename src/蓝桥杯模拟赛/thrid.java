package 蓝桥杯模拟赛;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
*问题描述
　　对于一个 n 行 m 列的表格，我们可以使用螺旋的方式给表格依次填上正整数，我们称填好的表格为一个螺旋矩阵。
　　例如，一个 4 行 5 列的螺旋矩阵如下：
　　1 2 3 4 5
　　14 15 16 17 6
　　13 20 19 18 7
　　12 11 10 9 8
输入格式
　　输入的第一行包含两个整数 n, m，分别表示螺旋矩阵的行数和列数。
　　第二行包含两个整数 r, c，表示要求的行号和列号。
输出格式
　　输出一个整数，表示螺旋矩阵中第 r 行第 c 列的元素的值。
样例输入
4 5
2 2
样例输出
15
*
* */
/*public class thrid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List ans  = new ArrayList();
        int[][] array = new int[n][m];
        int[][] temp = new int[n][m];
        int r1 = 0, r2 = array.length - 1;
        int c1 = 0, c2 = array[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) temp[r1][c--](array[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(array[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(array[r2][c]);
                for (int r = r2; r > r1; r--) ans.add(array[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }


    }
}*/
