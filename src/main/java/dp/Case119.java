package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 示例 2:
 * <p>
 * 输入: rowIndex = 0
 * 输出: [1]
 * 示例 3:
 * <p>
 * 输入: rowIndex = 1
 * 输出: [1,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Case119 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return Collections.singletonList(1);
        if (rowIndex == 1) return Arrays.asList(1, 1);
        int len = rowIndex + 1;

        List<Integer> dp = getRow(rowIndex - 1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0 || i == rowIndex) {
                result.add(1);
            } else {
                result.add(dp.get(i - 1) + dp.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Case119 case119 = new Case119();
        List<Integer> s = case119.getRow(1);
        for (Integer a : s) {
            System.out.print(a);
            System.out.print("  ");
        }
        System.out.println();
    }
}
