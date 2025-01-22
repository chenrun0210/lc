package leetcode.hot;

import utils.Utils;

/*
238. 除自身以外数组的乘积
中等
相关标签
相关企业
提示
给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
示例 1:
输入: nums = [1,2,3,4]
输出: [24,12,8,6]
示例 2:
输入: nums = [-1,1,0,-3,3]
输出: [0,0,9,0,0]
提示：
2 <= nums.length <= 105
-30 <= nums[i] <= 30
输入 保证 数组 answer[i] 在  32 位 整数范围内
 */
public class Case238 {

    public static void main(String[] args) {
        Case238 case238 = new Case238();
        int[] nums = {-1,1,0,-3,3};
        int[] result = case238.productExceptSelf(nums);
        Utils.print1dArr(result);
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len];
        // pre[i] 是 nums[i]的前缀的成绩
        pre[0] = 1;
        int[] sub = new int[len];
        // sub[i] 是 nums[i]的后缀的成绩
        sub[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for (int j = len - 2; j >= 0; j--) {
            sub[j] = sub[j + 1] * nums[j + 1];
        }
        int [] result = new int[len];
        for (int i = 0; i<len;i++) {
            result[i] = pre[i] * sub[i];
        }

        return result;
    }
}
