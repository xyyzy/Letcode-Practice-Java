package 达西面试题.奇怪的计数器;

public class Solution {
    public static long strangeConuter(long t) {
        int num = 3;
        int flg = 0;
        for (int i = 1; i < t; i++) {
            num--;
            flg++;
            if (num == 0) {
                num = flg*2;
                flg=0;
            }
        }
        return num;
    }


}
