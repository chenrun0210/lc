package leetcode.hot;

import common.ListNode;

/*
234. 回文链表
简单
给你一个单链表的头节点 head ，请你判断该链表是否为
回文链表
。如果是，返回 true ；否则，返回 false 。
示例 1：
输入：head = [1,2,2,1]
输出：true
示例 2：
输入：head = [1,2]
输出：false

 */
public class Case234 {

    public static void main(String[] args) {
        Case234 case234 = new Case234();
        ListNode head = new ListNode(new int[]{1,2,2,1});
        System.out.println(head);
        boolean a = case234.isPalindrome(head);
        System.out.println(a);

    }

    //思路是直接把原来的链表翻转，构造一个新的链表
    //但是要保证反转了之后原链表是不变的
    public boolean isPalindrome(ListNode head) {
        ListNode reverse = reverseListNode(head);
        ListNode h = head;
        ListNode p = reverse;
        while (h != null) {
            if (h.val != p.val) {
                return false;
            }
            h = h.next;
            p = p.next;
        }

        return true;
    }

    //1 2 3 4
    // d 1    p=2
    // d 2 1
    //
    public ListNode reverseListNode(ListNode head) {
        ListNode dummyHead = new ListNode();
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            ListNode copy = new ListNode(); // 代替p作为插入到dummyHead后面的那个节点
            copy.val = p.val;
//            copy.next = p.next;
            // 用一个copy 的node 来保证原来的链表是不动的

            copy.next = dummyHead.next;
            dummyHead.next = copy;
            p = next;
        }
        return dummyHead.next;
    }
}
