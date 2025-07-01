package leetcode.hot;

import utils.Utils;

//75. 颜色分类
//中等
//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//必须在不使用库内置的 sort 函数的情况下解决这个问题。
//示例 1：
//
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
//示例 2：
//
//输入：nums = [2,0,1]
//输出：[0,1,2]
//n == nums.length
//1 <= n <= 300
//nums[i] 为 0、1 或 2
public class Case75 {


    //  我们可以统计出数组中 0,1,2 的个数，再根据它们的数量，重写整个数组。这种方法较为简单，也很容易想到，而本题解中会介绍两种基于指针进行交换的方法。

    // 2,2,0,1,1,0
    //
    public void sortColors(int[] nums) {
        int len = nums.length;
        int pos = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                // 交换0到最前面
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;

                pos++;//第一个非0的位置
            }
        }
        //第一个非0的位置后面继续交换1
        for (int i = pos; i < len; i++) {
            if (nums[i] == 1) {
                // 交换1到0后面
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;

                pos++;
            }
        }

    }

    public static void main(String[] args) {
        Case75 case75 = new Case75();
        int[] nums = {2,2,0,1,1,0};
        case75.sortColors(nums);
        Utils.print1dArr(nums);
    }
}
