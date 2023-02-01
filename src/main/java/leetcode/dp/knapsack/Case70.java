package leetcode.dp.knapsack;

import leetcode.dp.Case322;
import utils.Utils;

//70. 爬楼梯
//        假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//        示例 1：
//
//        输入：n = 2
//        输出：2
//        解释：有两种方法可以爬到楼顶。
//        1. 1 阶 + 1 阶
//        2. 2 阶
//        示例 2：
//        输入：n = 3
//        输出：3
//        解释：有三种方法可以爬到楼顶。
//        1. 1 阶 + 1 阶 + 1 阶
//        2. 1 阶 + 2 阶
//        3. 2 阶 + 1 阶
public class Case70 {
    public static void main(String[] args) {
        Case70 case70 = new Case70();
        int a = case70.climbStairs(3);
        System.out.println(a);
    }

    public int climbStairs(int n) {
        int[] steps = new int[]{1, 2};
        int[] dp = new int[n + 1];
        // dp[i] = x 表示爬到第i级阶梯有x种不同的方法
        // dp[i] = dp[i-step[j]]  0 <= j < steps.length
        // 初始化： dp[0] = 1  dp[coins[j]] = 1
        dp[0] = 1;

        for (int j = 0; j < steps.length; j++) {
            if (n >= steps[j]) dp[steps[j]] = 1;
        }
//        Utils.print1dArr(dp);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < steps.length; j++) {
                int step = steps[j];
                if (i > step && dp[i-step] !=0) { // 这里为什么不能等于 ？
                    dp[i] += dp[i - step];
                }
            }
        }
        return dp[n];
    }
}
