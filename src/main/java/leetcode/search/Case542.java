package leetcode.search;

import utils.Utils;

import java.util.LinkedList;
import java.util.Queue;

//542. 01 矩阵
//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
//两个相邻元素间的距离为 1 。
//示例 1：
//输入：mat = [
// [0,0,0],
// [0,1,0],
// [0,0,0]]
//输出：[
// [0,0,0],
// [0,1,0],
// [0,0,0]]
//示例 2：
//输入：mat = [
// [0,0,0],
// [0,1,0],
// [1,1,1]]
//输出：[
// [0,0,0],
// [0,1,0],
// [1,2,1]]
public class Case542 {
    public static void main(String[] args) {
        Case542 case542 = new Case542();
//        int[][] mat ={{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}};
//        int[][] res = case542.updateMatrix(mat);
//        Utils.print2dArr(mat);
//
//        System.out.println();
//        System.out.println();
//
//
//        Utils.print2dArr(res);
//
//        int [][] ans = {{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,2,1,1,0,1},{2,1,1,1,1,2,1,0,1,0},{3,2,2,1,0,1,0,0,1,1}};
//
//        System.out.println();
//        System.out.println();
//
//
//        Utils.print2dArr(ans);
        String regionListSting ="ID,TW,VN";
        String[] regionArr = regionListSting.split(",");
        for (int i = 0; i < regionArr.length; i++) {
            regionArr[i] = "\"" + regionArr[i] + "\"";
        }
        Utils.print1dArr(regionArr);
        String regionArgs = String.join(",", regionArr);
        System.out.println(regionArgs);

    }

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[row][col];
        Queue<Dot> queue = new LinkedList<>();
        int[] a = {-1, 0, 0, 1};
        int[] b = {0, -1, 1, 0};
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int cur = mat[r][c];
                if (cur != 0) {
                    queue.offer(new Dot(r, c));
                    int level = 1;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int l = 0; l < size; l++) {
                            Dot curDot = queue.poll();
                            int find = 0;
                            for (int i = 0; i < 4; i++) {
                                int _r = curDot.x + a[i];
                                int _c = curDot.y + b[i];
                                if (-1 < _r && _r < row && -1 < _c && _c < col) {
                                    if (mat[_r][_c] != 0) {
                                        queue.offer(new Dot(_r, _c));
                                    } else {
                                        find = 1;
                                        break;
                                    }
                                }
                            }
                            if (find == 1) {
                                queue.clear();
                                break;
                            } else {
                                level++;
                            }
                        }
                        res[r][c] = level;
                    }
                } else {
                    res[r][c] = 0;
                }
            }
        }
        return res;
    }

    public static class Dot {
        public Integer x;
        public Integer y;

        public Dot(Integer x, Integer y) {
            this.x = x;
            this.y = y;
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
