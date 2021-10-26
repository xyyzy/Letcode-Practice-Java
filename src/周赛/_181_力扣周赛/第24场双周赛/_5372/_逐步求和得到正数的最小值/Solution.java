package 周赛._181_力扣周赛.第24场双周赛._5372._逐步求和得到正数的最小值;

public class Solution {
    public int minStartValue(int[] nums) {
        int ans = 0;
        int startvalue1 = 1;
        boolean flag = false;
        while (true) {
            for (int i = 1; i <nums.length ; i++) {
                if (i==1) {
                    ans = startvalue1 + nums[0];
                }
                if (ans<1){
                    break;
                }
                ans = ans+nums[i];
                if (ans<1){
                    break;
                }
                if (i==nums.length-1){
                    flag = true;
                }
            }
            startvalue1++;
            if (flag)
                break;
        }
        return startvalue1-1;

    }
}
