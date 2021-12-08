package dp;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * 二叉搜索树 : 左子树 < 根节点 < 右子树
 * n = 3 输出5
 * 1 2 3 4 5
 * Gn = N个整数，有几种解法
 * F(i,n) = N个整数，以i为根，有几种解法
 * <p>
 * Gn = F(1,n) + F(2,n) + ... + F(n,n)
 * <p>
 * F(i,n) : 以i为根，左子树一定是 1 2 .... i-1, 右子树一定是 i+1 i+2...n
 * 那么左子树的解法就是Gi-1; 右子树的解法就是 n-i
 * F(i,n) = G(i-1）* G(n-i)
 * Gn = F(1,n) + F(2,n) + ... + Fnn
 * Gn = G0*G(n-1) + G1*G(n-2) +     +G(n-2)*G1 +G(n-1)*G0
 * G(2) = G0*G1 + G1*G0
 */
public class Case96 {
    public static void main(String[] args) {
        System.out.println(new Case96().numTrees(3));
    }

    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            g[i] = 0;
            for (int j = 0; j < i; j++) {
                g[i] += g[j]*g[i-j-1];
            }
        }
        return g[n];
    }
}
