package 每日一题._50_求幂次放;

public class Soution {
    public double myPow(double x, int n) {
        if (x == 0.0f)
            return 0.0d;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        while (b > 0) {
            //如果是奇数,则那一位出来乘上res
            if ((b & 1) == 1)
                res = x * res;
            x *= x;
            b = b >> 1;
        }
        return res;
    }
}
