package utils;

import common.ListNode;

public class Utils {
    /**
     * 输出二维数组
     *
     * @param mat
     */
    public static void print2dArr(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print1dArr(Object[] mat) {
        int row = mat.length;
        for (int j = 0; j < row; j++) {
            System.out.print(mat[j] + " ");
        }
        System.out.println();
    }

    public static void print1dArr(int[] mat) {
        int row = mat.length;
        for (int j = 0; j < row; j++) {
            System.out.print(mat[j] + " ");
        }
        System.out.println();
    }

    public static void print1dArr(Integer[] mat) {
        int row = mat.length;
        for (int j = 0; j < row; j++) {
            System.out.print(mat[j] + " ");
        }
        System.out.println();
    }

    public static ListNode listNode(Integer[] nodes) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i < nodes.length; i++) {
            ListNode nodeI = new ListNode();
            nodeI.val = nodes[i];
            if (i == nodes.length -1) {
                nodeI.next = null;
            }
            cur.next = nodeI;
            cur = cur.next;
        }
        return head.next;
    }
}
