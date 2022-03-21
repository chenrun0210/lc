package leetcode.dp;

import utils.Utils;

/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 */
public class Case1143 {
    public static void main(String[] args) {
        Case1143 case1143 = new Case1143();
//        String text1 = "bsbininm";
//        String text2 = "jmjkbkjkv";
        String text1 = "xaxx";
        String text2 = "a";
        System.out.println(case1143.longestCommonSubsequence(text1, text2));

    }


    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];
        // dp[i][j]; 表示text1[0-i]  和  text2[0-j] 的最长公共子序列的长度
        int max0 = 0;
        int max3 = 0;
        for (int i = 0; i < len1; i++) {
            if (text2.charAt(0) == text1.charAt(i)) {
                dp[i][0] = 1;
                max0 = 1;
            }
            dp[i][0] = max0;
            max3 = Math.max(max3, dp[i][0]);
        }
        int max1 = 0;
        for (int i = 0; i < len2; i++) {
            if (text1.charAt(0) == text2.charAt(i)) {
                dp[0][i] = 1;
                max1 = 1;
            }
            dp[0][i] = max1;
            max3 = Math.max(max3, dp[0][i]);
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                int max2 = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = max2;
                }
                max3 = Math.max(max3, dp[i][j]);
            }
        }
//        Utils.print2dArr(dp);
        return max3;
    }

    public int longestCommonSubsequenceStand(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
    // https://leetcode-cn.com/problems/longest-common-subsequence/solution/zui-chang-gong-gong-zi-xu-lie-by-leetcod-y7u0/
}
