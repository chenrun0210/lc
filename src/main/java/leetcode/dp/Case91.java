package leetcode.dp;


/** 解码方法 和 爬楼梯有点像
 * 一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 * <p>
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 * <p>
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * 示例 4：
 * <p>
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 */
public class Case91 {
    /**
     * 一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
     * <p>
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     **/
    public static void main(String[] args) {
        String s = "102";
        Case91 case91 = new Case91();
        int r = case91.numDecodings(s);
        System.out.println(r);
    }

    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        // leetcode.dp[1] 表示 s的第一个字符组成的串能有几种解法
        // leetcode.dp[2] 表示 s的前2个字符组成的串能有几种解法。
        // 所以应该返回dp[len], s的全部元素
        dp[0] = 1;
        // leetcode.dp[0]
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            int last1 = s.charAt(i - 1) - '0'; // charAt从 0 开始，所以i-1其实是s的第i个元素
            int last2 = s.charAt(i - 2) - '0';
            int last2Sum = 10 * last2 + last1;
            boolean sumRight = (last2Sum >= 1 && last2Sum <= 26);
            if (last1 == 0) {
                dp[i] = sumRight ? dp[i - 2] : 0;
            } else {
                dp[i] = dp[i - 1]   // 如果s的第i个元素不为0，那至少可以从dp[i-1] 得来
                        + (sumRight && last2 > 0 ? dp[i - 2] : 0);  // 考虑从dp[i-2]得来的情况
                // sumRight 很关键，符合sum的范围才能从 n-2 走
                // last2 > 0  对sumRight的补充，因为sum会忽略n-2值为0的情况,
                // 因为出现  02，03 的情况，是不能直接从n-2走的， 02，03不匹配
            }
        }
        return dp[len];
    }
}
