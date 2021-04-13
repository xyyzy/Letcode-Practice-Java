package 面试.In;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        Long count = 0L;
        Long i = 1L;
        while (n > 0) {
            n = n-i;
            i++;
            count++;
        }


        System.out.println(count);
    }
}
