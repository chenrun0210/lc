package leetcode.dp;

/**
 * 给你一个 n x n 的 方形 整数数组matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * [2,1,3],
 * [6,5,4],
 * [7,8,9]
 * 输出：13
 * 解释：下面是两条和最小的下降路径，用加粗+斜体标注：
 * [[2,1,3],      [[2,1,3],
 * [6,5,4],       [6,5,4],
 * [7,8,9]]       [7,8,9]]
 * 示例 2：
 * <p>
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：下面是一条和最小的下降路径，用加粗+斜体标注：
 * [[-19,57],
 * [-40,-5]]
 * 示例 3：
 * <p>
 * 输入：matrix = [[-48]]
 * 输出：-48
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Case931 {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        if (len == 1) return matrix[0][0];

        int[][] dp = new int[len][len];
        dp[0] = matrix[0];

        for (int row = 1; row < len; row++) {
            for (int column = 0; column < len; column++) {
                int minLastRow;
                if (column == 0) {
                    minLastRow = Math.min(dp[row - 1][column], dp[row - 1][column + 1]);
                } else if (column == len - 1) {
                    minLastRow = Math.min(dp[row - 1][column], dp[row - 1][column - 1]);
                } else {
                    minLastRow = Math.min(dp[row - 1][column], Math.min(dp[row - 1][column - 1], dp[row - 1][column + 1]));
                }
                dp[row][column] = matrix[row][column] + minLastRow;
            }

        }
        int min = dp[len - 1][0];
        for (int i = 0; i < len; i++) {
            min = Math.min(min, dp[len - 1][i]);
        }
        return min;
    }


    public static void main(String[] args) {
        Case931 case931 = new Case931();
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(case931.minFallingPathSum(matrix));

    }
}
