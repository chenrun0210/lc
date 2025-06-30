//package leetcode;
////给你一个整数数组 nums，请你将该数组升序排列。
////你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。
//public class Case921 {
//
//    public int[] sortArray(int[] nums) {
//
//    }
//
//    public void quickSort(int[]nums, int left, int right){
//       if(left<right) {
//           int partition = partition(nums,left,right);
//           quickSort(nums, left, partition);
//           quickSort(nums, partition, right);
//
//       }
//
//
//
//    }
//    //left 到 right; 按哨兵位置；划分到左右两侧，并返回哨兵的最终位置
//    //比哨兵小的，移动到哨兵左侧 比哨兵大的移动扫右侧
//    //  4 2 5 1 3
//    //  2 4 5 1 3
//    //
//    public int partition(int[]nums, int left, int right) {
//        int sb = nums[left];
//
//        for (int i = left+1; i<= right; i++) {
//            if (nums[i] <= sb) {
//
//
//            } else {
//
//
//            }
//        }
//
//    }
//}
