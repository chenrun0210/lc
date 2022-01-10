package leetcode.dp;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-01
 */
//1014. 最佳观光组合
//        给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
//
//        一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
//        返回一对观光景点能取得的最高分。
//        示例 1：
//
//        输入：values = [8,1,5,2,6]
//        输出：11
//        解释：i = 0, j = 2, values[i]  + i + values[j] - j = 8 + 5 + 0 - 2 = 11
//        示例 2：
//
//        输入：values = [1,2]
//        输出：2
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/best-sightseeing-pair
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Case1014 {

    static class Solution {
        // 实际转成每个i,先求i左边最大的 value[k]  + k  = max
        //  values[i]  + i + values[j] - j
        // 然后再保存一个最大值，为  max + value[i]-i
        public int maxScoreSightseeingPair(int[] values) {
            int len = values.length;
            int max = values[0] + 0;
            int result = 0;
            for (int i = 1; i < len; i++) {
                max = Math.max(values[i - 1] + i - 1, max);
                result = Math.max(result, max + values[i] - i);
            }
            return result;
        }

        // 2021-12-03
        public int maxScoreSightseeingPairV2(int[] values) {
            int len = values.length;
            int[] maxArr = new int[len]; // maxArr[i] 表示  i 左边，   value[i] + i 的最大值
            maxArr[0] = values[0] + 0;
            for (int i = 1; i < len; i++) {
                maxArr[i] = Math.max(values[i-1] + i-1,   maxArr[i-1]); // 因为是左边，这里一定要  i-1
            }

            int result = 0;
            for (int i=1;i<len; i++) {
                result = Math.max(maxArr[i] + values[i] - i, result);
            }
            return result;
        }
    }
}
