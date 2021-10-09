package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-10-04
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * 示例 1：
 *

 * 示例 2：
 *
 * n = 1
 * ["()"]
 *
 * n=2
 * ["(())","()()"]
 *
 * n = 3
 *["((()))","(()())","(())()","()(())","()()()"]
 */
public class Case22 {
    public static void main(String[] args) {
        Case22 case22 = new Case22();
        case22.generateParenthesis(3);
    }
    public List<String> generateParenthesis(int n) {
        Map<Integer, List<String>> dp = new HashMap<>();
        dp.put(0, new ArrayList<>());
        dp.put(1, Arrays.asList("()"));
        for (int i=2; i<=n; i++) {
            List<String> nList = new ArrayList<>();
            for (int p = 0; p<= i-1; p++) {   // n=5
                List<String> pList = dp.get(p); // p=1 的list
                List<String> qList = dp.get(i-p-1); // p=3 的list
                // pList 和 qList 加起来是dp[n-1]的总和
                for (String s1 : pList) {
                    for (String s2 : qList) {
                        String el = "(" + s1 + ")" + s2;
                        nList.add(el);
                    }
                }

            }
            dp.put(i, nList);
        }
        return dp.get(n);
    }
}
