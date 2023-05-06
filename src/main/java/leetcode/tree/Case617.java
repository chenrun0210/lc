package leetcode.tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 617. 合并二叉树
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 * 示例 1：
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * 示例 2：
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 * 提示：
 * <p>
 * 两棵树中的节点数目在范围 [0, 2000] 内
 * -104 <= Node.val <= 104
 */
public class Case617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {  // 如果两个节点都为空，返回空节点
            return null;
        } else if (t1 == null) {  // 如果t1为空，返回t2的节点
            return t2;
        } else if (t2 == null) {  // 如果t2为空，返回t1的节点
            return t1;
        } else {  // 如果两个节点都不为空，将它们的值相加，并将结果放入t1节点中
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);  // 合并t1和t2的左子树
            t1.right = mergeTrees(t1.right, t2.right);  // 合并t1和t2的右子树
            return t1;
        }
    }

    public static Integer[] levelTraversal(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> nums = new LinkedList<>();
        queue.offer(root);
        nums.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                nums.offer(null);
                continue;
            }

            if (cur.left != null) {
                queue.offer(cur.left);
                nums.offer(cur.left.val);
            } else {
                nums.offer(null);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                nums.offer(cur.right.val);
            } else {
                nums.offer(null);
            }
        }
        return nums.toArray(new Integer[0]);
    }

    // 层次遍历还原二叉树，必须包括空节点
    public static TreeNode createTreeNode(Integer[] nums) {
        //Object[] a ={1,2,3,null,4};
        int len = nums.length;
        if (len == 0 || nums[0] == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);
        int i = 1;
        while (i < nums.length) {
            TreeNode node = queue.poll();
            if (node != null) {
                node.left = (nums[i] == null) ? null : new TreeNode(nums[i]);
                queue.offer(node.left);
                i++;
                if (i < nums.length) {
                    node.right = (nums[i] == null) ? null : new TreeNode(nums[i]);
                    queue.offer(node.right);
                    i++;
                }
            }
        }
        return root;
    }
}
