package leetcode.dp;

import java.util.Arrays;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 *
 * 输入：m = 3, n = 3
 * 输出：6
 */
public class Case62 {

    public static void main(String[] args) {
        Case62 case62 = new Case62();
        System.out.println(case62.uniquePaths(3,2));
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; // leetcode.dp[x][y] : 表示从0，0  到 (x,y)有几种走法
        Arrays.fill(dp[0], 1);
        for (int j = 0; j < m; j++) {
            dp[j][0] = 1;
        }

        for(int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 0 0 0
     * 0 0 0
     * 0 0 0
     */
}
