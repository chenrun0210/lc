package leetcode.hot;

import common.TreeNode;

/**
 * 经典题目*
 * * 124. 二叉树中的最大路径和
 * 困难
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 *                                   10
 *                          9                         20
 *                 n             n             15            7
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 */
public class Case124 {

    private int maxSum = Integer.MIN_VALUE;

    // 这里一定是要新写一个函数的 ，在去递归的过程里面，把max算出来
    //
    public int maxPathSum(TreeNode root) {
        singleMax(root);
        return maxSum;
    }

    // 这是一个节点往下的最大的path 的 和
    public int singleMax(TreeNode root){
        if (root == null) return 0;
        // 递归计算左、右子树 的最大的 pathSum值
        int maxLeft = Math.max(singleMax(root.left),0);
        int maxRight = Math.max(singleMax(root.right), 0);

        int curValue = root.val;
        curValue += maxLeft + maxRight;
        maxSum = Math.max(maxSum, curValue);
        // 返回节点的最大贡献值
        // 这三句话其实和这个递归没关系，就是在遍历的过程中把左边 +  右边 + 根的最大值算出来而已

        return root.val + Math.max(maxLeft, maxRight);
    }


}
