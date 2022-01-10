package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角形的最小路径
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，
 * 那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Case120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        if (level == 1) return triangle.get(0).get(0);
        List<List<Integer>> dp = new ArrayList<>();   // 新建动态规划矩阵
        List<Integer> l1 = triangle.get(0);
        dp.add(l1);
        for (int l = 1; l < level; l++) {
            List<Integer> llist = new ArrayList<>();
            for (int p = 0; p<triangle.get(l).size(); p++) {
                if (p == 0) {
                    llist.add(triangle.get(l).get(p) + dp.get(l-1).get(p));
                } else if (p == triangle.get(l).size() - 1) {
                    llist.add(triangle.get(l).get(p) + dp.get(l-1).get(p-1));
                }
                else {
                    int temp = Math.min(dp.get(l-1).get(p), dp.get(l-1).get(p-1));
                    llist.add(triangle.get(l).get(p) + temp);
                }
            }
            dp.add(llist);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.get(level - 1).size(); i++) {
            min = Math.min(min, dp.get(level - 1).get(i));
        }
        return min;
    }

    public static void main(String[] args) {
        Case120 case120 = new Case120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(-10)));
//        triangle.add(new ArrayList<>(Arrays.asList(2)));
//        triangle.add(new ArrayList<>(Arrays.asList(3,4)));
//        triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
//        triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        System.out.println(case120.minimumTotal(triangle));
    }

}
