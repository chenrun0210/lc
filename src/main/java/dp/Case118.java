package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * .   1
 * .   1   1
 * .   1   2   1
 * .   1   3   3   1
 * .   1   4   6   4   1         n = 5
 * .   1   5  10   10   5   1    n = 6
 */
public class Case118 {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneList = Collections.singletonList(1);
        List<Integer> twoList = Arrays.asList(1, 1);
        if (n == 1) {
            result.add(oneList);
            return result;
        }
        if (n == 2) {
            result.add(oneList);
            result.add(twoList);
            return result;
        }
        List<List<Integer>> dp = generate(n - 1);
        List<Integer> nSub1List = dp.get(n - 2);
        // 有n-1个数据  下标是0 - n-2
        List<Integer> nList = new ArrayList<>(n);
        // 有n个数据， 下标是0 - n-1

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                nList.add(1);
            } else {
                nList.add(nSub1List.get(i - 1) + nSub1List.get(i));
            }

        }
        dp.add(nList);
        return dp;
    }

    public static void main(String[] args) {
        Case118 case118 = new Case118();
        List<List<Integer>> s = case118.generate(10);
        for (List<Integer> subList : s) {
            for (Integer a : subList) {
                System.out.print(a);
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}
