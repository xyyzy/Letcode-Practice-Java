package 面试.东方财富1;

public class B {
    public int Waves(int[] values) {
        // write code here
        int n = values.length;
        int res = 0;
        int left = 0;
        while (left + 2 < n) {
            int right = left + 1;
            if (values[left] < values[left + 1]) {
                while (right + 1 < n && values[right] < values[right + 1]) {
                    right++;
                }
                if (right < n - 1 && values[right] > values[right + 1]) {
                    while (right + 1 < n && values[right] > values[right + 1]) {
                        right++;
                    }
                    res = Math.max(res,right-left+1);
                }else {
                    right++;
                }
            }
            left = right;
        }
        return res;
    }
}
