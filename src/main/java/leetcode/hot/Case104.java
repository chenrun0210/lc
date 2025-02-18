package leetcode.hot;
/*
104. 二叉树的最大深度
简单
给定一个二叉树 root ，返回其最大深度。
二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
示例 1：

输入：root = [3,9,20,null,null,15,7]
输出：3
示例 2：

输入：root = [1,null,2]
输出：2
提示：
树中节点的数量在 [0, 104] 区间内。
-100 <= Node.val <= 100
 */


import common.TreeNode;

public class Case104 {
    public static void main(String[] args) {
        Case104 case104 = new Case104();
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1,null,2});
        int ans =  case104.maxDepth(root);
        System.out.println(ans);
    }



    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
