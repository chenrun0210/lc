package leetcode.doublepointer;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 示例 2:
 *
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 */
public class Case557 {
    public static void main(String[] args) {
        Case557 case557 = new Case557();
        String s = "Let's take LeetCode contest";
        System.out.println(case557.reverseWords(s));
    }

    public String reverseWords(String s) {
        StringBuilder rt = new StringBuilder();
        String[] arr = s.split(" ");
        for(int i = 0; i<arr.length;i++) {
            StringBuilder a = new StringBuilder(arr[i]);
            a = a.reverse();
            rt.append(a);
            if(i < arr.length-1) {
                rt.append(" ");
            }
        }
        return rt.toString();
    }
}
