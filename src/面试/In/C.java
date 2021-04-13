package 面试.In;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String str0 = s.replaceAll("\\s", "");
        String[] nums = str0.split("\\D");
        String str1 = str0.replaceAll("\\d", "");

        int index = 0;
        int sum = 0;
        for (int i = 0; i < str1.length(); i++,index++) {
            char ch  = str1.charAt(i);
            if (ch=='-'){
                nums[index+1] = String.valueOf(Integer.parseInt(nums[index+1])*(-1));
            }
            if (ch=='*'){
                nums[index+1] = String.valueOf(Integer.parseInt(nums[index])*Integer.parseInt(nums[index+1]));
            }
            if (ch=='/'){
                nums[index+1] = String.valueOf(Integer.parseInt(nums[index])/Integer.parseInt(nums[index+1]));

            }
        }

    }
}
