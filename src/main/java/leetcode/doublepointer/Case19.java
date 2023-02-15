package leetcode.doublepointer;


import common.ListNode;

/*
   19. 删除链表的倒数第 N 个结点
   给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
   示例 1：
   输入：head = [1,2,3,4,5], n = 2
   输出：[1,2,3,5]
   示例 2：
   输入：head = [1], n = 1
   输出：[]
   示例 3：
   输入：head = [1,2], n = 1
   输出：[1]

 */
public class Case19 {
    public static void main(String[] args) {
        Case19 case19 = new Case19();
        int[] a = new int[]{1};
        ListNode head = new ListNode(a);
        System.out.println(case19.removeNthFromEnd(head, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);  // 一定要加头节点，不然删除第一个节点的时候没法操作
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        int i = 0;
        while (fast.next != null) {
            fast = fast.next;
            i++;
            if (i > n) {
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
