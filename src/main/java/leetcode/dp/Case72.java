package leetcode.dp;

import utils.Utils;

/**
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class Case72 {
    public static void main(String[] args) {
        Case72 case72 = new Case72();
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(case72.minDistance(str1, str2));
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        // dp[i][j] 表示word1[0-i]  到word2[0-j]的标记距离
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        //  qw   qewr
        for (int i = 1; i < len1 + 1; i++) {
            char char1 = word1.charAt(i-1);
            for (int j = 1; j < len2 + 1; j++) {
                char char2 = word2.charAt(j-1);
                if (char1 == char2) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] =Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1]+1), dp[i-1][j-1]+1);
                }
            }
        }
        Utils.print2dArr(dp);
        return dp[len1][len2];
    }
}
