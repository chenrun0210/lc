package leetcode.hot;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
注意：
对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。
示例 1：
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
示例 2：
输入：s = "a", t = "a"
输出："a"
解释：整个字符串 s 是最小覆盖子串。
示例 3:
输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 */
@Slf4j
public class Case76 {

    public static void main(String[] args) {
        Case76 case76 = new Case76();
        String min  = case76.minWindow("abc",  "aabc");
        System.out.println(min);
    }
    // s = "ADOBECODEBANC", t = "ABC"
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tCount = new HashMap<>();
        String result = "";
        for (char c : t.toCharArray()) {
            tCount.compute(c, (oldKey, oldV) ->
                    {
                        if (oldV == null)
                            return 1;
                        else
                            return oldV + 1;
                    }
            );
        }
        HashMap<Character, Integer> curCount = new HashMap<>();
        int len = s.length();
        int left = 0;
        int right = left;
        while (right < len) {
            Character cur = s.charAt(right);
            if(!tCount.containsKey(cur)){
                right++;
                continue;
            }
            curCount.compute(cur, (k, v) -> (v == null) ? 1 : v + 1);
            if (containsMap(tCount, curCount)) {
                // 当前满足了包含，需要找到最小包含，把左边指针的往右移动
                int intendToRemove = left;
                while (intendToRemove < right) {
                    Character leftMove = s.charAt(intendToRemove);
                    while (!tCount.containsKey(leftMove)) {
                        intendToRemove++;
                        leftMove = s.charAt(intendToRemove);
                    }
                    //一定是包含目标字符的
                    int newCount = curCount.get(leftMove) - 1;
                    if (newCount >= tCount.get(leftMove)) {
                        curCount.put(leftMove, newCount);
                        intendToRemove++;
                    } else {
                        // 不能删除  删掉之后变小了
                        break;
                    }
                }
                left = intendToRemove;
                String sub = s.substring(left, right + 1);
                result = "".equals(result) ? sub : (result.length()<=sub.length()?result:sub);
            } else {
                // tCount里的key都在curCount里，并且值相等
                right++;
                continue;
            }
            right++;
        }
        return result;
    }
    public static <K> boolean containsMap(Map<K, Integer> a, Map<K, Integer> b) {
        // 遍历 a 的每个键值对，确保 b 中存在相同键，且值相同
        return a.entrySet().stream().allMatch(entry ->
                b.containsKey(entry.getKey()) && b.get(entry.getKey()) >= entry.getValue()
        );
    }
}
