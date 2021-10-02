package list;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-16
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 */
public class Case86 {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode();
        ListNode lessDummy = new ListNode(0, less);
        ListNode more = new ListNode();
        ListNode moreDummy = new ListNode(0, more);
        ListNode cur = head;
        while(cur!=null) {
            if (cur.val>=x) {
                more.next = cur;
                more = more.next;
            }else {
                less.next = cur;
                less = less.next;
            }
            cur = cur.next;
        }
        less.next = moreDummy.next.next;
        more.next = null;
        return lessDummy.next.next;
    }
}
