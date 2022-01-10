package leetcode.dp;

/**
 *516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * 示例 1：
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 * 提示：
 */
public class Case516 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        // leetcode.dp[i][j] = x 表示 s(i)(j)的最大回文序列的长度为x
        // leetcode.dp[i][j] =  :
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        return 0;
    }
}
