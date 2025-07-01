package leetcode.hot;
//169. 多数元素
//简单

//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。

//示例 1：
//
//输入：nums = [3,2,3]
//输出：3
//示例 2：
//
//输入：nums = [2,2,1,1,1,2,2]
//输出：2

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Case169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();

        Arrays.stream(nums).forEach(number ->
                count.compute(number, (k, v) -> (v == null) ? 1 : v + 1)
        );

        int max = Integer.MIN_VALUE;
        int key = 0;
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return  key;

    }
}
