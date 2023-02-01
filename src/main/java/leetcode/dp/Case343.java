package leetcode.dp;


/**
 * 343. 整数拆分
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * n = 3
 * 3 = 1+2  1*2 = 2
 * <p>
 * n = 4
 * 4 = 2 + 2 2*2 =4
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 */
public class Case343 {

    public static void main(String[] args) {
        Case343 case343 = new Case343();
        System.out.println(case343.integerBreak(10));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int a = Math.max(j, dp[j]);
                int b = Math.max(i - j, dp[i - j]);
                dp[i] = Math.max(dp[i], a * b);
            }
        }
        return dp[n];
    }
}
