package common;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.Utils;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Object val) {
        this.val = (Integer) val;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(this);

        } catch (Exception e) {
            return super.toString();

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

    public static void main(String[] args) {
        Integer[] nums = {2, 1, 3, null, 4, null, 7, null, null, null, null};
        TreeNode a = TreeNode.createTreeNode(nums);
        System.out.println(a);

        Integer[] r = TreeNode.levelTraversal(a);
        Utils.print1dArr(r);
    }

}
