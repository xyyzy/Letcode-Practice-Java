package 面试.友塔游戏;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                arr[j][i] = x;
            }
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int max = 1;
        int i = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            int temp = 1;
            for (int k = j + 1; k < arr.length; k++) {
                int left1 = arr[j][0];
                int right1 = arr[j][1];
                int left2 = arr[k][0];
                int right2 = arr[k][1];
                //在像框内
                if (left2 - left1 <= 100 && right2 - right1 <= 100) {
                    temp++;
                    max = Math.max(temp, max);
                } else {
                    break;
                }
            }
        }
        System.out.println(max);
    }
}
