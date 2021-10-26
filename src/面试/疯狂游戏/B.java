package 面试.疯狂游戏;

import java.util.ArrayList;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        int n = s.charAt(0) - '0';
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int length = split.length;
        ArrayList<Integer> strings = new ArrayList<>();
        int count = 0;
        for (int i = 1; i < length; i++) {
            strings.add(Integer.parseInt(split[i]));
            count++;
            if (count == n * 4) {
                arr.add(strings);
                strings = new ArrayList<>();
                count = 0;
            }

        }
        int arrSize = arr.size();
        StringBuffer sb = new StringBuffer();
        for (int i = arrSize-1; i >=0 ; i--) {
            ArrayList<Integer> integers = arr.get(i);
            for (Integer integer : integers) {
                sb.append(integer);
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
