package leetcode.hot;

import common.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

import static common.TreeNode.createTreeNode;

/**
 * * 236. 二叉树的最近公共祖先
 * 中等
 * 相关标签

 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 *                     3
 *              5            1
 *            6   2       0   8
 *          n  n 7  4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 */
@Slf4j
public class Case236 {



    public static void main(String[] args) {
        Integer[] nums =  new Integer[] {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = createTreeNode(nums);
        TreeNode no7 = root.left.right.left;
        List<TreeNode> pathList = findPathIterative(root, no7);
        log.info("pathList;{}", pathList);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = findPathIterative(root, p);
        List<TreeNode> pathQ = findPathIterative(root, q);

        int i = 0;
        while (i < pathP.size() && i < pathQ.size() && pathP.get(i) == pathQ.get(i)) {
            i++;
        }

        return pathP.get(i - 1);
    }
    // 找到从 root 到 target 的路径，然后存在List<TreeNode>
    private static List<TreeNode> findPathIterative(TreeNode root, TreeNode target) {
        if (root == null) return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        stack.push(root);
        parentMap.put(root, null); // 根节点没有父节点

        // DFS 直到找到目标节点
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == target) {
                break;
            }
            if (node.left != null) {
                parentMap.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                stack.push(node.right);
            }

        }
        // 构建路径
        LinkedList<TreeNode> path = new LinkedList<>();
        TreeNode cur = target;
        while (cur != null) {
            path.addFirst(cur);
            // 这里是添加到队列的头部
            cur = parentMap.get(cur);
        }
        return path;
    }
}
