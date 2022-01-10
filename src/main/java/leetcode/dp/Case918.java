package leetcode.dp;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-08-23
 */

//918. 环形子数组的最大和  -  整体移除最小的一段剩下的一段在环里也是连续的
//        给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
//        在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
//        此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，
//        不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
//        示例 1：
//
//        输入：[1,-2,3,-2]
//        输出：3
//        解释：从子数组 [3] 得到最大和 3
//        示例 2：
//
//        输入：[5,-3,5]
//        输出：10
//        解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
//        示例 3：
//
//        输入：[3,-1,2,-1]
//        输出：4
//        解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
public class Case918 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, 3, -2};
        Solution solution = new Solution();
        System.out.println(solution.maxSubarraySumCircular(nums));
    }


    static class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int length = nums.length;
            int[] max = new int[length];
            if (nums.length == 1) return nums[0];
            max[0] = nums[0];
            int maxNow = max[0];
            int sum = nums[0]; // 所有元素的和
            for (int i = 1; i < length; i++) {
                max[i] = Math.max(nums[i], max[i - 1] + nums[i]);
                maxNow = Math.max(maxNow, max[i]);
                sum += nums[i];
            }

            int pre = 0;
            int minNow = 0;
            for (int i = 1; i < length - 1; i++) {
                pre = Math.min(nums[i], pre + nums[i]);
                minNow = Math.min(minNow, pre);
            }

            System.out.println("max:" + maxNow);
            System.out.println("min:" + minNow);
            System.out.println("sum:" + sum);
            return Math.max(maxNow, sum - minNow);  // 最大的和  或者  和-最小的和
        }


    }
}
