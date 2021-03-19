package 面试.携程;

import java.util.Scanner;

/**
 * 为了寻找最佳拍档，我们定义两人名字的缘分值：两人名字左对齐后，对应位置字的拼音的缘分值之和。对于两个拼音s1、s2，通过剔除一些字符使得留下的子串一模一样，被剔除字符之和的最小值即为两个拼音的缘分值。求给定两人名字的缘分值。
 */

public class Solution {
    static int calcSimilarity(String name1, String name2) {
        //按空格分割
        String[] s1 = name1.split(" ");
        String[] s2 = name2.split(" ");
        int len1 = s1.length;
        int len2 = s2.length;
        int i = 0;
        int j = 0;
        int res = 0;
        //遍历
        while (i < len1 && j < len2) {
            String temp1 = s1[i];
            String temp2 = s2[j];
            int m = 0;
            int n = 0;
            //按字符遍历
            while (m < temp1.length() && n < temp2.length()) {
                if (temp1.charAt(m) == temp2.charAt(n)) {
                    m++;
                    n++;
                } else {
                    res = res + temp1.charAt(m) + temp2.charAt(n);
                    m++;
                    n++;
                }

            }
            //如果是第二个词长一点
            if (m >= temp1.length()) {
                for (int k = n; k < temp2.length(); k++) {
                    res += temp2.charAt(k);
                }
            }
            //如果是第一个词长一点
            if (n >= temp2.length()) {
                for (int k = m; k < temp1.length(); k++) {
                    res += temp1.charAt(k);
                }
            }
            i++;
            j++;
        }
        return res;
    }


    static int calcSimilarity1(String name1, String name2) {
        int res = 0;
        //先把所有的ASCII码加起来 减去2倍重复的
        for (int i = 0; i < name1.length(); i++) {
            if (name1.charAt(i) != ' ')
                res += name1.charAt(i);
        }
        for (int i = 0; i < name2.length(); i++) {
            if (name2.charAt(i) != ' ')
                res += name2.charAt(i);
        }
        String[] s1 = name1.split(" ");
        String[] s2 = name2.split(" ");
        int len1 = s1.length;
        int len2 = s2.length;
        int i = 0;
        int j = 0;

        while (i < len1 && j < len2) {
            String temp1 = s1[i];
            String temp2 = s2[j];
            int m = 0;
            int n = 0;
            while (m < temp1.length() && n < temp2.length()) {
                if (m == n && temp1.charAt(m) == temp2.charAt(n)) {
                    res -= 2 * temp1.charAt(m);
                    m++;
                    n++;
                } else {
                    m++;
                    n++;
                }

            }
            i++;
            j++;

        }

        return res;
    }


    static int calcSimilarity2(String name1, String name2) {

        int res = 0;
        if (name1.equals(" ")) {
            for (char c : name2.toCharArray()) {
                res += c;
            }
        }
        if (name2.equals(" ")) {
            for (char c : name1.toCharArray()) {
                res += c;
            }
        }else {
            //先把所有的ASCII码加起来 减去2倍重复的
            for (int i = 0; i < name1.length(); i++) {
                if (name1.charAt(i) != ' ')
                    res += name1.charAt(i);
            }
            for (int i = 0; i < name2.length(); i++) {
                if (name2.charAt(i) != ' ')
                    res += name2.charAt(i);
            }
            int i = 0;
            int j = 0;
            while (i < name1.length() && j < name2.length()) {

                if (name1.charAt(i) == ' ') {
                    i++;
                    while (name2.charAt(j) != ' ') {
                        j++;
                    }
                    //移到空格后面
                    j++;
                } else if (name2.charAt(j) == ' ') {
                    j++;
                    while (name1.charAt(i) != ' ') {
                        i++;
                    }
                    i++;
                } else if (name1.charAt(i) == name2.charAt(j)) {
                    res -= 2 * name1.charAt(i);
                    i++;
                    j++;
                } else {
                    i++;
                    j++;
                }

            }
        }
        return res;
    }


    static int calcSimilarity3(String name1, String name2) {
        int res = 0;
        int i = 0;
        int j = 0;
        if (name1.equals(" ")) {
            for (char c : name2.toCharArray()) {
                res += c;
            }
        }
        if (name2.equals(" ")) {
            for (char c : name1.toCharArray()) {
                res += c;
            }
        } else {
            while (i < name1.length() && j < name2.length()) {
                if (name1.charAt(i) == ' ') {
                    i++;
                    while (name2.charAt(j) != ' ') {
                        res += name2.charAt(j);
                        j++;
                    }
                    j++;
                } else if (name2.charAt(j) == ' ') {
                    j++;
                    while (name1.charAt(i) != ' ') {
                        res += name1.charAt(i);
                        i++;
                    }
                    i++;
                } else if (name1.charAt(i) != name2.charAt(j)) {
                    res += name1.charAt(i) + name2.charAt(j);
                    i++;
                    j++;
                } else {
                    i++;
                    j++;
                }

            }
            //如果是第二个词长一点
            if (i >= name1.length()) {
                for (int k = j; k < name2.length(); k++) {
                    res += name2.charAt(k);
                }
            }
            //如果是第一个词长一点
            if (j >= name2.length()) {
                for (int k = i; k < name1.length(); k++) {
                    res += name1.charAt(k);
                }
            }
        }

        return res;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()) {
//            String name1 = in.nextLine();
//            String name2 = in.nextLine();
//
//a
//        }
        String name1 = "a";
        String name2 = " ";

        int sum = calcSimilarity2(name1, name2);

        System.out.println(sum);
    }
}
