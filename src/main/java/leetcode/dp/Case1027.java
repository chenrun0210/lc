package leetcode.dp;

import utils.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * * 1027. 最长等差数列
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
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
        // dp[i][j] 表示nums[i] 和 nums[j] 作为结尾的最长等差子序列的长度，其中 0 ≤ i < j < n
        int res = 2;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2); // 任意两个数都是等差数列， 所以dp全部设为2
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) { // 选定2个数 做结尾，往前倒， 找到构成等差的所有，然后比长度
                int diff = nums[j] - nums[i];
                for (int k = i - 1; k >= 0; k--) { // 这个思路好  最清晰
                    if (nums[k] == nums[i] - diff) {
                        dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                        break;
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
