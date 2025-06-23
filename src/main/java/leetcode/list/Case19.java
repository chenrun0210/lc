package leetcode.list;

import common.ListNode;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-10
 * 删除倒数第N个节点
 * 经典题目*
 */
public class Case19 {

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyHead = new ListNode(0, head);
            ListNode end = head;
            ListNode start = dummyHead;
            for (int i = 0; i < n; i++) {
                end = end.next;
            }
            while (end != null) {
                start = start.next;
                end = end.next;
            }
            start.next = start.next.next;
            return dummyHead.next;
        }
    }
}
