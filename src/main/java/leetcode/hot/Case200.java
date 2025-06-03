package leetcode.hot;

/**
 * * 200. 岛屿数量
 * 中等
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。

 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 */
public class Case200 {

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int count = 0;
        for (int i = 0; i<rows; i++){
            for(int j=0; j<columns; j++)
            {
                if (grid[i][j]=='1') {
                    // 如果是1 调用 dfs 把它所有的一片的都置为2， 那就是一个岛屿
                    dfs(grid, i, j);
                    count++;

                }

            }

        }
        return count;

    }

    // 网格的dfs的框架

    void dfs(char[][] grid, int r, int c) {
        // 判断 base case
        if (!inArea(grid, r, c)) {
            return;
        }

        //____________________________________________
        // 这一段是特定的故事线的特性逻辑，用这个框架在这里加上就好
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '2'; // 将格子标记为「已遍历过」
        //____________________________________________



        // 访问上、下、左、右四个相邻结点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    // 判断坐标 (r, c) 是否在网格中
    boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }

//    作者：nettee
//    链接：https://leetcode.cn/problems/number-of-islands/solutions/211211/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
