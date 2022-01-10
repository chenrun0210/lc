package leetcode.tree;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-07-06
 */

//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//        展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
//        展开后的单链表应该与二叉树 先序遍历 顺序相同。
public class case114flatten {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;  // 是原来的left节点
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
