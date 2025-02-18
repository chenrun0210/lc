package leetcode.hot;

import common.TreeNode;

import java.util.*;

/*
102. 二叉树的层序遍历
中等
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]
示例 2：
输入：root = [1]
输出：[[1]]
示例 3：

输入：root = []
输出：[]

 */
public class Case102 {


    // 层序遍历
    // 队列    在进行入队操作之前  每一层一个size  先用size进行判断  应该出队列的数量
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)  return ans;
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
