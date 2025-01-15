package leetcode.system;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/** leetcode 239 题  用的单调队列
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-05-20
 */
public class WindowMax {
    public static void main(String[] args) {
        WindowMax windowMax = new WindowMax();
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        int[] a = windowMax.maxSlidingWindow(num, k);

        Arrays.stream(a).forEach(System.out::println);
    }

    //    解释过程中队列中都是具体的值，方便理解，具体见代码。
    //    初始状态：L=R=0,队列:{}
    //    i=0,nums[0]=1。队列为空,直接加入。队列：{1}
    //    i=1,nums[1]=3。队尾值为1，3>1，弹出队尾值，加入3。队列：{3}
    //    i=2,nums[2]=-1。队尾值为3，-1<3，直接加入。队列：{3,-1}。此时窗口已经形成，L=0,R=2，result=[3]
    //    i=3,nums[3]=-3。队尾值为-1，-3<-1，直接加入。队列：{3,-1,-3}。队首3对应的下标为1，L=1,R=3，有效。result=[3,3]
    //    i=4,nums[4]=5。队尾值为-3，5>-3，依次弹出后加入。队列：{5}。此时L=2,R=4，有效。result=[3,3,5]
    //    i=5,nums[5]=3。队尾值为5，3<5，直接加入。队列：{5,3}。此时L=3,R=5，有效。result=[3,3,5,5]
    //    i=6,nums[6]=6。队尾值为3，6>3，依次弹出后加入。队列：{6}。此时L=4,R=6，有效。result=[3,3,5,5,6]
    //    i=7,nums[7]=7。队尾值为6，7>6，弹出队尾值后加入。队列：{7}。此时L=5,R=7，有效。result=[3,3,5,5,6,7]
    //
    //    作者：hanyuhuang
    //    链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/shuang-xiang-dui-lie-jie-jue-hua-dong-chuang-kou-2/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast(); // 弹出队列尾部，peekXXXX是获取但是不弹出，pollXXXX是获取并弹出
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效, 如果小于的话说明队列首位不在当前窗口期，需要将它删除，其实就相当于窗口后移了
            if (queue.peek() <= i - k) {
                queue.poll(); // 这是弹出队列的首位
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i  >= k - 1) {
                result[i - k + 1] = nums[queue.peek()];
            }
        }
        return result;
    }
//
//    思路与算法
//
//    对于「最大值」，我们可以想到一种非常合适的数据结构，那就是优先队列（堆），其中的大根堆可以帮助我们实时维护一系列元素中的最大值。
//
//    对于本题而言，初始时，我们将数组  nums 的前 kk 个元素放入优先队列中。每当我们向右移动窗口时，我们就可以把一个新的元素放入优先队列中，
//    此时堆顶的元素就是堆中所有元素的最大值。然而这个最大值可能并不在滑动窗口中，在这种情况下，
//    这个值在数组 \textit{nums}nums 中的位置出现在滑动窗口左边界的左侧。因此，当我们后续继续向右移动窗口时，这个值就永远不可能出现在滑动窗口中了，
//    我们可以将其永久地从优先队列中移除。
//
//    我们不断地移除堆顶的元素，直到其确实出现在滑动窗口中。此时，堆顶元素就是滑动窗口中的最大值。
//    为了方便判断堆顶元素与滑动窗口的位置关系，我们可以在优先队列中存储二元组 (\textit{num}, \textit{index})(num,index)，
//    表示元素 \textit{num}num 在数组中的下标为 \textit{index}index。
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int[] maxSlidingWindowPri(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }


}
