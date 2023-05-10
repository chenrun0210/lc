package leetcode.dp;

import utils.Utils;

import static utils.Utils.print2dArr;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 */
public class Case300 {

    public static void main(String[] args) {
        Case300 case300 = new Case300();
//        int[] nums =  {10,9,2,5,3,7,101,18};
        int[] nums = {1 ,2 ,4 ,3 ,5, 4 ,7 ,2};
        System.out.println(case300.lengthOfLIS1(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 1) return 1;
        int[] dp = new int[len];
        // dp[i]表示以nums[i]结尾的字符串的最大上升序列的长度
        // dp[i]  dp[0] ... dp[i-1]; nums[i]
        dp[0] = 1;
        int maxdp = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = 1; // 这里必须是1 dp[i]表示的是以nums[i]结尾，最差的情况nums[i]是目前为止最小的数，自己开一的序列，所以一定是1，不是dp[i-1]
            for (int j = 0; j<i; j++) {   // 典型的要把之前的dp都遍历一边的情形
                if (nums[i]>nums[j]) {
                    dp[i] =Math.max(dp[i], dp[j] + 1);
                }
            }
            maxdp = Math.max(maxdp, dp[i]);
        }
        return maxdp;
    }

    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        Utils.print1dArr(dp);
        return maxans;
    }

}
