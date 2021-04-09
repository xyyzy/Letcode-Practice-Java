package 面试.便利蜂;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = sc.nextInt();
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length - count+1; i++) {
            int max =nums[i];
            for (int j = i+1; j < i + count; j++) {
                max = Math.max(max,nums[j]);
            }
            res.add(max);
        }

        System.out.println(Arrays.toString(res.toArray()));
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        for (Integer re : res) {
//            sb.append(String.valueOf(re)+',');
//        }
//        sb.deleteCharAt(sb.length()-1);
//        sb.append(']');
//        System.out.println(sb);

    }
}
