package bintree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    static class Solution {
        public Node treeToDoublyList(Node root) {
            if (root == null) return root;
            Stack<Node> stack = new Stack<>();
            List<Node> queue = new ArrayList<>();
            Node cur = root;
            //1 先使用中序遍历，将节点保存到队列中去
            while(!stack.isEmpty()||cur!=null){
                //先找到左边尽头
                while(cur!=null){
                    stack.push(cur);
                    cur=cur.left;
                }
                //再弹出来记录处理
                cur=stack.pop();
                queue.add(cur);
                cur=cur.right;
            }
            // 中序遍历 的 非递归实现
            return root;
        }
    }
}
