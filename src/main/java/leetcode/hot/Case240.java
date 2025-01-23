package leetcode.hot;

/*
240. 搜索二维矩阵 II
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。

示例 1：
输入：matrix = [
[1,4,7,11,15],
[2,5,8,12,19],
[3,6,9,16,22],
[10,13,14,17,24],
[18,21,23,26,30]],
target = 5
输出：true
示例 2：
输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
输出：false
 */
public class Case240 {
    // 思路是 从左下角 或者 右上角 开始
    // 左下角： 小的都在上面， 大的都在右边
    // matrix[row][col]
    // 小 :  row--
    // 大 ： col++
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowMax = rows - 1;
        int colMax = cols - 1;

        int rowStart = rowMax;
        int colStart = 0;
        while (rowStart >= 0 && colStart <= colMax) {
            if (matrix[rowStart][colStart] == target) return true;
            if (matrix[rowStart][colStart] > target) {
                rowStart--;
            } else {
                colStart++;
            }
        }
        return false;
    }
}
