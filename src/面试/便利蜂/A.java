package 面试.便利蜂;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Integer> nums = new Stack<>();
        Stack<String> sStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            //数字的情况
            if (Character.isDigit(str.charAt(i))) {
                num = num * 10 + (str.charAt(i) - '0');
            }else if (str.charAt(i)=='{'){
                //存入数字
                nums.push(num);
                num=0;
                sStack.push(res.toString());
                res = new StringBuilder();
            }else if (str.charAt(i)=='}'){
                int n = nums.pop();
                String temp = res.toString();
                //重复添加
                for (int j = 1; j < n; j++) {
                    res.append(temp);
                }
                res = new StringBuilder(sStack.pop()+res.toString());
            }else {
                //字符的情况
                res.append(str.charAt(i));
            }
        }
        System.out.println(res);

    }


}
