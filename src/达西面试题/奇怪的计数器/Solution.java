package 达西面试题.奇怪的计数器;


import java.util.HashMap;

public class Solution {
    public static long strangeConuter(long t) {
   /*     int num = 3;
        int flg = 0;
        for (int i = 1; i < t; i++) {
            num--;
            flg++;
            if (num == 0) {
                num = flg*2;
                flg=0;
            }
        }
        return num;*/

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        long num = 3;
        long flag = 0;
        long temp =t;
        while ((temp - num) > 0) {
            temp = temp - num;
            num = num * 2;
            flag++;
        }
        long start = (long) (Math.pow(2, flag) * 3);
        long star1 = start - 2;
        long res = start - (t - star1);
        return res;

    }

    public static void main(String[] args) {
        long l = strangeConuter(50);
        System.out.println(l);
    }

}
