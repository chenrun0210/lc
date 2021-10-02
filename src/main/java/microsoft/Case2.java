package microsoft;

import java.util.List;

import list.ListNode;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-10-01
 * 两个数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * tips: 都是逆序，个位在最左侧
 * carry：进位
 * sum = val1 + val2 + carry;
 * carry = sum / 10;
 * int val = sum % 10;
 *
 * 加法的话，直接给短的那个链表，补齐为0
 *
 *
 */
public class Case2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(
                9, new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9, null))))
        )));

        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,null))));

        Case2 case2 = new Case2();

        ListNode result = case2.addTwoNumbers(l1,l2);
    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode head = new ListNode();
        dummyHead.next = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode temp = new ListNode(val);
            head.next = temp;
            head = head.next;
            if (l1 != null) {   // 这里同步后退
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            head.next = new ListNode(carry);
        }
        return  dummyHead.next.next;
    }
}
