package leetcode.doublepointer;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（
 * 例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * 致谢：
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 */
public class Case392 {
    public static void main(String[] args) {
        Case392 case392 = new Case392();
        String s = "b",  t = "ahbgdc";
        System.out.println(case392.isSubsequence(s, t));
    }

    /**
     * @param s 子字符串
     * @param t 父字符串
     * @return 判定s 是不是t 的子序列
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        int lenT = t.length();
        int lenS = s.length();
        int posS = 0;
        int posT = 0;
        while (posT < lenT && posS < lenS) {
            if (s.charAt(posS) == t.charAt(posT)) {
                posS++;
            }
            posT++;
        }
        return posS == lenS;
    }
}
