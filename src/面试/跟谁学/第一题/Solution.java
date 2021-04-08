package 面试.跟谁学.第一题;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int num=0;
        /**
         * ：1）长度为3的倍数；2）以ATG开始；3）以TAA、TAG或者TGA终止。
         * */
        if (n%3!=0) System.out.println(0);

    }
}
