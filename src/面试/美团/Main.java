package 面试.美团;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 小团现在有两个等大的多重集合（与集合的区别仅是在可以在集合中出现重复元素）A 和 B。她现在想让 A 集合与 B 集合相等。她会先选择一个非负整数 x，然后让 A 集合中的所有数都加上 x 并对 m 取模。也就是说，对于 A 中的全部元素 a，都把 a 变成 (a + x) mod m。
 *
 * 她想知道这个最小的 x 是多少，才能使经过变换后 A = B。并且她保证至少存在一个满足条件的 x。
 * */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //A ,B  的数字个数
        int n = 0;
        //(a+x) mod m
        int m = 0;
        int x = 0;
        n = sc.nextInt();
        m = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(sc.next());
        }

        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(sc.next());
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int flag = 0;
        for (int i = 0; i <= Math.sqrt(m); i++) {
            int[] point = Arrays.copyOf(A,6);
            for (int j = 0; j < n; j++) {
                point[j] = (point[j] + i) % m;
            }
            Arrays.sort(point);
            if (Arrays.equals(point,B)){
                flag = i;
                break;
            }

        }
        x = flag;
        System.out.println(x);

    }
//    abcdefghijkl m nopqrstuvwxyz abcd e fgh i jklmnopqrs t u vwxyz a bcdefghijklm n opqrstuvwxyz
}
