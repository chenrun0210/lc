package leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * * 646. 最长数对链
 * 给你一个由 n 个数对组成的数对数组 pairs ，其中 pairs[i] = [lefti, righti] 且 lefti < righti 。
 * 现在，我们定义一种 跟随 关系，当且仅当 b < c 时，数对 p2 = [c, d] 才可以跟在 p1 = [a, b] 后面。我们用这种形式来构造 数对链 。
 * 找出并返回能够形成的 最长数对链的长度 。
 * 你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * 示例 1：
 *
 * 输入：pairs = [[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4] 。
 * 示例 2：
 *
 * 输入：pairs = [[1,2],[7,8],[4,5]]
 * 输出：3
 * 解释：最长的数对链是 [1,2] -> [4,5] -> [7,8] 。
 *
 * 跟300的区别在于这个题是可以乱序的，不是序列
 * * * *
 */
public class Case646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int len = pairs.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    if (dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
