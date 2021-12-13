package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * .           1
 * .         1   1
 * .       1   2   1
 * .     1   3   3   1
 * .   1   4   6   4   1         n = 5
 * .   1   5  10   10   5   1    n = 6
 */
public class Case118 {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneList = new ArrayList<>(Arrays.asList(1));
        List<Integer> twoList = new ArrayList<>(Arrays.asList(1, 1));
        if (n == 1) {
            result.add(oneList);
            return result;
        }
        if (n == 2) {
            result.add(oneList);
            result.add(twoList);
            return result;
        }
        List<Integer> nSub1List = generate(n - 1).get(n - 2);
        List<Integer> nList = new ArrayList<>();
        for (int i = 0; i < n; i++) {

        }


        return result;
    }
}
