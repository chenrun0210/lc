package leetcode.hot;

import java.util.HashSet;
import java.util.Set;

//128. 最长连续序列
//        给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//        请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//        示例 1：
//        输入：nums = [100,4,200,1,3,2]
//        输出：4
//        解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//        示例 2：
//        输入：nums = [0,3,7,2,5,8,4,6,0,1]
//        输出：9
//        提示：
//        0 <= nums.length <= 10^5
//        -10^9 <= nums[i] <= 10^9
public class Case128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> used = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;

        for (int num : set) {
            if (!used.contains(num)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
                used.add(num);
            }
        }
        return longestStreak;
    }
}
