package leetcode.hot;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Case199 {

    /*
199. 二叉树的右视图
中等
相关标签
相关企业
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
示例 1：
输入：root = [1,2,3,null,5,null,4]
输出：[1,3,4]
解释：
示例 2：
输入：root = [1,2,3,4,null,null,null,5]
输出：[1,3,4,5]
解释：
示例 3：
输入：root = [1,null,3]
输出：[1,3]
示例 4：
输入：root = []
输出：[]
 */
    public List<Integer> rightSideView(TreeNode root) {
        // 层次遍历的。每一层的最右边的那个
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return ans;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int nums = queue.size();
            for (int i = 0; i < nums; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

                if (i == nums - 1) {
                    ans.add(cur.val);
                }

            }
        }
        return ans;
    }
}
