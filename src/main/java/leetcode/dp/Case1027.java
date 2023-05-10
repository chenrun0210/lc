package leetcode.dp;

import utils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * * 1027. 最长等差数列
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 *
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，
 * * 且 0 <= i1 < i2 < ... < ik <= nums.length - 1。
 * * 并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
 * 示例 1：
 * 输入：nums = [3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 示例 2：
 * 输入：nums = [9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * 示例 3：
 * 输入：nums = [20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 */
public class Case1027 {
    public static void main(String[] args) {
        Case1027 case1027 = new Case1027();
        int[] arr = {1,2,3,4,5};
        System.out.println(case1027.longestArithSeqLength(arr));
    }

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 2;
        for (int j = 0; j < n; j++) {// k i j
            map.put(nums[j], j);
            for (int i = 0; i < j; i++) {
                int target = 2 * nums[i] - nums[j];
                if (map.containsKey(target)) {
                    int k = map.get(target);
                    dp[j][k] = dp[i][j] + 1;
                    maxLen = Math.max(maxLen, dp[j][k]);
                }
            }
        }
        return maxLen;
    }
}
