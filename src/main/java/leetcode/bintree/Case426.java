package leetcode.bintree;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-08
 */
//将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
//
//        对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
//
//        特别地，我们希望可以 就地 完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Case426 {
    class Node {
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

    ;

    static class Solution {
        // the smallest (first) and the largest (last) nodes
        Node first = null;
        Node last = null;

        public void helper(Node node) {
            if (node != null) {
                // left
                helper(node.left);
                // node
                if (last != null) {
                    // link the previous node (last)
                    // with the current one (node)
                    last.right = node;  // 把node节点连接在last的后面
                    node.left = last;
                } else {
                    // keep the smallest node
                    // to close DLL later on
                    first = node;
                }
                last = node;
                // right
                helper(node.right);
            }
        }

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            helper(root);
            // close DLL
            last.right = first;
            first.left = last;
            return first;
        }
    }

}
