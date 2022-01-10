package leetcode.dp;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-08-31
 */
//152. 乘积最大子数组
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//        示例 1:
//        输入: [2,3,-2,4]
//        输出: 6
//        解释: 子数组 [2,3] 有最大乘积 6。
//        示例 2:
//
//        输入: [-2,0,-1]
//        输出: 0
//        解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/maximum-product-subarray
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Case152 {
    static class Solution {
        public int maxProduct(int[] nums) {
            if (nums.length == 1) return nums[0];
            int [] maxPro = new int[nums.length];// 需要同时记录最大和最小，最大的判定方法也不一样
            int [] minPro = new int[nums.length];
            maxPro[0] = nums[0];
            minPro[0] = nums[0];
            int max = maxPro[0];
            for (int i=1; i<nums.length; i++) {
                maxPro[i] = Math.max(Math.max(maxPro[i-1]*nums[i], minPro[i-1]*nums[i]),nums[i]);
                minPro[i] = Math.min(Math.min(maxPro[i-1]*nums[i], minPro[i-1]*nums[i]), nums[i]);
                max = Math.max(max, maxPro[i]);
            }
            return max;
        }
    }
}
