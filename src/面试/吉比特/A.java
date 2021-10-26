package 面试.吉比特;

import 最热100题._155_最小栈.MinStack;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        String str = s1[0];
        char[] As = s1[1].toCharArray();
        char[] Bs = s1[2].toCharArray();
        char A = As[0];
        char B = Bs[0];
        int startA = Integer.MAX_VALUE;
        int endA = Integer.MIN_VALUE;
        int startB = Integer.MAX_VALUE;
        int endB = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            //当前元素
            if (temp == A || temp == A - 32 || temp == A + 32) {
                startA = Math.min(startA, i);
                endA = Math.max(endA, i);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            //当前元素
            if (temp == B || temp == B - 32 || temp == B + 32) {
                startB = Math.min(startB, i);
                endB = Math.max(endB, i);
            }
        }
        if (endA < 0 || endB < 0) {
            System.out.println(-1);
        } else {
            int max = Math.max(Math.abs(startA - endB), Math.abs(endA - startB));
            System.out.println(max);
        }

    }
}
