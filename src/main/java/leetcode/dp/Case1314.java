package leetcode.dp;

/**
 * 给你一个m x n的矩阵mat和一个整数 k ，请你返回一个矩阵answer，其中每个answer[i][j]是所有满足下述条件的元素mat[r][c] 的和：
 * <p>
 * i - k <= r <= i + k,
 * j - k <= c <= j + k 且
 * (r, c)在矩阵内。
 * 示例 1：
 * 输入：mat = [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]], k = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 * 示例 2：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-block-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 二维数组的前缀和思路----------------------------------------------------------------------------------------
 * https://leetcode.jp/leetcode-1314-matrix-block-sum-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
 */
public class Case1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {

        int row = mat.length;
        int col = mat[0].length;
        int[][] result = new int[row][col];

        int[][] prefixSum = getPreSum(mat);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int left = Math.max(0, j - k);// 列
                int right = Math.min(col - 1, j + k);// 列
                int top = Math.max(0, i - k); // 行
                int bottom = Math.min(row - 1, i + k); // 行
                result[i][j] = prefixSum[bottom][right];
                if (left > 0) {
                    result[i][j] = result[i][j] - prefixSum[bottom][left-1];
                }
                if (top > 0 ) {
                    result[i][j] = result[i][j] - prefixSum[top-1][right];
                }
                if (left > 0 && top > 0) {
                    result[i][j] = result[i][j] + prefixSum[top-1][left-1];
                }
            }
        }

//        System.out.println("----");
//        print2dArr(result);
        return result;
    }
    /**
     * 二维数组的前缀和
     * @param mat 参数数组
     * @return 二维数组的前缀和
     */
    public int[][] getPreSum(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] prefixSum = new int[row][col];
        prefixSum[0][0] = mat[0][0];
        for (int i = 1; i<col; i++) {
            prefixSum[0][i] = prefixSum[0][i-1] + mat[0][i];
        }
        for(int i = 1; i < row; i++) {
            int rowSum = 0;
            for(int j = 0; j < col; j++) {
                rowSum += mat[i][j];
                prefixSum[i][j] = prefixSum[i-1][j] + rowSum;
            }
        }
        return prefixSum;
    }

    public static void main(String[] args) {
        Case1314 case1314 = new Case1314();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        case1314.matrixBlockSum(matrix, 1);
    }
}
