package leetcode.dp;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-03
 */

//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
//
//        设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//        你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//        卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//        示例:
//
//        输入: [1,2,3,0,2]
//        输出: 3
//        解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class Case309 {
    static class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            int[] have = new int[len];// 第i天结束时，手里有一只股票的最大收益，非冷冻期
            int[] empty = new int[len];// 第i天结束时，手里没有股票的最大收益，非冷冻期
            int[] ice = new int[len];// 第i天结束时，是冷冻期(冷冻期说明手里一定没有股票)时，手里没有股票的最大收益
            have[0] = -prices[0];
            empty[0] = 0;
            ice[0] = 0;
            for (int i=1; i<len; i++) {
                have[i] = Math.max(have[i-1], empty[i-1] - prices[i]);
                empty[i] = Math.max(empty[i-1], ice[i-1]);
                ice[i] = have[i-1] + prices[i];
            }

            return Math.max(empty[len-1], ice[len-1]);
        }
    }
}
