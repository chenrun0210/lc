package leetcode.hot;

import utils.Utils;

/*
48. 旋转图像
中等
给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
示例 1：
输入：matrix = [
先3 5 7 对角线交换     再 上下翻转
[1,2,3],   [9,6,3],     [7,4,1]
[4,5,6],   [8,5,2],     [8,5,2]
[7,8,9]]   [7,4,1]      [9,6,3],
输出：[
[7,4,1],
[8,5,2],
[9,6,3]]
示例 2：
输入：matrix =
11 -15的对角线翻转：                上下翻转
[5,1,9,11],      [16,7,10,11],        [15,13,2,5]
[2,4,8,10],      [12,6, 8,9],         [14,3 ,4,1],
[13,3,6,7],      [14,3, 4,1],         [12,6 ,8,9],
[15,14,12,16]    [15,13,2,5]          [16,7,10,11],
输出：[
[15,13,2,5],
[14,3,4,1],
[12,6,8,9],
[16,7,10,11]]
        对角线：
[1,0] - [1 2] - [3,2]
[1 1] - [1 2] - [2,2]
[0 1] - [0 3] - [2,3]
[1,3] -  -[0 2]
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
 */
public class Case48 {


    public static void main(String[] args) {
        Case48 case48 = new Case48();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        case48.rotate(matrix);
    }


    // 要求是原地  最好是能直接2个位置的数据交换 通过多次交换来达到旋转的结果
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int indexMax = len - 1;
        int indexMin = 0;
        for (int row = 0; row < len; row++) {
            int diagonalOfThisRow_col;// 这一行的对角线的点的列坐标
            diagonalOfThisRow_col = indexMax - row;
            for (int col = 0; col < diagonalOfThisRow_col; col++) {
                int diagonalOfThisCol_row; // 这一列的对角线的点的行坐标
                diagonalOfThisCol_row = indexMax - col;

                int a = matrix[row][col];
                int rowRymmetry = diagonalOfThisCol_row; //  对角线对称点的行坐标  ==  这一点所在那一列  上的 对角线点   的  行坐标
                int colRymmetry = diagonalOfThisRow_col; //  对角线对称点的列坐标  ==  这一点坐在那一行  上的 对角线点   的  列坐标
                // 对角线翻转的规则  先移动到对角线上  再移动到目标位置
                matrix[row][col] = matrix[rowRymmetry][colRymmetry];
                matrix[rowRymmetry][colRymmetry] = a;
            }
        }
//        System.out.println("------");
//        Utils.print2dArr(matrix);


        // 上下翻转

        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int a = matrix[i][j];
                // 上线翻转，新的点的 列坐标不变   行坐标 = indexMax - 现有行坐标
                int newRow = indexMax - i;
                int newCol = j;
                matrix[i][j] = matrix[newRow][newCol];
                matrix[newRow][newCol] = a;
            }
        }
//        System.out.println("------");
//        Utils.print2dArr(matrix);
    }
}
