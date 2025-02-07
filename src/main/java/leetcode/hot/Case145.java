package leetcode.hot;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*

代码
代码
测试用例
测试结果
测试结果
145. 二叉树的后序遍历
简单
给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
示例 1：
输入：root = [1,null,2,3]
输出：[3,2,1]
解释：
示例 2：
输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]
输出：[4,6,7,5,2,9,8,3,1]
解释：
示例 3：
输入：root = []
输出：[]
示例 4：
输入：root = [1]
输出：[1]
 */
public class Case145 {
    // 后序的是  后根    左 右 根
    // 也是2种思路  栈 + 递归

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null; // 记录上一个访问的节点
        TreeNode current = root; // 用于 遍历左子树 + 入栈  的操作
        // current（当前遍历的节点）和 node（从栈中弹出的节点）
        while (current != null || !stack.isEmpty()) {
            // 先遍历到最左端，并将沿途节点入栈
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // 取出栈顶节点（当前需要判断是否可以访问）
            TreeNode node = stack.pop();
            //现在需要确定的是 是否有右子树，或者右子树是否访问过
            //如果没有右子树，或者右子树访问完了，也就是上一个访问的节点是右子节点时
            //说明可以访问当前节点
            if (node.right == null || prev == node.right) {
                // 右子树为空 或 右子树已访问，访问当前节点
                // node.right==null   --最左的节点，且没有右子树           可访问它
                // prev==node.right   --有右子树，但已经访问了 左右根的书序  可以访问它
                ans.add(node.val);
                prev = node; // 更新上次访问的节点
            } else {
                // 右子树未访问，需要先处理右子树，当前节点重新入栈
                stack.push(node);

                current = node.right;
            }
        }
        return ans;
    }

}
