package list;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-10
 * 删除倒数第N个节点
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

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
