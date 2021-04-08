package 面试.米哈游.第一题;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String par = "1807";
        int start = 0;
        int i = 0;
        int j = 0;
        boolean flag = true;
        str = str + '3';
        //输入字符的长度
        int length = str.length();
        //一次匹配的长度
        int parlength = 0;
        //先找到1
        while (str.charAt(i) != '1') {
            i++;
        }
        start = i;
        while (i < length) {
            if (str.charAt(i) == par.charAt(j)) {
                i++;
            } else {
                j++;
            }
            //一次匹配完成后，记录长度并更新start
            if (j >= par.length()) {
                parlength = i - start;
                start = i;
                j = 0;
            }
            if (i == length - 1) {
                flag = !flag;
                if (flag == true) {
                    break;
                }
            }
        }

        System.out.println(parlength);
    }

}
