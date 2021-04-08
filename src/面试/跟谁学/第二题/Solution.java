package 面试.跟谁学.第二题;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    //100、50、20、10、5、1

    public static void main(String[] args) {
        int[] values = {100, 50, 20, 10, 5, 1};

        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int[] nums = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            //数量
            int num = value / values[i];
            //余数
            int mod = value % values[i];
            value = mod;
            nums[i] = num;
        }
        for (int num : nums) {
            System.out.print(num+" ");
        }

    }


}
