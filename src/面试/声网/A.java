package 面试.声网;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
//        boolean flag = true;
//        long i = 1;
//        long min = 0;
//        if (num % 2 == 0 && num % 5 == 0) {
//            System.out.println(-1);
//        }
//        while (flag) {
//            long temp = i * num;
//            if (isResult(temp)) {
//                System.out.println("i="+i);
//                System.out.println("temp="+temp);
//                min = getResult(temp);
//                flag = false;
//            }
//            i++;
//        }
//        System.out.println("min="+min);
        StringBuilder temp = new StringBuilder("1");
        long temp1 = Long.parseLong(temp.toString());
        while (temp1 % num != 0) {
              temp.append("1");
              temp1 = Long.parseLong(temp.toString());
        }
        String s = temp1 + "";
        System.out.println(s.length());
    }

    private static int getResult(long num) {
        String str = num + "";
        int reslut = 0;
        while (num != 0) {
            reslut++;
            num = num / 10;
        }
        return reslut;
    }


    private static boolean isResult(long num) {
        while (num != 0) {
            if (num % 10 == 1) {
                num = num / 10;
            } else if (num % 10 != 1) {
                return false;
            }
        }
        return true;
    }
}
