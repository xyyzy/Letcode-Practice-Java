package 面试.疯狂游戏;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int res = i + 1;
        while (!notAb(res)) {
            res++;
        }
        System.out.println(res);
    }

    private static boolean notAb(int res) {
        String s = String.valueOf(res);
        StringBuffer sb = new StringBuffer(s);
        StringBuffer temp = sb.reverse();
        int i = 0;
        int j = i + 1;
        while (j < temp.length()) {
            if (temp.charAt(i)==temp.charAt(j))
                return  false;
            else {
                i++;
                j++;
            }
        }
        return true;
    }
}
