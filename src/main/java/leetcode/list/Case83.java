package leetcode.list;

import common.ListNode;

/**
 * * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列*
 * * * * * *
 */
public class Case83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur!=null) {
            ListNode next = cur.next;
            if(next==null) break;
            if (cur.val == next.val) {
                cur.next = next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
