package leetcode.doublepointer;

import utils.Utils;

//283. 移动零
//        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//        请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//        示例 1:
//        输入: nums = [0,1,0,3,12]
//        输出: [1,3,12,0,0]
//        示例 2:
//
//        输入: nums = [0]
//        输出: [0]
public class Case283 {
    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        Case283 case283 = new Case283();
        case283.moveZeroes(nums);
        Utils.print1dArr(nums);
    }

    public void moveZeroes1(int[] nums) {
        int len = nums.length;
        for (int z = 0; z < len ; z++) {
            if (nums[z] != 0) continue;
            int p = z + 1;
            while (p < len && nums[p] == 0) {
                p++;
            }
            if (p < len) {
                int t = nums[z];
                nums[z] = nums[p];
                nums[p] = t;
            }
        }
    }
    //标准答案
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/move-zeroes/solution/yi-dong-ling-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
