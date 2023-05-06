package leetcode.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Case695 {
    public static void main(String[] args) {
        Case695 case695 = new Case695();
        int[][] grid = new int[][]{
//                {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0}
                {1, 1},
                {1, 1}
        };
        System.out.println(case695.maxAreaOfIsland(grid));
    }

    /**
     * 用的队列来实现，深度优先
     */
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
       Queue<Dot> isLand = new LinkedList<>();
        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < cols; n++) {
                if (grid[m][n] == 1) {
                    isLand.offer(new Dot(m,n));
                }
            }
        }
        int max = 0;
        while (!isLand.isEmpty()) {
            Dot first = isLand.poll();
            int cur = 0;
            Queue<Dot> queue = new LinkedList<>();
            queue.add(first);
            while (!queue.isEmpty()) {
                Dot t = queue.poll();
                int rn = t.x, cn = t.y;
                cur++;
                grid[rn][cn] = 0;
                int[] a = {1, 0, 0, -1};
                int[] b = {0, 1, -1, 0};
                for (int i = 0; i < 4; i++) {
                    int rn_n = rn + a[i];
                    int cn_n = cn + b[i];
                    if (isLand.contains(new Dot(rn_n, cn_n))) {
                        queue.offer(new Dot(rn_n, cn_n));
                        isLand.remove(new Dot(rn_n, cn_n));
                        // 避免重复处理
                    }
                }

            }
            max = Math.max(max, cur);
        }
        return max;
    }


    public static class Dot {
        public Integer x;
        public Integer y;

        public Dot(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Dot)) return false;
            else {
                Dot dot = (Dot) obj;
                return this.x == dot.x && this.y.equals(dot.y);
            }
        }
        @Override
        public String toString() {
            return "Dot{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
