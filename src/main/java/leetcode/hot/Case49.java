package leetcode.hot;

import java.util.*;
import java.util.stream.Collectors;

import static utils.Utils.print2dArr;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//示例 1:
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//示例 2:
//        输入: strs = [""]
//        输出: [[""]]
//        示例 3:
//
//        输入: strs = ["a"]
//        输出: [["a"]]
//        1 <= strs.length <= 104
//        0 <= strs[i].length <= 100
//        strs[i] 仅包含小写字母
public class Case49 {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // 创建一个 Map 用于分组
        Map<String, List<String>> grouped = new HashMap<>();

        for (String str : strs) {
            // 对字符串内部字符进行排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars); // 字符数组排序
            String sorted = new String(chars); // 排序后转为字符串

            // 如果分组键不存在，创建新的列表
            if (!grouped.containsKey(sorted)) {
                grouped.put(sorted, new ArrayList<>());
            }

            // 将原始字符串加入分组
            grouped.get(sorted).add(str);
        }

        // 输出分组结果
        for (Map.Entry<String, List<String>> entry : grouped.entrySet()) {
//            System.out.println("Group: " + entry.getValue());
            result.add(entry.getValue());
        }
        return result;
    }


    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        // 使用 Stream 将字符串按照排序后的键分组
        Map<String, List<String>> grouped = Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    char[] chars = str.toCharArray();
                    Arrays.sort(chars); // 对字符数组排序
                    return new String(chars); // 排序后转为字符串
                }));
        // 输出分组结果
        grouped.forEach((key, value) -> result.add(value));
        return result;
    }
}
