package leetcode.hot;

import common.TreeNode;

import java.util.*;

import static common.TreeNode.createTreeNode;

/*
94. 二叉树的中序遍历
简单
给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
示例 1：
输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：
输入：root = []
输出：[]
示例 3：
输入：root = [1]
输出：[1]
提示：
树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

经典题目
1,2,3,4,5,null,8,null,null,6,7,9
            1
       2            3
   4      5      n     8
 n   n  6  7         9
 */
public class Case94 {
    // 有2种思路  递归 和 栈
    // 中序的是  中根  左 根 右
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,null,8,null,null,6,7,9};
        Case94 case94 = new Case94();
        List<Integer> result = case94.inorderTraversal(createTreeNode(nums));
        System.out.println(result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root; // 用于遍历左子树
        // current（当前遍历的节点）和 node（从栈中弹出的节点）
        while (current != null || !stack.isEmpty()) {
            // 1. 先将所有左子节点入栈
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 2. 取出栈顶节点（当前需要访问的节点）  栈顶的元素一定是做左侧的元素了 ，可以进行访问
            TreeNode node = stack.pop();
            result.add(node.val);

            // 3. 进入右子树
            current = node.right;
        }

        return result;
    }

}
