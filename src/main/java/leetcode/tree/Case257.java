package leetcode.tree;

import common.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * * 257. 二叉树的所有路径
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：["1"]
 * 经典题目 *
 */
@Slf4j
public class Case257 {

    public static void main(String[] args) {
        Case257 case257 = new Case257();
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1,2,3,null,5});
        List<String> res = case257.binaryTreePaths(root);
        log.info("{}", res);
    }

    // 思路  先记录节点 -> 父节点的map; 然后获取
    public List<String> binaryTreePaths(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);

        List<TreeNode> leaf = new ArrayList<>();
        List<String> paths = new ArrayList<>();

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right!=null) {
                stack.push(cur.right);
                parentMap.put(cur.right, cur);
            }
            if (cur.left!=null) {
                stack.push(cur.left);
                parentMap.put(cur.left, cur);
            }

            if (cur.left == null && cur.right == null) {
                leaf.add(cur);
            }
        }
        for(TreeNode ele:leaf) {
            LinkedList<String> singlePath = new LinkedList<>();
            while (ele != null) {
                singlePath.addFirst(String.valueOf(ele.val));
                ele = parentMap.get(ele);
            }
            String path = String.join("->", singlePath);
            paths.add(path);
        }

        return paths;
    }
}
