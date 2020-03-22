package 周赛._181_力扣周赛._5178_四因数;

public class Solution {
    public static int sumFourDivisors(int[] nums) {
        int sum=0;
        for (int j = 0; j <nums.length; j++) {
            int n = nums[j];
            if (help(n)==4) {
                for (int i = 1; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        sum += i;
                        sum +=n/i;
                    }
                }
            }
        }
        return sum;
    }

    private static int help(int n ){
        int count=0;
        for (int i = 1; i <= Math.sqrt(n) ; i++) {
            if (n%i==0){
                count+=2;
            }
            if (i*i==n)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] num={21,4,7};
        System.out.println(sumFourDivisors(num));
    }
}
