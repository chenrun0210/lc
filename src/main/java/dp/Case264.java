package dp;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * <p>
 * 丑数 就是只包含质因数2、3 和/或5的正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8,   9, 10, 12, 15, 16,   18, 20] 是由前 10 个丑数组成的序列。
 * 1        2  3  22 5  23 222  33 25  223 35  2222  233 225
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Case264 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Case264().ugly(n));
    }
    public int ugly(int n) { // 官方动态规划
        int[] ugly = new int[n + 1]; // ugly[i] 表示第i个丑数
        ugly[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = ugly[p2] * 2, num3 = ugly[p3]*3, num5 = ugly[p5] * 5;
            ugly[i] = Math.min(num2, Math.min(num3, num5));
            if (ugly[i] == num2) p2++;
            if (ugly[i] == num3) p3++;
            if (ugly[i] == num5) p5++;
        }
        return ugly[n];
    }
}
