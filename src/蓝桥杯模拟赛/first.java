package 蓝桥杯模拟赛;

import java.util.Scanner;
import java.util.Vector;

public class first {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (c=='x'||c=='y'||c=='z'){
                c= (char) (c-23);
            }
            else{
                c = (char)(c+3);
            }
            System.out.print(c);
        }
    }
}

