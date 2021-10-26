package 最热100题.二分查找类型._69_x的平方根_面试题;

public class Solution {
    //数学换底公式
    public static double mySqrt(double x) {
        if (x == 0) {
            return 0;
        }
        double ans = (double) Math.exp(0.5 * Math.log(x));
        return (double) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    //二分
    public static int mySqrt1(int x) {
        // 特殊值判断
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;
        // 在区间 [left..right] 查找目标元素
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 注意：这里为了避免乘法溢出，改用除法
            if (mid > x / mid) {
                // 下一轮搜索区间是 [left..mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [mid..right]
                left = mid;
            }
        }
        return left;
    }

    public static double mySqrt2(double x) {
        if (x<1){
            return 1/mySqrt2(1/x);
        }
        double up = x/2;
        double low = 1;
        double mid = low + (up - low) / 2;
        while (Math.abs(low * low - x) >= 1e-6) {
            mid = low + (up - low) / 2;
            if (mid * mid > x) up = mid;
            else if (mid * mid < x)
                low = mid;
        }
        return mid;
    }


    public static void main(String[] args) {
        double v = mySqrt2(0.25);
        System.out.println(v);
    }


}
