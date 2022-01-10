package leetcode.dp;

import static utils.Utils.print2dArr;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * dabab
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * <p>
 * 输入
 * "babad"
 * 输出
 * "ba"
 * 预期结果
 * "bab"
 */
public class Case5T2 {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len]; // leetcode.dp[i][j] = 1 表示s从i到j是回文串； 0表示不是
        // leetcode.dp[i][j] = 1   leetcode.dp[i+1][j-1] = 1 且 s(i) = s(j) 从两边往中间递归
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        int max = Integer.MIN_VALUE;
        int start = 0;
        for (int i = len - 1; i >= 0; i--) { // 从下往上遍历
            for (int j = i; j < len; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (Math.abs(i - j) <= 1) {  // 相邻的情况不依赖dp；
                        dp[i][j] = 1;
                    } else if (dp[i + 1][j - 1] == 1) { // 不相邻的情况依赖dp[i + 1][j - 1]；
                        dp[i][j] = 1;
                    }

                    if (dp[i][j] == 1 && Math.abs(i - j) > max) {
                        max = Math.abs(i - j);
                        start = i;
                    }
                }

            }
        }

        return s.substring(start, start + max + 1);
    }

    /**
     * 最长的公共子串
     *
     * @param s1
     * @param s2
     * @return
     */
    public String longestCommonString(String s1, String s2) {
        int row = s1.length();
        int col = s2.length();
        int[][] dp = new int[row][col];
        int endS1 = 0;
        int endS2 = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        // 巧妙的设计
                    }
                    if (dp[i][j] > maxLen) {
                        maxLen = Math.max(maxLen, dp[i][j]);
                        //长度
                        endS1 = i;
                        //S1最后的位置
                        endS2 = j;
                        //S2最后的位置
                    }
                }
            }
        }
        print2dArr(dp);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("maxLen:" + maxLen + " endS1:" + endS1 + " endS2:" + endS2);
        return s2.substring(endS2 - maxLen + 1, endS2 + 1);
    }

    public static void main(String[] args) {
        Case5T2 case5T2 = new Case5T2();
        String a = "aacabdkacaa";
        System.out.println(case5T2.longestPalindrome(a));
    }
}
