package leetcode.list;

import java.util.Stack;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-12
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Case25 {
    public static void main(String[] args) {
        Case25 case25 = new Case25();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        case25.reverseKGroup(head, 3);

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        ListNode tail = head;
        while (p != null) {
            int i;
            for (i = 0; i < k; i++) {  // 这里要K个一组往栈里送
                if (p == null) {
                    break;
                } else {
                    p = p.next;
                }
            }
            if (i != k) {
                stack.clear();
                temp.next = tail.next;
            } else {
                for (int j = 0; j < k; j++) {  // 这里要K个一组往栈里送
                    if (tail == null) {
                        break;
                    } else {
                        stack.push(tail);
                        tail = tail.next;
                    }
                }
                while (!stack.isEmpty()) {
                    ListNode pop = stack.pop();
                    temp.next = pop;
                    temp = pop;
                    temp.next = null;
                }
            }
        }
        return dummyHead.next;
    }

}
