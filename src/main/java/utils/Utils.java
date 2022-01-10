package utils;

public class Utils {
    /**
     * 输出二维数组
     * @param mat
     */
    public static void print2dArr(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
