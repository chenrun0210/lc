package leetcode.hot;

import common.TreeNode;

import java.util.Arrays;

public class Case105 {
    /*
   105. 从前序与中序遍历序列构造二叉树
   中等
   给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
   输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
   输出: [3,9,20,null,null,15,7]
   输入: preorder = [-1], inorder = [-1]
   输出: [-1]
   提示:
   preorder 和 inorder 均 无重复 元素
   inorder 均出现在 preorder
   preorder 保证 为二叉树的前序遍历序列
   inorder 保证 为二叉树的中序遍历序列
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int rootIndexInorder = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                rootIndexInorder = i;
                break;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndexInorder);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndexInorder + 1, inorder.length);

        int leftLength = rootIndexInorder; //左子树的长度

        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, 1 + leftLength);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, 1 + leftLength, preorder.length);

        Integer rootNode = preorder[0];

        TreeNode root = new TreeNode(rootNode);
        root.left = buildTree(leftPreOrder, leftInorder);
        root.right = buildTree(rightPreOrder, rightInorder);
        return root;
    }
}
