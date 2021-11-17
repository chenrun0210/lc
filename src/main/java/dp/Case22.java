package dp;

import java.util.*;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-10-04
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * 示例 1：
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * n = 1
 * ["()"]
 * <p>
 * n=2
 * ["(())","()()"]
 * <p>
 * n = 3
 * ["((()))","(()())","(())()","()(())","()()()"]
 */
public class Case22 {
    public static void main(String[] args) {
        Case22 case22 = new Case22();
        List<String> result = case22.generateParenthesis(3);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Collections.singletonList("()");
        }
        HashSet<String> set = new HashSet<>();
        for (String str : generateParenthesis(n - 1)) {
            for (int i = 0; i <= str.length(); i++) {
                set.add(str.substring(0, i) + "()" + str.substring(i, str.length()));  // 把一个完整的（）插入到每一个位置 ，然后利用set去重
            }
        }
        return new ArrayList<>(set);
    }
}
