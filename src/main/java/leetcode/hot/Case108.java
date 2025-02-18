package leetcode.hot;

import common.TreeNode;

import java.util.Arrays;

/*
108. 将有序数组转换为二叉搜索树
简单

给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
平衡二叉搜索树。

 平衡二叉树 是指该树所有节点的左右子树的高度相差不超过 1。

示例 1：
输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

示例 2
输入：nums = [1,3]
输出：[3,1]
解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。

提示：

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 按 严格递增 顺序排列

0 1 2 3 4 5 6
 */
public class Case108 {
    // 用的递归的算法
    // 按照   mid  分成2段 递归构造左子树和右子树 再拼接起来
    // 边界  起始点  大于  结束点
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0, end = nums.length - 1;
        if(start >  end) return null;
        int mid = (start + end)/2;

        TreeNode root = new TreeNode(nums[mid]);
        int[] left = Arrays.copyOfRange(nums, start, mid );
        int[] right = Arrays.copyOfRange(nums, mid + 1, end + 1);

        TreeNode ltree = sortedArrayToBST(left);
        TreeNode rtree = sortedArrayToBST(right);

        root.left = ltree;
        root.right = rtree;

        return root;
    }

}
