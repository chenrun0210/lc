package leetcode.dp;


/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 */
public class Case63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];// leetcode.dp[x][y] : 表示从0，0  到 (x,y)有几种走法
        for (int j = 0; j < col; j++) {
            if (obstacleGrid[0][j] == 1) break;
            dp[0][j] = 1;
        }
        // 第一行
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        // 第一列
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] == 1) {
                    dp[i][j] = 0;
                } else if (obstacleGrid[i][j - 1] == 1) {
                    dp[i][j] = dp[i - 1][j];
                } else if (obstacleGrid[i - 1][j] == 1) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
//        print2dArr(leetcode.dp);
        return obstacleGrid[row - 1][col - 1] == 1 ? 0 : dp[row - 1][col - 1]; // 终点居然有可能是陷阱
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        Case63 case63 = new Case63();
        System.out.println(case63.uniquePathsWithObstacles(obstacleGrid));
        Case64 case64 = new Case64();
        System.out.println(case64.minPathSum(obstacleGrid));
    }
}
