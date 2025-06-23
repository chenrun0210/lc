package leetcode.dp;

/**
 * * 1884. 鸡蛋掉落-两枚鸡蛋
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你 2 枚相同 的鸡蛋，和一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * <p>
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。
 * <p>
 * 每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * <p>
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 */

/**
 * * 题解
 * 方法一：动态规划
 * 思路与算法
 * <p>
 * 我们可以使用动态规划解决本题。
 * <p>
 * 记 f[i] 表示 i 层楼的建筑需要的最小的操作次数。为了计算 f[i]，我们可以枚举鸡蛋扔下的位置 k，此时会有两种情况：
 * <p>
 * 如果鸡蛋碎了，说明答案的范围是 [0,k−1]，但我们只剩下一枚鸡蛋，因此我们只能依次在第 1,2,⋯,k−1 层扔下鸡蛋得到答案，需要 k−1 次；
 * <p>
 * 如果鸡蛋没碎，说明答案的范围是 [k,i]，并且我们还剩下两枚鸡蛋，这就等价于一栋 i−k 层的建筑的子问题，需要 f[i−k] 次。
 * <p>
 * 为了得到确切的楼层，需要的操作次数就等于上述二者的较大值，再加上 1。因此我们可以得到状态转移方程：
 * <p>
 * f[i]=1≤k≤i min {max{k−1,f[i−k]}+1}
 * 边界条件为 f[0]=0，最终的答案即为 f[n]。
 * <p>
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/description/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*
 *
 * 经典题目* *
 */
public class Case1884 {
    public static void main(String[] args) {
        Case1884 case1884 = new Case1884();
        System.out.println(case1884.twoEggDrop(1));
    }

    public int twoEggDrop(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 1; i <= n; i++) {
            // 这里需要遍历  所有 1，2，，，i的数据，然后选出最小的
            int temp = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                temp = Math.min(temp, Math.max(j - 1, f[i - j]) + 1);
            }
            f[i] = temp;
        }
        return f[n];
    }
}
