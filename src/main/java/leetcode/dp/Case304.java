package leetcode.dp;

/**
 *  二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1,col1) ，右下角 为 (row2,col2) 。
 * 实现 NumMatrix 类：
 * NumMatrix(int[][] matrix)给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2)返回 左上角 (row1,col1)、右下角(row2,col2) 所描述的子矩阵的元素 总和 。
 * 示例 1：
 * 输入: 
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 * 输出: 
 * [null, 8, 11, 12]
 *
 * 解释:
 * NumMatrix numMatrix = new NumMatrix([
 * [3,0,1,4,2],
 * [5,6,3,2,1],
 * [1,2,0,1,5],
 * [4,1,0,1,7],
 * [1,0,3,0,5]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 也是前缀和的一个场景
 */
public class Case304 {

    static class NumMatrix {
        private int[][] prefixSum;
        public NumMatrix(int[][] matrix) {
            prefixSum = getPreSum(matrix);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int left = col1;// 列
            int right = col2;// 列
            int top = row1; // 行
            int bottom = row2; // 行
            int result = prefixSum[bottom][right];
            if (left > 0) {
                result = result - prefixSum[bottom][left-1];
            }
            if (top > 0 ) {
                result = result - prefixSum[top-1][right];
            }
            if (left > 0 && top > 0) {
                result = result + prefixSum[top-1][left-1];
            }
            return result;
        }

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
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}};
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
}
