package leetcode.doublepointer;

import utils.Utils;

/**
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class Case977 {

    public static void main(String[] args) {
        Case977 case977 = new Case977();
        int [] nums = {-4,-1,0,3,10};
        Utils.print1dArr(case977.sortedSquares(nums));
    }
    // 双指针  两头向中间靠拢
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int ans = len - 1;
        int low = 0, high = len - 1;
        while (low <= high) {
            int a = nums[low] * nums[low];
            int b = nums[high] * nums[high];
//            if (a == b) {
//                if (low == high) {
//                    result[ans] = a;
//                    break;
//                }
//                result[ans] = a;
//                ans--;
//                result[ans] = b;
//                ans--;
//                low++;
//                high--;
//            } else            // 注释掉的代码  多此一举   平方相等的情况下  也移动一边的指针就可以了，另一边不动和下一个指针的比较就行了
                if (a > b) {
                result[ans] = a;
                low++;
                ans--;
            } else {
                result[ans] = b;
                ans--;
                high--;
            }

        }
        return result;
    }
}
