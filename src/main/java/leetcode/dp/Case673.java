package leetcode.dp;

import utils.Utils;

import javax.rmi.CORBA.Util;

//673. 最长递增子序列的个数
//        给定一组 个未排序的整数数nums ， 返回最长递增子序列的个数 。
//        注意 这个数列必须是 严格 递增的。
//             [1,3,5]
//             1  [1,3,5]
//             [1,3,5,4]
//             2  [1,3,5]   [1,3,4]
//        示例 1:
//        输入: [1,3,5,4,7]
//        输出: 2
//        解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
//        示例 2:
//        输入: [2,2,2,2,2]
//        输出: 5
//        解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
//    hard
public class Case673 {
    public static void main(String[] args) {
        Case673 case673 = new Case673();
        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        Utils.print1dArr(nums);
        System.out.println(case673.findNumberOfLIS(nums));
    }

    public int findNumberOfLIS(int[] nums) {
        //dl[i] = y; 以nums[i]结尾 的最长子序列的长度是 y
        //dp[i] = x; 以nums[i]结尾 的递增序列的个数是 x
        //dp[i+1] = ?   dp[i] dl[i] num[i+1]
        int len = nums.length;
        if (len == 1) return len;
        int[] dp = new int[len];
        int[] dl = new int[len];
        dp[0] = 1;
        dl[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            dl[i] = 1;
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dl[j] + 1 > dl[i]) {  // 新的最长的递增序列出现了
                        dl[i] = dl[j] + 1;
                        dp[i] = dp[j]; // 个数肯定是和dp[j]是一样的
                    }
                    else if (dl[j] + 1 == dl[i]) { // 和之前一样长  1 2 4 3 5 ； 考虑现在i = 4; j = 3; 此时dl[4] = 4(1,2,4,5);但是j=3 dl[3] = 3 3+1=dl[4]=5
                        // 说明接在nums[j]后面XXX35  和 上一个位置XXX45是一样长的  即 多出一种解法
                        dp[i] += dp[j];
                    }
                }
            }
            max = Math.max(max, dl[i]);
        }
//        System.out.println(max);
//        Utils.print1dArr(dl);
//        Utils.print1dArr(dp);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (dl[i] == max) ans += dp[i];
        }
        return ans;
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
            dp[i] = 1;
            for (int j = 0; j < i; j++) {   // 典型的要把之前的dp都遍历一边的情形
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxdp = Math.max(maxdp, dp[i]);
        }
        return maxdp;
    }
}
