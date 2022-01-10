package leetcode.bintree;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-05-07
 */
public class lianbioa {


    public static void main(String[] args) {
        lianbioa lianbioa = new lianbioa();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(node);
        ListNode reverseBetween = lianbioa.reverseBetweenMy(node, 1, 2);
        System.out.println(reverseBetween);

    }

    public ListNode reverseBetweenMy(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode start = dummyHead; // 有可能从第一个节点就开始反转；所以start要在head之前
        ListNode p = dummyHead.next; // 工作节点
        for (int i=1 ;i<m ;i++) { // start得是反转节点的前一个节点
            start = start.next;
            p = p.next;
        }
        // start 是反转的前一个节点，p初始紧接在start的后面的
        // p是正开始反转的那个节点
        // 每次将p后面的节点，插入到start的后面就好
        for (int j=0; j<n-m; j++) {
            ListNode endNext = p.next; // 获取p的下一个节点
            p.next = endNext.next; // p的next往后跳一位，endNext
            endNext.next = start.next; // endNext 接在start节点后面
            start.next = endNext; // endNext 接在start节点后面
        }
        return dummyHead.next;
    }

    public ListNode reverseBetweenStandard(ListNode head, int m, int n) {
        // 定义一个dummyHead, 方便处理
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 初始化指针
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        // 将指针移到相应的位置
        for(int step = 0; step < m - 1; step++) {
            g = g.next; p = p.next;
        }

        // 头插法插入节点
        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;
            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }





    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode q = new ListNode();
        ListNode p = new ListNode();
        p.next = head;
        q.next = p;
        ListNode start = head;
        ListNode headOfTempList = null;
        for (int i = 0; i < left; i++) {
            start = p;
            p = p.next;
        }
        for (int j = left; j <= right; j++) {
            ListNode next = p.next;
            p.next = headOfTempList;
            headOfTempList = p;
            p = next;
        }
        start.next = headOfTempList;
        ListNode temp = headOfTempList;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = p;
        return q.next.next;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
