package leetcode.list;

import common.ListNode;

import java.util.PriorityQueue;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-10、
 * 合并K个升序链表
 */
public class Case23 {
    // 优先队列的方法
    class Status implements Comparable<Status> {
        int val;
        ListNode node;

        Status(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Status> queue = new PriorityQueue<Status>();
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.node;
            tail = tail.next;
            if (f.node.next != null) {
                queue.offer(new Status(f.node.next.val, f.node.next));
            }
        }
        return head.next;
    }




    public ListNode mergeLists(ListNode[] lists) {
        ListNode ans = new ListNode();
        for (int i=0; i<lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode tempList = new ListNode(0);
        ListNode tempCur = tempList;
        while (cur1!=null && cur2!= null) {
            if (cur1.val <= cur2.val) {
                tempCur.next = cur1;
                cur1 = cur1.next;
            } else{
                tempCur.next = cur2;
                cur2 = cur2.next;
            }
            tempCur = tempCur.next;
        }
        if (cur1!=null) tempCur.next = cur1;
        if (cur2!=null) tempCur.next = cur2;
        return tempList.next;

    }
}
