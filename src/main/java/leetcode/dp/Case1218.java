package leetcode.dp;

import utils.Utils;

import javax.rmi.CORBA.Util;
import java.util.HashMap;
import java.util.Map;

/**
 * * 1218. 最长定差子序列
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 * 示例 1：
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 *
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 */
public class Case1218 {
    public static void main(String[] args) {
        Case1218 case1218 = new Case1218();
        int[] arr = new int[]{1,5,7,8,5,3,4,2,1};
        System.out.println(case1218.longestSubsequenceHash(arr, -2));

    }
    // 这个解法超时了 说是可以用hash的方法
    public int longestSubsequence(int[] arr, int difference) {
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] - arr[j] == difference) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        Utils.print1dArr(dp);
        return max;
    }


//    public int longestSubsequence(int[] arr, int difference) {
//        int ans = 0;
//        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
//        for (int v : arr) {
//            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
//            ans = Math.max(ans, dp.get(v));
//        }
//        return ans;
//    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/longest-arithmetic-subsequence-of-given-difference/solution/zui-chang-ding-chai-zi-xu-lie-by-leetcod-xkua/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int longestSubsequenceHash(int[] arr, int difference) {
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        Map<Integer, Integer> dpm = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int v = arr[i];
            if (dpm.containsKey(v)) {
                dp[i] = dpm.get(v);
            } else {
                dp[i] = 1;
            }
            dpm.put(v + difference, dp[i] + 1);
            max = Math.max(dp[i], max);

        }
        return max;
    }
}
