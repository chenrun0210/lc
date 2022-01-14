package leetcode.dp;

import static utils.Utils.print2dArr;

/**
 * 516. 最长回文子序列
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
        // leetcode.dp[i][j] = x 表示 s(i)(j)的最大回文序列的长度为x; i < j
        // leetcode.dp[i][j] = s.charAt(j) == s.charAt(i) ?   dp[i+1][j-1]  + 2  : max(dp[m][n] )  i < m<n < j
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        int max = dp[0][0];
        for (int i = len - 1; i >= 0; i--) { // 参考 leetcode.dp.Case5T2
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (Math.abs(i - j) <= 1) {  // 相邻的情况不依赖dp；
                        dp[i][j] = 2;
                    } else { // 不相邻的情况;依赖dp[m][n]；  i < m<n < j
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]); // 这个转化很离谱
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        print2dArr(dp);
        return max;
    }

    public static void main(String[] args) {
        String s = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew";
//        String s = "bbbab";
        System.out.println(new Case516().longestPalindromeSubseq(s));
    }
}
