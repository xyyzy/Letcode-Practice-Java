package 面试.爱客科技;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String next = sc.next();
            StringBuilder sb = new StringBuilder();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i <next.length() ; i++) {
                if (set.add(next.charAt(i)))
                    sb.append(next.charAt(i));
            }
            System.out.println(sb.toString());
        }
    }
}
