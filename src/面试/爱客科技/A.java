package 面试.爱客科技;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A {

    //字符串排序
    //1.输出字母从小到大， 不区分大小写
    //2.大小写同时存在，则按顺序输出
    //3.非字符位子不变
    //1.2 规则 可以保证字典序大的且大小写字母会连续输出
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        while (sc.hasNextLine()) {
            String str  = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            //样例都以大写开头
            for (int i = 0; i < 26; i++) {
                char c = (char) (i + 'A');
                for (int j = 0; j < str.length(); j++) {
                    char c1 = str.charAt(j);
                    //相同或者等于小写
                    if (c1 == c || c1 == c + 32){
                        sb.append(c1);
                    }
                }
            }
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!Character.isLetter(c)){
                    sb.insert(i,c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
