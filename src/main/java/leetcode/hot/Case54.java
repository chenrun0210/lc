package leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/*
54. 螺旋矩阵
中等
相关标签
相关企业
提示
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
示例 1：
输入：matrix = [
[1,2,3],
[4,5,6],
[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：
输入：matrix = [
[1,2,3,4],
[5,6,7,8],
[9,10,11,12]]
输出：
[1,2,3,4,
8,12,11,10,
9,5,6,7]
 */
public class Case54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        // [0,0] - [0, n]
        // [0,n] - [m, n]
        // [m,n] - [m, 0]
        // [m,0] - [1, 0]
        List<Integer> result = new ArrayList<>();

        int colMax = matrix.length;
        int colMin = 0;
        int rowsMax = matrix[0].length;
        int rowMin = 0;
        int total = colMax * rowsMax;
        int col = 0;
        int row = 0;

        for (int i = 0 ; i < total; i++) {
            int now = matrix[row][col];
            result.add(now);
            if (row + 1 < rowsMax) {
                row = row+1;

            }
        }
        return result;
    }
}
