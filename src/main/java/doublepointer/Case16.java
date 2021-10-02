package doublepointer;

import java.util.Arrays;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-10-02
 *
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class Case16 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int bestSum = 0;// 最接近的和
        int minSub = Integer.MAX_VALUE;// bestSum与target的差的绝对值
        int start;
        Arrays.sort(nums); // 先进行排序
        for (start = 0; start < len - 2; start++) {
            int left = start + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[start] + nums[left] + nums[right];
                int sub = target - sum;
                if (Math.abs(sub) < minSub) {
                    minSub = Math.abs(sub);
                    bestSum = sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return bestSum;
    }
}
