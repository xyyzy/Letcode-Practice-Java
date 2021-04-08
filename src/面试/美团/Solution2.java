package 面试.美团;

import java.util.Scanner;
/**
 * 题目描述：
 * 小美最近在学习操作系统。
 *
 * 流是操作系统中一个重要的概念。在 Linux 操作系统中，/dev/random 和 /dev/urandom 是两个重要的设备，它们可以提供永不为空的随机字节数据流。
 *
 * 小美自己也实现了一个类似于 /dev/random 的设备 /dev/crandom，但是它只能提供预先设定好但循环不断的某个小写字母排列。例如预先设定的字符串为 abcdefgh...xyz，那么这个设备会提供永不为空的字符串流 abcdefgh...xyzabcdefg...xyzabc...。
 *
 * 小美想利用这个设备生成一段文字，但她想知道恰好生成完这段文字时，浪费了这个流的多少个字符。
 *
 * 样例说明
 *
 * 拿取生成流中字母的情况如下，拿取的字母用下划线表示。
 *
 * abcde...lmn...def...hij...stu..zab...mno...
 *
 * 在生成好最后一个 n 的时候，浪费了没有标下划线的 59 个字符。
 * */
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder A = new StringBuilder(sc.nextLine());

        String B = sc.nextLine();
        int useNum=0;
        int i = 0;
        int j = 0;
        if (B==null|| B.equals(" "))
            System.out.println(A.length());
        if (A==null||A.equals(" "))
            System.out.println(0);
        while (i < A.length() || j < B.length()) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                useNum++;
            }
            if (i == A.length() && j != B.length()) {
                A.append(A);
            }
            if (j==B.length()){
                break;
            }
        }
        System.out.println(useNum);

    }
}
