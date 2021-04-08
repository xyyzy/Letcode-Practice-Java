package 面试.米哈游.第三题;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int sum=0;
        for (int i = start; i <=end; i++) {
            int temp =i;
            int sumJ = 0;
            int sumO = 0;
            boolean flag1 = true;
            boolean flag2 = false;
            while (temp != 0) {
                if (flag1) {
                    sumJ = sumJ + temp % 10;
                    temp/= 10;
                    flag1 = !flag1;
                    flag2 = !flag2;
                }
                if (flag2) {
                    sumO = sumO + temp % 10;
                    temp = temp / 10;
                    flag1 = !flag1;
                    flag2 = !flag2;
                }
            }
            if (sumJ==sumO){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
