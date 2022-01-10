package leetcode.dp;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-08-23
 */
//53. 最大子序和
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//        示例 1：
//
//        输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//        输出：6
//        解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//        示例 2：
//        输入：nums = [1]
//        输出：1
//        示例 3：
//
//        输入：nums = [0]
//        输出：0
//        示例 4：
//
//        输入：nums = [-1]
//        输出：-1
//        示例 5：
//
//        输入：nums = [-100000]
//        输出：-100000
public class Case53 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] nums = new int [] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int length = nums.length;
            int [] max = new int [length];
            if(nums.length == 1) return nums[0];
            max[0] = nums[0];
            int maxNow = max[0];
            for (int i=1; i<length; i++) {
                max[i] = Math.max(nums[i], max[i-1] + nums[i]);
                maxNow = Math.max(maxNow, max[i]);
            }
            return maxNow;
        }
    }
}


