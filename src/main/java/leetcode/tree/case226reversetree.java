package leetcode.tree;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-07-05
 */

//翻转一棵二叉树。
//
//        示例：
//
//        输入：
//
//            4
//          /   \
//         2     7
//        / \   / \
//        1   3 6   9
//        输出：
//
//            4
//          /   \
//         7     2
//        / \   / \
//        9   6 3   1
public class case226reversetree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
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
