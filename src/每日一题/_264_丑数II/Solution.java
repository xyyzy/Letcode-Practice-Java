package 每日一题._264_丑数II;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution {
    /**
     * 方法一：最小堆
     * 要得到从小到大的第 nn 个丑数，可以使用最小堆实现。
     * <p>
     * 初始时堆为空。首先将最小的丑数 11 加入堆。
     * <p>
     * 每次取出堆顶元素 xx，则 xx 是堆中最小的丑数，由于 2x, 3x, 5x2x,3x,5x 也是丑数，因此将 2x, 3x, 5x2x,3x,5x 加入堆。
     * <p>
     * 上述做法会导致堆中出现重复元素的情况。为了避免重复元素，可以使用哈希集合去重，避免相同元素多次加入堆。
     * <p>
     * 在排除重复元素的情况下，第 nn 次从最小堆中取出的元素即为第 nn 个丑数。
     */
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        set.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            Long curr = heap.poll();
            ugly = Math.toIntExact(curr);
            for (int factor : factors) {
                long next = curr * factor;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }


    //dp
    // https://leetcode-cn.com/problems/ugly-number-ii/solution/chou-shu-ii-by-leetcode-solution-uoqd/
    //https://leetcode-cn.com/problems/ugly-number-ii/solution/san-zhi-zhen-fang-fa-de-li-jie-fang-shi-by-zzxn/
    public int nthUglyNumber1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i]==num2){
                p2++;
            }
            if (dp[i]==num3){
                p3++;
            }
            if (dp[i]==num5){
                p5++;
            }
        }
        return dp[n];
    }
}
