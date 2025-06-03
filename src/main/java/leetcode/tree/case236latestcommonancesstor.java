package leetcode.tree;

import common.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）    。”
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-07-15
 * 经典题目
 * * *
 */
public class case236latestcommonancesstor {
    // 在root 中 ，找到p,q的最近祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        // 这里是假设了root 【p, q其中之一】、要么是就一定是【最近的祖先】
        // 此时有2中情况，
        // root就是他们的祖先，如果是p, 假设是q一定在这个root的子树里面，则root是他们的 【最近的祖先】
        // root不是祖先，但是就是p； 此时的话q是一定是不在root的子树里面的，那一定是在root的另一侧
        TreeNode left  = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 再递归从root的左右子树找，left 要么是  【最近的祖先】；要么是p, q其中之一
        // 如果 left 是  【最近的祖先】，那么right一定就是空的
        // 如果 left 是  【p, q其中之一】，那么right一定不是空的，且，此时最近的祖先一定就是  left 的  parent,也就是当前的root
        if(right!=null && left!=null) return root;
        return left == null ? right : left;
    }
}
