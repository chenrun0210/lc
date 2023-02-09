package leetcode.doublepointer;

import utils.Utils;

/**
 * 189. 轮转数组
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class Case189 {
    public static void main(String[] args) {
        Case189 case189 = new Case189();
        int[] nums = {0,1,2,3,4,5};
        case189.rotate(nums, 2);
        Utils.print1dArr(nums);
    }
    // 思路  翻转2次  0,1,2,3,4,5  右移2次  翻转的时候用到了双指针
    //              5,4,3,2,1,0  然后  5，4 翻转   3,2,1,0 再翻转
    //              4,5|0,1,2,3
    public  void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        reverse(nums,0, nums.length-1);
//        Utils.print1dArr(nums);
        int rk = k % nums.length;
        reverse(nums,0, rk-1);
        reverse(nums,rk, nums.length-1);
    }

    // 右边移动一位
    public void rotate(int[] nums) {
        int len = nums.length;
        // 循环移动,[0 - [len-1]]  0 -> 0 + k      len - 1 ->  (len-1 + k - len)
        int last = nums[len - 1];
        for (int i = len - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = last;
    }


}
