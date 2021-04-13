package 面试.滴滴;

import java.util.Scanner;

/**
 * 小A的家门口有一排树，每棵树都有一个正整数的高度。由于树的高度不同，来到小A家的朋友都觉得很难看。为了将这些树高度变得好看，小A决定对其中某些树施展魔法，具体来说，每施展一次魔法，可以把一棵树的高度变成任意正整数（可以变高也可以变低）。
 *
 * 小A认为，这排树如果能构成等差为x的等差数列就好看了。但是小A不想施展太多次魔法，他想知道最少施展魔法的次数。
 *
 * 形式上来说，小A家门口一共有n棵树，第i棵树高度为ai。小A最后的目标为对于任意2≤i≤n，ai-ai-1=x
 *
 * */
public class B {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] s1 = str1.split(" ");
        int n = Integer.parseInt(s1[0]);
        int x = Integer.parseInt(s1[s1.length - 1]);
        if (n == 0 || x == 0)
            System.out.println(0);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[0] + x * (i)) {
                count++;
            }
        }
        int left = 0;
        int right = n - 1;

        int mid = left + (right - left) / 2;
        helper(arr, left, right, x);

        System.out.println(count);
    }

    private static void helper(int[] arr, int left, int right, int x) {
        if (left == right) {
            if (arr[left] != arr[0] + x * left) {
                count++;
            }
            return;
        }
        int mid = left + (right-left)/2;
        helper(arr,left,mid,x);
//        helper(arr,mid+1,right,x);
    }


/**
 *
 import java.util.Scanner;

 public class Main {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);

 String str1 = sc.nextLine();
 String[] s1 = str1.split(" ");
 int n = Integer.parseInt(s1[0]);
 int x = Integer.parseInt(s1[s1.length-1]);
 String str = sc.nextLine();
 String[] s = str.split(" ");
 int[] arr = new int[s.length];
 for (int i = 0; i < s.length; i++) {
 arr[i] = Integer.parseInt(s[i]);
 }
 int prev = arr[0];
 int count = 0;
 for (int i = 1; i < arr.length; i++) {
 if (arr[i] - prev == x) {
 prev = arr[i];
 continue;
 } else {
 arr[i] = prev + x;
 prev = arr[i];
 count++;
 }
 }
 System.out.println(count);
 }
 }

 * */
}
