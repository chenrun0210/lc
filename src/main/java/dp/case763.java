package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-06-08
 */
//
//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
//
//
//
//        示例：
//
//        输入：S = "ababcbacadefegdehijhklij"
//        输出：[9,7,8]
//        解释：
//        划分结果为 "ababcbaca", "defegde", "hijhklij"。
//        每个字母最多出现在一个片段中。
//        像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
//
//
//        提示：
//
//        S的长度在[1, 500]之间。
//        S只包含小写字母 'a' 到 'z' 。
public class case763 {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> last = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            last.put(s.charAt(i), i);
        }
        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            end = Math.max(end, last.get(s.charAt(i))); // end 会一直往后，表示直到i这个点为止，之前的所有字母的最后一次出现的位置；
            if (i == end) { // 当前已经是end了，表示已经遍历到了，直到i为止，所有的元素最后一次的位置了；这肯定是最小的一个划分
                int len = end-start+1;
                start = end+1;
                result.add(len);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        case763 case763 = new case763();
        String S = "ababcbacadefegdehijhklij";
        List<Integer> res = case763.partitionLabels(S);
        System.out.println(res);
    }

}
