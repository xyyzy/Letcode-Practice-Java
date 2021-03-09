package 最热100题._121_买卖股票的最佳时机;

import java.util.ArrayDeque;

public class Solution {
    //暴力法O(n^2) 超时
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(prices[j] - prices[i], max);
            }
        }
        return max;

    }

    /**
     * 单调栈
     */
    public int maxProfit1(int[] prices) {
        int max = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] prices2 = new int[prices.length + 1];
        for (int i = 0; i < prices.length; i++) {
            prices2[i] = prices[i];
        }
        for (int i = 0; i < prices2.length; i++) {
            //如果栈不为空，且栈顶元素大于要加入的元素，则弹出，并计算max(弹出元素减去栈底元素)
            while (!stack.isEmpty() && stack.peek() >= prices2[i]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    continue;
                max = Math.max(max, top - stack.getLast());
            }
            stack.push(prices2[i]);
        }
        return max;

    }

    /**
     * 一次遍历
     */
    public static int maxProfit2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    /**
     * 动态规划1
     * <p>
     * dp[i][j]：下标为 i 这一天结束的时候，手上持股状态为 j 时，我们持有的现金数。
     */
    public static int maxProfit3(int[] prices) {

        int[][] dp = new int[prices.length][2];
        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //当天未持有股票
            //      1.前一天没有买入，今天也不买入
            //      2.前一天持有股票，今天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //当天持有股票
            //      1.前一天持有股票，今天不不卖出股票
            //      2.前一天未持有股票，今天买入
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        //返回最后一天不持有股票时的价格
        return dp[prices.length - 1][0];
    }


    /**
     * 动态规划2
     * <p>
     * dp[i]：将第i天卖出股票可以获得的最大利润定义为dp[i]
     */
    public static int maxProfit4(int[] prices) {
        int len = prices.length;
        int res = 0;
        int pre = 0;
        for (int i = 1; i < len; i++) {
            //利润差
            int diff = prices[i] - prices[i - 1];
            pre = Math.max(pre + diff, 0);
            res = Math.max(res, pre);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int i = maxProfit4(arr);
        System.out.println(i);
    }
}
