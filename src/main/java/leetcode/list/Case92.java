package leetcode.list;

import common.ListNode;
import utils.Utils;

/**
 * * 92. 反转链表 II
 * *  给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class Case92 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode leftDummy = new ListNode(0, head);
        // 需要定位到插入位置的 前一个位置
        // 有可能从第一个位置就开始插入
        ListNode temp = leftDummy;
        int start = 0;
        while (start < left - 1) {
            leftDummy = leftDummy.next;
            start = start + 1;
        }

        ListNode cur = leftDummy.next;
        // 插入到leftDummy的后面即可
        if (cur == null || cur.next == null) return head;

        while (start < right - 1) {
            // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> NULL   2, 4
            // 每一次循环  都把cur.next作为目标， 插入到leftDummy的后面

            ListNode target = cur.next;
            // 找到target; 需要处理它
            cur.next = target.next;
            // cur 接上原有的位置往后移动
            target.next = leftDummy.next;
            // target.next续上leftDummy的原有next
            leftDummy.next = target;
            // 移动target

            start++;
        }

        return temp.next;
    }


    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{1, 2, 3, 4, 5, 6, 7,};
        ListNode head = Utils.listNode(nodes);
        System.out.println(head);
        ListNode node = reverseBetween(head, 2, 4);
        System.out.println(node);
    }
}
