package 面试.京东;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String s = sc.readLine();
        StringBuffer sb = new StringBuffer();
        String m_ = sc.readLine();
        int m = Integer.parseInt(m_);
        //固定长度
        int len = s.length();
        Long max = Long.MIN_VALUE;
        Long min = Long.MAX_VALUE;
        //索引s
        int p = 0;
        //新的sb长度
        int j = 0;
        char[] arr = new char[26];
        while (j < m) {
            sb.append(s.charAt(p));
            arr[s.charAt(p) - 'a']++;
            p++;
            p = p % len;
            j++;
        }

        for (int l = 0; l < arr.length; l++) {
            max = Math.max(max, arr[l]);
        }
        for (int l = 0; l < arr.length; l++) {
            if (arr[l] != 0) {
                min = Math.min(min, arr[l]);
            }

        }

        isPrime(max - min);
    }

    private static void isPrime(Long num) {
        int count = 0;
        for (int j = 2; j < Math.sqrt(num); j++) {
            if (num % j == 0) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Yes");
            System.out.println(num);
        } else {
            System.out.println("No");
        }
    }
}


