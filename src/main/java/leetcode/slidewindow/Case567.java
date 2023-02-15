package leetcode.slidewindow;

import java.util.Arrays;

/**
 * 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母     --这个提示比较关键
 */
public class Case567 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "a";

        Case567 case567 = new Case567();
        System.out.println(case567.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        int first = s1.length();
        int second = s2.length();
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        if (first > second) return false; // 特殊情况
        for (int i = 0; i < first; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) return true;
        for (int i = 0; i < second - first; i++) {
            cnt2[s2.charAt(i) - 'a']--; // 移除一个字符 第i个 所以cnt2里 对应的计数 -1
            cnt2[s2.charAt(i + first) - 'a']++; // 增加一个字符 第 i+first个 对应的计数 +1
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}
