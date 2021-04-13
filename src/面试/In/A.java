package 面试.In;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    static int m = 0;
    static int n = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m + n - 1; i++) {
            int x = i < n ? 0 : i - n + 1;
            int y = i < n ? i : n - 1;
            while (inArr(x,y,i)){
                System.out.print(arr[x][y]);
                //最后一个
                if (x == m - 1 && y == n - 1)
                    break;
                System.out.print(",");
                x++;
                y--;
            }

        }
    }

    private static boolean inArr(int x, int y, int index) {
        return (x + y == index && x < m && y < n && x >= 0 && y >= 0);
    }
}


//
//import java.util.Arrays;
//        import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        int[] res = new int[m * n];
//        int count = 0;
//        int[][] arr = new int[m][n];
//        StringBuilder res1 = new StringBuilder();
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//        for (int i = 0; i <= m + n - 2; i++) {
//            for (int x = 0; x <= i && (x < m) && i - x < n; x++) {
//
//                res[count++] = arr[x][i - x];
//                res1.append(arr[x][i-x]);
//                res1.append(",");
//            }
//            for (int y = n - 1; y >= 0 && i - y >= 0 && i - y < n && i - y > 0; y--) {
//                res[count++] = arr[i-y][y];
//                res1.append(arr[i-y][y]);
//                res1.append(",");
//            }
//        }
//        String s = Arrays.toString(res);
//        StringBuilder s1 = new StringBuilder(s);
//        s1.deleteCharAt(0);
//        s1.deleteCharAt(s1.length()-1);
//        //System.out.println(s1);
//        res1.deleteCharAt(res1.length()-1);
//        System.out.println(res1);
//    }
//}
