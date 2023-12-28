package leetcode.arrayOrString.maxProfit;

/**
 * @Description 买卖股票的最佳时机
 * @Author 王俊然
 * @Date 2023/12/4 19:46
 */
public class Solution {

    /**
     * 解决方法：最低点买入，最高点卖出 时间复杂度O(n)，空间复杂度O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int maxProfitResult = 0;
        int minPrice = prices[0];
        // 最低点买入，寻找最高点卖出
        for (int i = 1; i < prices.length; i++) {
            // 利润
            int profit = prices[i] - minPrice;
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfitResult) {
                maxProfitResult = prices[i] - minPrice;
            }
        }

        return maxProfitResult;
    }
}
