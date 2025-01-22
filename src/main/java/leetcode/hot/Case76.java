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
        String min  = case76.minWindow1("bba",  "ba");
        System.out.println(min);
    }
    // s = "ADOBECODEBANC", t = "ABC"
    // 双指针  先移动右边的，找到最低的符合的，再移动左边，直至最短匹配。匹配后再移动右侧，再移动左侧 直至结束
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

    // 参考题解
    // 思路是没有每次都对比整个map； 用了matchCount；来标记2个计数map里匹配的字符个数
    //
    public String minWindow1(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        // 用于统计 t 中字符频率的哈希表
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }
        // 滑动窗口中的有效字符统计
        Map<Character, Integer> windowFreq = new HashMap<>();

        int left = 0, right = 0;
        int matchCount = 0; // 记录已匹配的字符数量
        int minLen = Integer.MAX_VALUE;
        int start = 0; // 最小窗口的起始位置

        while (right < s.length()) {
            char cRight = s.charAt(right);
            right++;

            // 更新窗口内的字符频率
            if (tFreq.containsKey(cRight)) {
                windowFreq.put(cRight, windowFreq.getOrDefault(cRight, 0) + 1);
                if (windowFreq.get(cRight).equals(tFreq.get(cRight))) {
                    matchCount++;
                }
            }

            // 当匹配数量达到目标，尝试缩小窗口 这个条件精髓
            while (matchCount == tFreq.size()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char cLeft = s.charAt(left);
                left++;

                // 更新窗口内容
                if (tFreq.containsKey(cLeft)) {
                    if (windowFreq.get(cLeft).equals(tFreq.get(cLeft))) {
                        matchCount--;
                    }
                    windowFreq.put(cLeft, windowFreq.get(cLeft) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }


    public static <K> boolean containsMap(Map<K, Integer> a, Map<K, Integer> b) {
        // 遍历 a 的每个键值对，确保 b 中存在相同键，且值相同
        return a.entrySet().stream().allMatch(entry ->
                b.containsKey(entry.getKey()) && b.get(entry.getKey()) >= entry.getValue()
        );
    }
}
