package leetcode.hot;
/*
148. 排序链表
中等
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
示例 1：
输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2：
输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：
输入：head = []
输出：[]
 */

import common.ListNode;

public class Case148 {


    public static void main(String[] args) {
        Case148 case148 = new Case148();
        ListNode head = new ListNode(new int[]{-1, 5, 3, 4, 0});
        ListNode result = case148.sortListMerge(head);
        System.out.println(result);
    }

    /*
     用的归并的思路
     先分成左右2段
     递归排序左右  得到 2个有序的链表
     合并2个有序的链表
     */
    public ListNode sortListMerge(ListNode head) {
        if (head == null || head.next == null) return head;
        // 结束递归的条件

        // 第一步  先分成2段   2段要隔开   不一定要完全1/2
        ListNode slow = head, fast = head, beforeSlow = slow;
        while (fast != null && fast.next != null) {
            beforeSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        beforeSlow.next = null;
        // 此时  head  -> beforeSlow   slow -> end  2段链表
        ListNode left = sortListMerge(head);
        ListNode right = sortListMerge(slow);
        // 左右两边分别排序
        ListNode merge = merge2SortedListNode(left, right);
        //合并两个已经分别排好序的链表  他们有可能交叉 要一个位置一个位置地对比
        return merge;
    }


    ListNode merge2SortedListNode(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (left != null && right != null) {
            ListNode cur = new ListNode();
            if (left.val > right.val) {
                cur.val = right.val;
                right = right.next;
            } else {
                cur.val = left.val;
                left = left.next;
            }
            p.next = cur;
            p = p.next;
        }
        if (left != null) p.next = left;
        if (right != null) p.next = right;
        return dummy.next;
    }



    // 新建节点 插入法  往后走到该插入的位置  最后一个测试用例会超时
    public ListNode sortList(ListNode head) {
        ListNode newDummy = new ListNode();
        ListNode current = head;
        while (current != null) {
            ListNode p = newDummy;
            int value = current.val;
            while (p.next != null) {
                // 这里直接用next去判断 因为要保留 插入的current的前一个位置
                if (p.next.val >= value)
                    break;
                p = p.next;
            }
            // 这里找到插入位置的时候   超时了

            // 错误师范: p.next = new ListNode(current.val);
            // 这一步是要把current插入到 p.next后面，并且 p.next原有的链表是不能断的，是一个插入操作
            ListNode temp = p.next;
            p.next = new ListNode(current.val, temp);  // p.next一定是新建一个节点 而不是p.next=current
            current = current.next;
        }
        return newDummy.next;
    }
}
