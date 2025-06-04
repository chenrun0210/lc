package leetcode.tree.traversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
144. 二叉树的前序遍历
简单

给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
示例 1：
输入：root = [1,null,2,3]
输出：[1,2,3]
解释：
示例 2：
输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]
输出：[1,2,4,5,6,7,3,8,9]
解释：
示例 3：
输入：root = []
输出：[]
示例 4：
输入：root = [1]
输出：[1]
进阶：递归算法很简单，你可以通过迭代算法完成吗？
经典题目
 */
public class Case144 {

    // 前序的是  前根   根 左 右
    // 也是2种思路  栈 + 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            // 1. 弹出当前节点，并访问它
            TreeNode node = stack.pop();
            result.add(node.val);

            // 2. 先压入右子树，再压入左子树（保证左子树先遍历）
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return result;
    }


    // 递归
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

}
