package leetcode.tree;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-05
 */

//将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
//
//        对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Case426 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

}
