package tree;

import java.util.LinkedList;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-01-06
 */


//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
//
//        返回转换后的单向链表的头节点。
//
//        注意：本题相对原题稍作改动
//
//         
//
//        示例：
//
//        输入： [4,2,5,1,3,null,6,0]
//        输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
//        提示：
//
//        节点数量不会超过 100000。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/binode-lcci
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Case17D12BiNode {

    private TreeNode list = new TreeNode(0);
    private TreeNode p = list;

    //    public TreeNode convertBiNode(TreeNode root) {
    //
    //        return convert(root);
    //    }

    public TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = convert(root.left);
        TreeNode right = convert(root.right);
        root.left = null;
        if (left == null) {
            root.right = right;
            return root;
        }
        TreeNode leftEnd = left;
        while (leftEnd.right != null) {
            leftEnd = leftEnd.right;
        }
        leftEnd.right = new TreeNode(root.val);
        leftEnd.right.right = right;
        return left;
    }


    /**
     * 递归中序遍历【就是中根序递归】
     */
    public void preOrderRecursion(TreeNode node) {
        if (node == null) //如果结点为空则返回
        {
            return;
        }
        System.out.println("1");
        preOrderRecursion(node.left);//访问左孩子
        p.left = null;
        p.right = new TreeNode(node.val); // 这里新创建一个node
        p = p.right;
        preOrderRecursion(node.right);//访问右孩子
        System.out.println("1");
    }


    public static void main(String[] args) {
        Case17D12BiNode mm = new Case17D12BiNode();
        Integer[] arr =
                new Integer[] {-24255,-1416866623,875916498,-1467271685,-935098308,90511200,1650278088,-2006998252,null,-1004522707,-47245,8,553233942,1541934908,1845248881,null,-1758650493,-1175542308,null,-730662,-42710,-406,98402,351943250,796328469,934723866,null,1727747380,2049674601,null,null,-1223928855,-1135520872,-4362279,-185321,null,-25845,-2537,-8,67,2931099,null,522360239,584091166,null,null,1031241928,null,null,null,null,null,null,null,null,-854884265,-3902582,-220260,-76074,-30736,null,-4926,-941,-263,1,47,36111,204993,76546792,null,null,null,null,993616165,null,null,-42580007,null,-1941592,-295887,null,null,-69598,null,null,-24008,null,-1777,-556,null,-218,-4,4,8,66,614,82247,141544,342081,73588469,null,null,null,-324509737,-6389610,null,null,-455311,null,null,-53546,null,null,null,null,-633,null,null,-19,-5,-4,1,6,null,12,null,null,311,861,39984,96404,132075,null,205851,2677726,30693635,null,-543884919,-97455328,-15836765,-4633934,-534555,null,-57079,null,null,null,-73,null,-6,null,null,null,null,3,null,7,8,42,75,null,797,947,null,null,null,null,null,null,null,null,960912,null,3457220,47202841,null,-372097062,-280544260,-62515243,null,-9619658,null,null,null,null,null,null,-95,-36,null,null,null,4,null,null,null,null,null,null,null,270,null,null,894,12371,404385,2056373,null,3471760,null,48893829,null,null,null,null,null,null,null,-6768842,null,-80,null,null,3,null,83,null,null,null,3903,34015,null,550091,null,null,null,6146986,null,null,-7346439,null,null,null,null,null,null,89,null,6369,null,null,541365,697687,null,9598322,null,null,null,null,4607,7582,409909,null,613480};
        TreeNode root = getTreeNode(arr);
        System.out.println(mm.convert(root));


    }

    private static TreeNode getTreeNode(Integer[] param) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int i = 1;
        TreeNode root = new TreeNode(param[0]);  // 根节点
        TreeNode current = null;
        Integer value = null;

        queue.add(root);
        while (i < param.length) {
            current = queue.poll();//从链表中移除并获取第一个节点
            value = param[i++];
            if (value != null) {
                TreeNode left = new TreeNode(value);
                current.left = left;//创建当前节点的左孩子
                queue.add(left); // 在链表尾部 左孩子入队
            }
            if (i < param.length) {
                value = param[i++];
                if (value != null) {
                    TreeNode right = new TreeNode(value);
                    current.right = right;//创建当前节点的右孩子
                    queue.add(right);// 在链表尾部 右孩子入队
                }
            }
        }
        return root;
    }
}



