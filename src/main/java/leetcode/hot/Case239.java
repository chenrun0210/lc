package leetcode.hot;

import utils.Utils;

import java.util.Deque;
import java.util.LinkedList;

/*
239. 滑动窗口最大值
        给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
        返回 滑动窗口中的最大值 。
        示例 1：
        输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        输出：[3,3,5,5,6,7]
        解释：
        滑动窗口的位置                最大值
        ---------------               -----
        [1  3  -1] -3  5  3  6  7      3
        1 [3  -1  -3] 5  3  6  7       3
        1  3 [-1  -3  5] 3  6  7       5
        1  3  -1 [-3  5  3] 6  7       5
        1  3  -1  -3 [5  3  6] 7       6
        1  3  -1  -3  5 [3  6  7]      7
        示例 2：
        输入：nums = [1], k = 1
        输出：[1]
*/
public class Case239 {

    public static void main(String[] args) {
        Case239 case239 = new Case239();

        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int[] result = case239.maxSlidingWindow(nums, 3);
        Utils.print1dArr(result);
    }

    /*
        需要一个单调的队列来存放最大值，使用linkedlist； 它也是一个双端队列，可以分别对对头对尾进行操作
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int maxNumsLen = len - k + 1;
        int[] maxNums = new int[maxNumsLen];
        Deque<Integer> dequeue = new LinkedList<>();
        //存当前窗口的下标， 下标对应的值需要，  单调递减 + 只包含当前窗口  过期的移走
        for (int i = 0; i < len; i++) { // 窗口就是 i-k+1  到  i
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[i] ) {
                dequeue.pollLast();
            }
            dequeue.offerLast(i);
            //存的是下标
            if (i >= k - 1 ) { // 这里才可以形成一个窗口； 窗口就是  窗口就是 i-k+1  到  i； 此时队列的头部就是现在的最大值
                int maxNowPosition = dequeue.peekFirst();
                if (maxNowPosition >= i-k+1 && maxNowPosition<=i) { //队列的头部 最大的值 正在窗口里面 ，  是一个正确的值
                    maxNums[i-k+1] = nums[maxNowPosition];
                } else { // 队列的头部 不在窗口里，是一个历史的值，需要把它弹出
                    while(dequeue.peekFirst() < i-k+1) {
                        dequeue.pollFirst();
                    }
                    maxNums[i-k+1] = nums[dequeue.peekFirst()];
                }
            }
        }
        return maxNums;
    }
}
