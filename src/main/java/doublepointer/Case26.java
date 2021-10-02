package doublepointer;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-10-02
 * 26. 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 *
 *
 *
 */
public class Case26 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int slow = 1; // slow位置的值，需要被覆盖
        int fast = 1;
        // 初始  slow和fast都为1，
        // 如果  1 和 0 不相等，那么slow会被替换为fast，nums[1] = nums[1], 0 不动
        // 如果  1 和 0 相等，那么fast就往后走了，slow还是1，是需要被下一个不同的元素给覆盖的位置
        for (fast = 1; fast < len; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
