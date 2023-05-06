package leetcode.tree;

import common.TreeNode;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-07-06
 */
public class case654buildtreemaxroot {

    //    给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
    //
    //    二叉树的根是数组 nums 中的最大元素。
    //    左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
    //    右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
    //    返回有给定数组 nums 构建的 最大二叉树 。

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    public TreeNode build(int[] num, int start, int end) {
        if (end < start) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int pos = 0;
        for (int i = start; i <= end; i++) {
            if (num[i] > max) {
                max = num[i];
                pos = i;
            }
        }
        TreeNode root = new TreeNode(num[pos]);
        root.left = build(num, start, pos -1);;
        root.right = build(num , pos+1, end);
        return root;
    }

    public static void main(String[] args) {
        case654buildtreemaxroot case654buildtreemaxroot = new case654buildtreemaxroot();
        int [] nums = new int []{1,2,3,4,5};
        case654buildtreemaxroot.constructMaximumBinaryTree(nums);

    }
}
