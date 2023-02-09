package leetcode.list;

import common.ListNode;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-13
 * 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 */
public class Case82 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(1,
                                        new ListNode(1,
                                                new ListNode(1, new ListNode(1, null)))))));
        Case82 case82 = new Case82();
        case82.deleteDuplicates1(head);

    }
    // Case 83
    //输入：head = [1,1,2]
    //输出：[1,2]
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode fast = dummyHead;
        while (fast.next != null && fast.next.next!=null) {
            if (fast.next.val == fast.next.next.val) {
                fast.next.next = fast.next.next.next; // 如果相等，
                // 1. 把fast.next.next节点
                // 2. fast节点此时是不需要往后移动的，因为后续的有可能还会相等
            }else {
                fast = fast.next;
            }
        }
        return dummyHead.next;
    }
    // case 82
    //输入：head = [1,2,3,3,4,4,5]
    //输出：[1,2,5]  重复的直接不要了
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;  // 需要记录下来这个值，后面连着的这个值的都要删掉
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;  // 这里需要把next节点也删掉，接在cur后面
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }



    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(0);   // 这里直接建立一个空节点就好了，不用去关联原来的节点
        ListNode cur = head;
        while(cur!=null) {
            ListNode curNext = cur.next;  // 一定需要先记录下来  原来cur的next位置，因为cur插入之后next就变了
            ListNode dhNext = dummyHead.next;
            dummyHead.next = cur;
            cur.next = dhNext;
            cur = curNext;
        }
        return  dummyHead.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode start = dummyHead;
        ListNode end = head;
        for (int i = 0; i < m; i++) {
            start = start.next;
            end = end.next;
        }
        for (int j = 0; j < n - m; j++) {
            ListNode endNext = end.next;
            ListNode startNext = start.next;

            end.next= endNext.next;

            start.next = endNext;
            endNext.next = startNext;
        }
        return dummyHead.next;
    }
}
