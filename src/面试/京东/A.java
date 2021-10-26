package 面试.京东;

import java.util.HashMap;
import java.util.Scanner;


public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder(sc.nextLine());
        int m = sc.nextInt();
        int len = s.length();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = len;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int k = 0; k < s.length(); k++) {
            map.put(s.charAt(k), map.getOrDefault(s.charAt(k), 0) + 1);
            //更新最大最小
            max = Math.max(max, map.get(s.charAt(k)));
            min = Math.min(min, map.get(s.charAt(k)));
        }
        while (j != m) {
            s.append(s.charAt(i));
            //迭代增加s的元素
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            //更新最大最小
            max = Math.max(max, map.get(s.charAt(i)));
            min = Math.min(min, map.get(s.charAt(i)));
            i++;
            i = i % len;
            //总长度
            j++;
        }


        isPrime(max - min);
    }

    private static void isPrime(int num) {
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

