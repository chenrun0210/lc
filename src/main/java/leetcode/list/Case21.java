package leetcode.list;

import common.ListNode;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-10
 * 合并两个有序链表
 */
public class Case21 {
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
