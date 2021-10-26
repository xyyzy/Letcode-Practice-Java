package 面试.京东;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        //从第一天开始
        int[] dp1 = new int[n];
        dp1[0] = arr[0];
        dp1[1] = arr[1];
        dp1[2] = dp1[0] + arr[2];
        for (int i = 3; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 2], dp1[i - 3]) + arr[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,dp1[i]);
        }
        System.out.println(max);
    }
}
