package leetcode.hot;

import common.TreeNode;

/*
98. 验证二叉搜索树
中等
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左
子树
只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1：
输入：root = [2,1,3]
输出：true
示例 2：
输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。
树中节点数目范围在[1, 104] 内
-231 <= Node.val <= 231 - 1
5,4,6,null,null,3,7
 */


public class Case98 {
    // 第一反应  又是递归
    // 这里是左子树的所有节点都要小于 根节点 所以不能只是左子树的根节点 小于当前的根节点

    public boolean isValidBSTWrong(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) return true;
        if (root.right != null && root.right.val <= root.val) return false;
        if (root.left != null && root.left.val >= root.val) return false;
        if (root.left != null && root.right != null && root.left.val < root.val && root.right.val > root.val) return true; // 这样是错的
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);
        return left & right;
    }
    /*
思路：上下界递归法
对每个节点，设定 上下界：
左子树：值必须 小于当前节点。
右子树：值必须 大于当前节点。
递归检查：
如果当前节点的值不在上下界范围内，则 不是 BST。
继续递归检查左右子树：
左子树的上界更新为 当前节点值。
右子树的下界更新为 当前节点值。
终止条件：
遍历完整棵树，且所有节点都满足条件，则是 有效 BST。
     */

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }


    // 递归检查每个节点是否满足 BST 条件
    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        // 空节点，返回 true
        if (node == null) {
            return true;
        }

        int val = node.val;

        // 检查当前节点值是否在上下界范围内
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        // 递归检查右子树，更新下界为当前节点值
        if (!isValidBST(node.right, val, upper)) {
            return false;
        }
        // 递归检查左子树，更新上界为当前节点值
        if (!isValidBST(node.left, lower, val)) {
            return false;
        }

        // 当前节点满足条件
        return true;
    }
}
