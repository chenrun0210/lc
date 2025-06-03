package leetcode.binsearch;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 经典题目* *
 */

public class Case35 {
    public static void main(String[] args) {
        Case35 case35 = new Case35();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(case35.searchInsert(nums, target));
    }


    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int flag = 0;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;   // 以mid为准
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                high = mid - 1;
                flag = 0;   // 如果nums[mid]比目标值大； 那就应该插入到mid位置
            } else {
                low = mid + 1;
                flag = 1;   // 如果nums[mid]比目标值小； 那就应该插入到mid + 1 的位置
            }
        }
        return mid + flag;
    }
}
