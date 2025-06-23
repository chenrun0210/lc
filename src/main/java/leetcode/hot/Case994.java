package leetcode.hot;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * * 994. 腐烂的橘子
 * 中等
 * 相关企业
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。

 * 输入：grid = [
 * * [2,1,1],
 * * [1,1,0],
 * * [0,1,1]]
 * 输出：4
 * 示例 2：
 *
 * 输入：grid = [
 * * [2,1,1],
 * * [0,1,1],
 * * [1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
 * 示例 3：
 *
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 */
public class Case994 {
    // 典型的广度优先的算法，应该用队列来做
//    一开始，我们找出所有腐烂的橘子，将它们放入队列，作为第 0 层的结点。
//    然后进行 BFS 遍历，每个结点的相邻结点可能是上、下、左、右四个方向的结点，注意判断结点位于网格边界的特殊情况。
//    由于可能存在无法被污染的橘子，我们需要记录新鲜橘子的数量。在 BFS 中，每遍历到一个橘子（污染了一个橘子），就将新鲜橘子的数量减一。如果 BFS 结束后这个数量仍未减为零，说明存在无法被污染的橘子。
//
//    作者：nettee
//    链接：https://leetcode.cn/problems/rotting-oranges/solutions/129831/li-qing-si-lu-wei-shi-yao-yong-bfsyi-ji-ru-he-xie-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int count = 0;
        for (int i=0; i <row; i++) {
            for (int j =0; j<col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i,j});
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        if(count == 0) return 0;
        // 一开始就没有好的橘子  直接返回0

        int levelCount = 0; // 遍历了几层
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 当前层的size
            for (int i=0; i<levelSize;i++) {
                int[]cur = queue.poll();
                int r = cur[0], c = cur[1];
                // 把 [r,c] 上下左右的 1 变为2 然后放入队列
                if (r-1 >= 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    count--;
                    queue.add(new int[]{r-1, c});
                }
                if (r+1 < row && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1, c});
                }
                if (c-1 >= 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r, c-1});
                }
                if (c+1 < col && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r, c+1});
                }
            }
            levelCount++;
        }
        if(count>0) return -1;
        else return levelCount-1;
    }
}
