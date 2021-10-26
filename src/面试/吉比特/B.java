package 面试.吉比特;

import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long startA = sc.nextLong();
        Long startB = sc.nextLong();
        Long startC = sc.nextLong();
        Long n = sc.nextLong();
        Long xa = sc.nextLong();
        Long ya = sc.nextLong();
        Long xb = sc.nextLong();
        Long yb = sc.nextLong();
        Long xc = sc.nextLong();
        Long yc = sc.nextLong();
        Long[] res = new Long[3];
        res[0] = startA;
        res[1] = startB;
        res[2] = startC;
        for (int i = 0; i < n; i++) {
            res[1] = (res[1] % 1000000007 + (startA % 1000000007) * (xa % 1000000007))% 1000000007;
            res[2] = (res[2] % 1000000007 + (startA % 1000000007) * (ya % 1000000007))% 1000000007;
            res[0] = (res[0] % 1000000007 + (startB % 1000000007) * (xb % 1000000007))% 1000000007;
            res[2] = (res[2] % 1000000007 + (startB % 1000000007) * (yb % 1000000007))% 1000000007;
            res[0] = (res[0] % 1000000007 + (startC % 1000000007) * (xc % 1000000007))% 1000000007;
            res[1] = (res[1] % 1000000007 + (startC % 1000000007) * (yc % 1000000007))% 1000000007;
            startA = res[0] % 1000000007;
            startB = res[1] % 1000000007;
            startC = res[2] % 1000000007;
        }
        System.out.print(res[0]);
        System.out.print(" ");
        System.out.print(res[1]);
        System.out.print(" ");
        System.out.print(res[2]);
    }
}
