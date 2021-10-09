package dp;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-10-04
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 */
public class Case5 {
    public static void main(String[] args) {
        Case5 case5 = new Case5();
        String s = "aaaaaa";
        System.out.println(case5.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1 || (len == 2 && s.charAt(0) == s.charAt(1))) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        //dp[i][j] 表示s的i - j 是否会回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = -1;
        String max = "";
        char[] charArray = s.toCharArray();
        // for (int start = 0; start < len; start++) {
        // 典型的错误写法
        // 第一轮：[0,0],[0,1],[0,2]  这三个长度不超过3，可借助dp[i][i]得到，或者比价s[i]和s[i+1]得到
        //        [0,3],[0,4],[0,5] 长度超过3的，dp[0][3]的时候，用到dp[1][2],但此时start = 0, dp[1][2]在第二轮计算中，此时并没有经过计算，是初始值false，导致计算出错
        // 第二轮：[1,1],[1,2],[1,3],[1,4],[1,5]

        for (int start = len - 1; start >= 0; start--) {
            //必须从末尾开始遍历，这样用到的值都是之前计算过的，
            // 第一轮：[5,5],
            // 第二轮：[4,4],[4,5]
            // 第三轮：[3,3],[3,4],[3,5]   以上三轮不存在长度超过3的,可借助dp[i][i]得到，或者比价s[i]和s[i+1]得到
            // 第四轮：[2,2],[2,3],[2,4],[2,5];   [2,5]会用到[3,4], [3,4]上一轮已经计算完毕了，不会出错
            for (int end = start; end < len; end++) {
                //长度为1的情况
                if (end - start == 0) {
                    dp[start][end] = true;
                }
                // 字符串长度为2的情况
                if (end - start == 1) {
                    if (charArray[start] == charArray[end]) {
                        dp[start][end] = true;
                    } else {
                        dp[start][end] = false;
                    }
                }
                // 字符串长度大于2的情况
                if (end - start > 1) {
                    if (charArray[start] == charArray[end]) {
                        dp[start][end] = dp[start + 1][end - 1];
                    }
                }
                if (dp[start][end]) {
                    if (maxLen <= end - start + 1) {
                        maxLen = Math.max(maxLen, end - start + 1);
                        max = s.substring(start, start + maxLen);
                    }
                }

            }
        }
        return max;
    }
}
