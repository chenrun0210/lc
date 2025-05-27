import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ShopeeSRALeetcode {


    public static void main(String[] args) {
        ShopeeSRALeetcode shopeeSRALeetcode = new ShopeeSRALeetcode();
    }
    /*
    437. 路径总和 III
        中等
        给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
        路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
        示例 1：
        输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
        输出：3
        解释：和等于 8 的路径有 3 条，如图所示。
        示例 2：
        输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        输出：3

        思路； 前缀和  map(node,value) value: 当前node到root的距离
        map（node1, value） -  map(node2, value)  node1 到 node2的距离，如果这个距离是targetSum && node1 node2在一条路径上 ， 那就是符合的
    */
    
    /*
我们定义节点的前缀和为：由根结点到当前结点的路径上所有节点的和。我们利用 先序遍历二叉树，记录下根节点 root 到当前节点 p 的路径上除当前节点以外所有节点的前缀和，
在已保存的路径前缀和中查找是否存在前缀和刚好等于当前节点到根节点的前缀和 curr 减去 targetSum。
对于空路径我们也需要保存预先处理一下，此时因为空路径不经过任何节点，因此它的前缀和为 0。
假设根节点为 root，我们当前刚好访问节点 node，则此时从根节点 root 到节点 node 的路径（无重复节点）刚好为 root→p1
 →p2→…→pk→node，此时我们可以已经保存了节点 p1,p2,p3,…,pk的前缀和，并且计算出了节点 node 的前缀和。
假设当前从根节点 root 到节点 node 的前缀和为 curr，则此时我们在已保存的前缀和查找是否存在前缀和刚好等于 curr−targetSum。假设从根节点 root 到节点 node 的路径中存在节点 pi
到根节点 root 的前缀和为 curr−targetSum，则节点 pi+1到 node 的路径上所有节点的和一定为 targetSum。
我们利用深度搜索遍历树，当我们退出当前节点时，我们需要及时更新已经保存的前缀和。

作者：力扣官方题解
链接：https://leetcode.cn/problems/path-sum-iii/solutions/1021296/lu-jing-zong-he-iii-by-leetcode-solution-z9td/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int pathSum(TreeNode root, int targetSum) {
        // 前缀和 HashMap，记录路径和出现的次数
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        // 初始化前缀和：路径和为 0 的出现 1 次（即从根节点开始的路径）
        prefixSumMap.put(0L, 1);

        // 深度优先搜索
        return dfs(root, 0, targetSum, prefixSumMap);
    }

    // DFS 方法：currentSum 为当前路径和
    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumMap) {
        // 递归终止条件：节点为空
        if (node == null) {
            return 0;
        }
        // 更新当前路径和
        currentSum += node.val;

        // 计算满足条件的路径数量   这里是任意一个以前路径上的节点  -  当前节点 （怎么保证是以前的路径？  因为后续是遍历的左右子树）
        int numPaths = prefixSumMap.getOrDefault(currentSum - targetSum, 0);
        // 更新前缀和 map
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        // 继续 DFS 左、右子树
        numPaths += dfs(node.left, currentSum, targetSum, prefixSumMap);
        numPaths += dfs(node.right, currentSum, targetSum, prefixSumMap);

        // 回溯：撤销当前节点对前缀和的影响  currentSum的出现次数要 -1； 这是为何？
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);

        return numPaths;
    }



    // 不需要经过根节点 = 一定要经过根节点 + 递归一定要左右子树，
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum); //  经过了当前节点的情况 光有这个是不符合要求的，题的路径是可以不包含当前节点，所以需要加上下面的递归

        ret += pathSum(root.left, targetSum); // 递归左子树的所有节点
        ret += pathSum(root.right, targetSum); // 递归右子树的所有节点

        return ret;
    }

    public int rootSum(TreeNode root, long targetSum) { // 这里的计算逻辑是经过了当前节点的情况
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

/*124. 二叉树中的最大路径和
//困难
//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
//
//路径和 是路径中各节点值的总和。
//
//给你一个二叉树的根节点 root ，返回其 最大路径和 。
//示例 1：
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
//示例 2：
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
      -10
    9     20
        15   7
解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 */
    public int maxPathSum(TreeNode root) {

        return 0;
    }

}
