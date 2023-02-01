package leetcode.dp.knapsack;

import utils.Utils;

//518. 零钱兑换 II --凑成总金额的硬币组合数
//        给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
//        请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
//        假设每一种面额的硬币有无限个。
//        题目数据保证结果符合 32 位带符号整数。
//        示例 1：
//        输入：amount = 5, coins = [1, 2, 5]
//        输出：4
//        解释：有四种方式可以凑成总金额：
//        5=5
//        5=2+2+1
//        5=2+1+1+1
//        5=1+1+1+1+1
//        示例 2：
//        输入：amount = 3, coins = [2]
//        输出：0
//        解释：只用面额 2 的硬币不能凑成总金额 3 。
//        示例 3：
//        输入：amount = 10, coins = [10]
//        输出：1
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/coin-change-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Case518 {

    public static void main(String[] args) {
        Case518 case518 = new Case518();
        int[] coins = new int[]{1, 2, 5};
        int amount = 5;
        System.out.println(case518.change(amount, coins,1));
    }

    /**
     * 以为数组遍历硬币的方式，不会产生重复的组合
     * @param amount
     * @param coins
     * @param a
     * @return
     */
    public int change(int amount, int[] coins, int a) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 金额
        for (int i = 0; i < coins.length; i++) { //对于每一个硬币，
            for (int j = coins[i]; j <= amount; j++) { // 每一个硬币选定的情况下，去遍历金额，如果可能组成，一定是比coins[i]大的金额
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    /**
     * 用二维数组来定义子问题
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        // coins = [1, 2, 5] coins.length = 3
        // amount = 5
        int[][] dp = new int[coins.length + 1][amount + 1];
        // 子问题定义:
        // dp[i][j] 表示 拥有第i种硬币的时候  凑齐 金额 j 的总组合数     最后的答案dp[coin.length][amount]
        // dp[i][j] = dp[i-1][j]   没拥有第i种硬币，只用之前的种类就凑齐了金额i
        // + dp[i][j - coin[i]]    使用了第i种硬币，凑齐了 金额i-coin[i]的金额
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1; // 凑齐金额0的组合都是一种
            if (i < coins.length && amount >= coins[i - 1]) {
                dp[i][coins[i - 1]] = 1;
                // 凑齐金额=本面额  的组合数是1
            }
        }

        for (int amountCur = 1; amountCur <= amount; amountCur++) { // 金额为0的已经初始化了，这里金额从1开始
            for (int coinCur = 1; coinCur <= coins.length; coinCur++) {
                if (amountCur >= coins[coinCur - 1]) {
                    dp[coinCur][amountCur] =
                            dp[coinCur][amountCur - coins[coinCur - 1]]
                                    + dp[coinCur - 1][amountCur];
                } else
                    dp[coinCur][amountCur] = dp[coinCur - 1][amountCur];
            }
        }
        return dp[coins.length][amount];
    }

}
