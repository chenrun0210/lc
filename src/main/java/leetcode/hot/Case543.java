package leetcode.hot;

import common.TreeNode;

/*

543. 二叉树的直径
简单
给你一棵二叉树的根节点，返回该树的 直径 。

二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。

两节点之间路径的 长度 由它们之间边数表示。
示例 1：
输入：root = [1,2,3,4,5]
输出：3
解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
示例 2：

输入：root = [1,2]
输出：1
提示：

树中节点数目在范围 [1, 104] 内
-100 <= Node.val <= 100
 */
public class Case543 {
    // 每个节点
    // 左子树的深度 + 右子树的最大深度
    // 的最大值 就是了
    // 在递归求深度的过程里，加一个判断max的逻辑就可以了
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }

    // 计算节点的深度
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归计算左、右子树深度
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        // 更新直径：左子树深度 + 右子树深度
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // 返回当前节点的深度
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
