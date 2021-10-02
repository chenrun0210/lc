package doublepointer;

import java.util.Arrays;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-10-01
 * 259. 较小的三数之和
 * 给定一个长度为 n 的整数数组和一个目标值 target，
 * 寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
 * <p>
 * 示例：
 * <p>
 * 输入: nums = [-2,0,1,3], target = 2
 * 输出: 2
 * 解释: 因为一共有两个三元组满足累加和小于 2:
 * [-2,0,1]
 * [-2,0,3]
 */
public class Case259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target - nums[i]) {
                    sum += right-left;   // 每一个left 满足条件的个数是  right - left, 所以不是sum++，是sum += right-left; 然后left++
                    left++;
                } else if (nums[left] + nums[right] >= target - nums[i]) {
                    right--;
                }
            }
        }
        return sum;
    }
}
