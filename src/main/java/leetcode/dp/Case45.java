package leetcode.dp;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-08-23
 */


//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
//
//        数组中的每个元素代表你在该位置可以跳跃的最大长度。
//        你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
//        假设你总是可以到达数组的最后一个位置。
//        示例 1:
//
//        输入: nums = [2,3,1,1,4]
//        输出: 2
//        解释: 跳到最后一个位置的最小跳跃数是 2。
//        从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//        示例 2:
//
//        输入: nums = [2,3,0,1,4]
//        输出: 2
public class Case45 {
    public static void main(String[] args) {
        int [] nums = new int[] {2,3,0,1,4};
        Solution solution = new Solution();
        System.out.println(solution.jump(nums));
    }
}

class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        int end = 0; // 上一次的最远范围
        int maxPosition = 0; // 本次的最远范围
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]); // 当前能跳的最远位置
            if (i == end) { // 上一次的范围遍历完了，无论如何要进行下一次跳跃了
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}