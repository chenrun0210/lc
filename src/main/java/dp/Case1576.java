package dp;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-01
 */
//1567. 乘积为正数的最长子数组长度
//给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
//
//        一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
//
//        请你返回乘积为正数的最长子数组长度
//        输入：nums = [1,-2,-3,4]
//        输出：4
//        解释：数组本身乘积就是正数，值为 24 。
//
//        输入：nums = [0,1,-2,-3,-4]
//        输出：3
//        解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
//        注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
//
//        输入：nums = [-1,-2,-3,0,1]
//        输出：2
//        解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
public class Case1576 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {0,1,-2,-3,-4};
        System.out.println(solution.getMaxLen(nums));
    }

    static class Solution {
        public int getMaxLen(int[] nums) {
            int[] maxPositive = new int[nums.length];// 走到i,nums i参与运算,成绩为正数的最长长度 0不是正数
            int[] maxNegative = new int[nums.length];// 走到i,nums i参与运算,乘积为负数的最长长度 0不是负数
            maxPositive[0] = nums[0] > 0 ? 1 : 0;
            maxNegative[0] = nums[0] < 0 ? 1 : 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > 0) {
                    maxPositive[i] = maxPositive[i - 1] + 1;
                    maxNegative[i] = maxNegative[i - 1] > 0 ?  maxNegative[i - 1] + 1 : 0;
                    // 乘积为负数的情况： 如果全是正数，就不该加一 ，所以要判定，之前的maxNegative[i - 1]是不是大于0
                }
                if (nums[i] == 0) {
                    maxNegative[i] = 0;
                    maxPositive[i] = 0;
                }
                if (nums[i] < 0) {
                    maxPositive[i] = maxNegative[i - 1] > 0 ? maxNegative[i - 1] + 1 : 0;
                    maxNegative[i] = maxPositive[i - 1] + 1;
                }
            }

            for (int i = 0; i < maxPositive.length; i++) {
                System.out.print(maxPositive[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < maxNegative.length; i++) {
                System.out.print(maxNegative[i] + " ");
            }
            System.out.println();


            int maxLen = maxPositive[0];
            for (int i = 0; i < maxPositive.length; i++) {
                maxLen = Math.max(maxLen, maxPositive[i]);
            }
            return maxLen;
        }
    }
}
