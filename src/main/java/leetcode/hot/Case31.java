package leetcode.hot;

import utils.Utils;

//31. 下一个排列
//中等
//相关标签
//premium lock icon
//相关企业
//整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
//
//例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
//整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
//
//例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
//类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
//而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
//给你一个整数数组 nums ，找出 nums 的下一个排列。
//
//必须 原地 修改，只允许使用额外常数空间。
public class Case31 {
    public void nextPermutation(int[] nums) {
        //1 2   3 100 99 6 2      下一个排列是1 2   6 2 3 99 100
        //      .        .        第一个3（从后往前看，第一个相邻的递减序列）是需要交换的位置，需要交换为6(从后往前第一个大于3的)， 然后把后面的序列全部逆序
        //1 2   6 100 99 3 2   ->  1 2   6 2 3 99 100

        // 其实可以这样思考，因为题目要找下一个排列
        // 那么排序其实有规律的，就像我们枚举排列的时候都是从小到大的
        // 那么其实我们从后往前看，只要找到第一个降序的序列，比如 1 2 3 5 4 的 5 3 是降序的
        // 但找到5 3 之后，我们并不能直接交换5 3的位置，因为这样不是下一个排列
        // 所以我们可以从5到后面的数进行从小到大的排序即4 5，
        // 将这个升序序列中找到第一个大于3的数即4，交换就好了， 得到1 2 4 3 5

        // 其实就是从后往前找，找到第一个降序的序列
        int len = nums.length;
        int start = len - 2;
        while (start >= 0 && nums[start] >= nums[start + 1]) {
            start--;
        }

        System.out.println("start:" + start);
        // 1,2,3,4,3,2,1    start 2  是数字3的位置
        if (start == -1) {
            // 整体已经全部是递减的了，整体都需要逆序
        } else {
            // 从后往前，找到第一个大于 nums[start]的位置,这里一定会有一个比他大的 ， 不然就是整体递减了，在if的分支里面
            for (int j = len - 1; j > start; j--) {
                if (nums[j] > nums[start]) {
                    swapArray(nums, start, j);
                    break;
                }
            }
        }

        reverseArray(nums, start+1);

    }

    // 逆序的典型写法
    public void reverseArray(int[] nums, int start){
        int left = start;
        int right = nums.length - 1;

        while(left < right) {
            swapArray(nums, left, right);
            left++;
            right--;
        }

    }

    public void swapArray(int[] nums, int left, int right){
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }


    public static void main(String[] args) {
        Case31 case31 = new Case31();
        int[] nums = {1,2,3,4,5};
        case31.nextPermutation(nums);
        Utils.print1dArr(nums);
    }
}
