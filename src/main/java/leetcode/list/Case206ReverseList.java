package leetcode.list;

import common.ListNode;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-12
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Case206ReverseList {
    public static void main(String[] args) {
        Case206ReverseList case206 = new Case206ReverseList();
        ListNode head = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        case206.reverseList(head);
    }
    // 头结点插入法逆转单链表，就记住这一个就够了
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = head;
        while (cur != null) { //把cur连接到dummyHead后面
            ListNode next = cur.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            cur = next;
        }
        return  dummyHead.next;
    }
}
