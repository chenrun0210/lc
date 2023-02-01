package leetcode.dp;

import utils.Utils;

/**
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 */
public class Case279 {

    public static void main(String[] args) {
        Case279 case279 = new Case279();
        System.out.println(case279.numSquares2(13));
        System.out.println(case279.numSquares(13));
    }
    public int numSquares2(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/perfect-squares/solution/wan-quan-ping-fang-shu-by-leetcode-solut-t99c/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int numSquares(int n) {
        // dp[n] = x   和为 n 的完全平方数的最少数量  为  x。
        // dp[n] =  dp[n - i] + dp[i]  的最小值
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    dp[i] = 1;
                    break;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if(dp[i] == 1) continue;
            for (int j = 1; j < i ; j++) {
                    min = Math.min(min, dp[j] + dp[i - j]);
                dp[i] = min;
            }
        }
        return dp[n];
    }

}
