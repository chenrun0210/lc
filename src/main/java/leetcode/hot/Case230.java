package leetcode.hot;

import common.TreeNode;

import java.util.*;

/*
230. 二叉搜索树中第 K 小的元素
中等
相关标签
相关企业
提示
给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
示例 1：
输入：root = [3,1,4,null,2], k = 1
输出：1
示例 2：
输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3
提示：
         5
    3         6
  2    4
1
树中的节点数为 n 。
1 <= k <= n <= 104
0 <= Node.val <= 104
进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */
public class Case230 {


    public static void main(String[] args) {
        Case230 case230 = new Case230();
        TreeNode treeNode = TreeNode.createTreeNode(new Integer[]{41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23});
        System.out.println(case230.kthSmallest(treeNode,1));
    }


    // 思路一  把 二叉搜索树 直接转化为升序的数组
    // 有点像  二叉树的 中序遍历的
    public int kthSmallest(TreeNode root, int k) {
        return inOrder(root).get(k-1);
    }


    // 直接中序遍历
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root ==null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> hasPushed = new HashSet<>();
        stack.push(root);
        hasPushed.add(root);

        while(!stack.isEmpty()) {
            TreeNode top = stack.peek();
            // 这里是peek  不是pop  这里只是入栈  出栈的是时候再pop
            if (top.left != null && !hasPushed.contains(top.left)) {
                stack.push(top.left);
                hasPushed.add(top.left);
                // top.left = null;
                // 这一步很关键，一定要断开left， 避免重复  入栈
                // 也可以有一个Set<TreeNode> hasPushed 来判断，已经入栈的就别再重复入栈了
                continue;
            }
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            if(cur.right!=null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }


    public int kthSmallest1(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solutions/1050055/er-cha-sou-suo-shu-zhong-di-kxiao-de-yua-8o07/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
