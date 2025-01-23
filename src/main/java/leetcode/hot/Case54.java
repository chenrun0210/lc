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
    public static void main(String[] args) {
        Case54 case54= new Case54();
        int[][] matrix= new int[][] {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        List<Integer> result = case54.spiralOrder(matrix);
        System.out.println(result);
    }

    // 设计一个方向的数组
    // 根据方向计算下一个坐标
    // 方向转化的时候 四个方向的上下限变动
    public List<Integer> spiralOrder(int[][] matrix) {
        // [0,0] - [0, n]
        // [0,n] - [m, n]
        // [m,n] - [m, 0]
        // [m,0] - [1, 0]
        List<Integer> result = new ArrayList<>();

        int colMax = matrix[0].length - 1;
        int colMin = 0;

        int rowsMax = matrix.length - 1;
        int rowMin = 0;
        int total = matrix[0].length * matrix.length;

        int col = 0;
        int row = 0;

        char[] direction = new char[]{'r', 'd', 'l', 'u'};
        int dic = 0;
        //4个 方向
        for (int i = 0; i < total; i++) {
            int now = matrix[row][col];
            result.add(now);
            switch (direction[dic % 4]) {
                case 'r':
                    if (col + 1> colMax) {
                        dic = dic + 1;// 切换方向
                        rowMin = rowMin + 1; // 行min + 1
                        row = row + 1;
                    } else{
                        col = col + 1;
                    }
                    break;
                case 'd':
                    if (row + 1 > rowsMax) {
                        dic = dic + 1;// 切换方向
                        colMax = colMax - 1;//列max-1
                        col = col - 1;
                    } else {
                        row = row + 1;
                    }
                    break;
                case 'l':
                    if (col - 1 < colMin) {
                        dic = dic + 1;// 切换方向
                        rowsMax = rowsMax - 1;
                        row = row - 1;
                    } else{
                        col = col - 1;
                    }
                    break;
                case 'u':
                    if (row - 1 < rowMin) {
                        dic = dic + 1;
                        colMin = colMin + 1;
                        col = col + 1;
                    } else {
                        row = row - 1;
                    }
                    break;
            }
        }
        return result;
    }
}
