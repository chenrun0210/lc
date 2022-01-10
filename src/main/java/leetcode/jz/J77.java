package leetcode.jz;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-17
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 */
public class J77 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4,
                new ListNode(2,
                        new ListNode(1,
                                new ListNode(3))));
        J77 j77 = new J77();
        j77.sortList(head);
    }
    // 新建头结点的插入法 复杂度是 n*n
    public ListNode sortList(ListNode head) {
        ListNode result = new ListNode(0);// 结果列表的头结点
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            int val = cur.val;
            ListNode resCur = result;
            while (resCur.next != null && resCur.next.val < val) {
                resCur = resCur.next;
            }
            // 此时的resCur.next.val 是 > val的，val节点应该插入在resCur后面；
            cur.next = resCur.next;
            resCur.next = cur;
            cur = curNext;
        }
        return result.next;
    }
}
