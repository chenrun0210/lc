package leetcode.hot;


import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
101. 对称二叉树
简单
给你一个二叉树的根节点 root ， 检查它是否轴对称。
示例 1：
输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：
输入：root = [1,2,2,null,3,null,3]
输出：false
提示：
是否轴对称？
           1
   2                2
3    4          4      3
   5   7      7   5

树中节点数目在范围 [1, 1000] 内
-100 <= Node.val <= 100

进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Case101 {

    public static void main(String[] args) {
        Case101 case101 = new Case101();
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3});

        System.out.println(case101.isSymmetricBTS(root));
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // 递归的思路
    // 先看root 的 left和right是否 相等
    // 在看  left.left  right.right 以及   left.right right.left是否相等
    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false; // 其中的一个为空 另一个不为空的情况  直接false
        return (left.val == right.val) // 2个都不为空，看是否相等
                && isMirror(left.left, right.right)  // 如果相等 递归 left.left, right.right 也应该是镜像
                && isMirror(left.right, right.left); // 如果相等 递归 left.right, right.left 也应该是镜像
    }

    // 迭代的办法： 用队列来存储节点
    // 层次遍历的时候  按照   left.left  right.right 以及   left.right right.left  的顺序入对立
    // 每次弹出2个元素  他们应该相等 或者都为空
    public boolean isSymmetricBTS(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode left = root.left;
        TreeNode right = root.right;

        queue.offer(left);
        queue.offer(right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            // 继续出队列就可以
            if (t1 == null || t2 == null || t1.val != t2.val) {
                return false;
            }
            if (t1.val == t2.val) {
                queue.offer(t1.left);
                queue.offer(t2.right);

                queue.offer(t1.right);
                queue.offer(t2.left);
            } else {
                return false;
            }
        }
        return true;
    }

//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root.left);
//        queue.offer(root.right);
//
//        while (!queue.isEmpty()) {
//            TreeNode t1 = queue.poll();
//            TreeNode t2 = queue.poll();
//
//            if (t1 == null && t2 == null) continue;
//            if (t1 == null || t2 == null || t1.val != t2.val) return false;
//
//            // 依次加入成对的节点
//            queue.offer(t1.left);
//            queue.offer(t2.right);
//            queue.offer(t1.right);
//            queue.offer(t2.left);
//        }
//        return true;
//    }

}
