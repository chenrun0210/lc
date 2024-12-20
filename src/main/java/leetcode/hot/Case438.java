package leetcode.hot;

import java.util.*;
import java.util.stream.Collectors;

//438. 找到字符串中所有字母异位词
//        给定两个字符串 s 和 p，找到 s 中所有 p 的
//        异位词
//        的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//        示例 1:
//        输入: s = "cbaebabacd", p = "abc"
//        输出: [0,6]
//        解释:
//        起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//        起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//        示例 2:
//        输入: s = "abab", p = "ab"
//        输出: [0,1,2]
//        解释:
//        起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//        起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//        起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
//        提示:
//        1 <= s.length, p.length <= 3 * 104
//        s 和 p 仅包含小写字母
public class Case438 {

    public static void main(String[] args) {
        Case438 case438 = new Case438();
        case438.findAnagrams1("cbaebabacd", "abc");
                                //0123456789

    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        int[] pCheck = new int[26];
        int[] sCheck = new int[26];
        for (int i = 0; i < p.toCharArray().length; i++) {
            char c = p.charAt(i);
            pCheck[c - 'a'] += 1;
            char v = s.charAt(i);
            sCheck[v - 'a'] += 1;
        }

        if (Arrays.equals(pCheck, sCheck)) {
            result.add(0);
        }

        for (int delete = 0; delete < sLen - pLen; delete++) {
            int add = delete + pLen;
            sCheck[s.charAt(delete) - 'a'] -= 1;
            sCheck[s.charAt(add) - 'a'] += 1;
//            if (sCheck[s.charAt(delete) - 'a'] == pCheck[s.charAt(delete) - 'a'] && sCheck[s.charAt(add) - 'a'] == pCheck[s.charAt(add) - 'a']) {
            // 这个思路是错的
            if(Arrays.equals(pCheck, sCheck)) {
                result.add(delete+1);
                System.out.println( delete+1);

            }
        }
        return result;
    }

    public boolean check(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        for (int i = 0; i < sLen - pLen + 1; i++) {
            String temp = s.substring(i, i + pLen);
            if (isChcek(temp, p)) {
                result.add(i);
                System.out.println(i);
            }

        }
        return result;
    }

    public boolean isChcek(String a, String b) {
        // 对字符串内部字符进行排序
        char[] chars = a.toCharArray();
        Arrays.sort(chars); // 字符数组排序
        String sorted = new String(chars); // 排序后转为字符串
        char[] bc = b.toCharArray();
        Arrays.sort(bc); // 字符数组排序
        String sortedb = new String(bc); // 排序后转为字符串
        return sorted.equals(sortedb);
    }
}
