package 面试.美团;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目描述：
 * 小美在做化学实验，这个实验需要配置很多种浓度溶液，因此配溶液之前需要详细计算溶液浓度（用质量分数表示），避免误操作。
 * <p>
 * 实验初始溶液质量和质量分数分别为 m0 , ω0%。小美会进行如下两种操作：
 * <p>
 * 1、A(m, ω) 表示向目前的溶液中加入质量为 m 质量分数为 ω% 的溶液；
 * <p>
 * 2、B 表示撤销上一步 A 操作。
 * <p>
 * 对于每一步操作，小美都想知道当前溶液的质量与质量分数。
 * <p>
 * 质量分数 ω 按如下方式计算：设溶液中溶质质量为 x，溶液总质量为 y，则
 */
public class Solution5 {
    public static void main(String[] args) {
        String name = "sdasdasdasdsadasdad";
        char[] charArray = name.toCharArray();
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ops = new ArrayList<>();
        //初始溶液质量
        int startYZ = sc.nextInt();
        //初始浓度
        int startN = sc.nextInt();
        //初始溶质质量
        double startZZ = startYZ * startN;
        int pNum = sc.nextInt();
        System.out.println("pNum:" + pNum);
        for (int i = 0; i <= pNum; i++) {
            String op = sc.nextLine();
            ops.add(op);
        }
        int backTime = 0;
        int oldYz = 0;
        int oldZZ = 0;
        double oldN = 0;


        for (int i = 1; i < ops.size(); i++) {
            String op = ops.get(i);
            String[] s = op.split(" ");
            //新的溶液质量
            int newYZ = 0;
            //新的溶质质量
            int newZZ = 0;
            //新的浓度
            double newN = 0;

            //如果是操作就执行
            if (s[0].equals("A")) {
                //每次操作增加的溶质
                int opZZ = (int) (Integer.parseInt(s[1]) * (Integer.parseInt(s[2])/100.0));
                //操作完之后的溶质
                newZZ = (int) (startZZ + opZZ);
                //操作完之后的溶液质量
                newYZ = (int) (startZZ + Integer.parseInt(s[1]));
                //新的浓度
                newN = newZZ * 100.0 / newYZ;
                backTime++;
                System.out.println(newZZ + " " + newN);
                oldZZ = newZZ;
                oldYz = newYZ;
                oldN = newN;
            } else {//回撤上一步操作
                if (backTime > 0) {
                    startZZ = oldZZ;
                    startYZ = oldYz;
                    break;
                }
                continue;
            }
            startZZ = newZZ;
            startYZ = newYZ;
        }
    }
}
