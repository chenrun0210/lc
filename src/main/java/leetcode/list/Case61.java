package leetcode.list;

import common.ListNode;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-12
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * [循环往后移动，后面的补充到前面]
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 */
public class Case61 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,
                null)))));
//        ListNode head = new ListNode(1, new ListNode(2, null));
        Case61 case61 = new Case61();
        ListNode res = case61.rotateRight(head, 1);
    }

    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode count = head;
        while (count != null) {
            count = count.next;
            size++;
        }
        if (size == 0) {
            return head;
        }
        k = k % size;
        if (k == 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(0, head);
        ListNode end = dummyHead.next;
        ListNode start = dummyHead;
        ListNode fast = dummyHead;
        for (int i = 0; i <= k; i++) {
            fast = fast.next;
        }
        while(fast!=null) {
            fast = fast.next;
            start = start.next;
            end = end.next;
        }
        start.next = null;
        ListNode p = end;
        while (p != null && p.next != null) {
            p = p.next;
        }
        p.next = dummyHead.next;
        dummyHead.next = end;
        return dummyHead.next;
    }
}
