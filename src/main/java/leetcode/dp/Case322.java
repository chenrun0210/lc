package leetcode.dp;

import utils.Utils;

import java.util.Arrays;

/**
 * 322. 零钱兑换 --最少的硬币个数
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 */
public class Case322 {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        Case322 case322 = new Case322();
        int res = case322.coinChange(coins, amount);
        System.out.println(res);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // dp[i] 表示到达i所需的最少的硬币的个数
        // dp[i] =Math.min( dp[i-1], dp[i-2], dp[i-5]) + 1
        // 先默认全是-1
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                dp[coins[i]] = 1;
            }
        }
        Utils.print1dArr(dp);
        for (int i = 1; i <= amount; i++) {
            if (dp[i] != -1) continue;
            int tempMin = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if ((coins[j] <= i) // 硬币值需要小于 目标值  才允许通过； 不允许等于，
                        &&
                    (dp[i - coins[j]] != -1)  // 目标值-硬币值 的 那个位置一定是可以要是可以通过的
                ) {
                    tempMin = Math.min(dp[i - coins[j]] + 1, tempMin);
                    dp[i] = tempMin;
                }
            }

        }
        Utils.print1dArr(dp);
        return dp[amount];
    }
}
