package leetcode.jz;

import java.util.PriorityQueue;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-16
 * 给定一个链表数组，每个链表都已经按升序排列。
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vvXgSW
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J78 {
    static class Status implements Comparable<Status> {
        private ListNode node;

        public Status(ListNode node) {
            this.node = node;
        }
        public ListNode getNode() {
            return node;
        }
        public void setNode(ListNode node) {
            this.node = node;
        }
        @Override
        public int compareTo(Status o) {
            return this.node.val - o.node.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;
        PriorityQueue<Status> queue = new PriorityQueue<>();
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null){
                queue.offer(new Status(lists[i]));
            }
        }
        while (!queue.isEmpty()) {
            ListNode min = queue.poll().getNode();
            if (min.next != null) {
                queue.offer(new Status(min.next));
            }
            cur.next = min;
            cur = cur.next;
        }
        return dummy.next;
    }
}
