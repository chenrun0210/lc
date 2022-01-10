package leetcode.tree;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-23
 */
public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}