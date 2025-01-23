package leetcode.hot;

/*
73. 矩阵置零
中等
相关标签
相关企业
提示
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
示例 1：
输入：matrix = [
[1,1,1],
[1,0,1],
[1,1,1]]
输出：
[[1,0,1],
 [0,0,0],
 [1,0,1]
 ]
示例 2：


输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */

public class Case73 {

    // 用标记的方法去做，不要直接修改，直接修改会导致后续的判断比较麻烦
    public void setZeroes(int[][] matrix) {
        int columns = matrix.length;
        int rows = matrix[0].length;
        boolean[] colFlag = new boolean[columns];
        boolean[] rowFlag = new boolean[rows];

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (matrix[i][j] == 0) {
                    colFlag[i] = true;
                    rowFlag[j] = true;
                }
            }
        }
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (colFlag[i] || rowFlag[j] == true) {
                    matrix[i][j] = 0;
                }

            }
        }
    }
}
