package leetcode.hot;

import utils.Utils;

import java.util.HashMap;

//560. 和为 K 的子数组
//        给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//        子数组是数组中元素的连续非空序列。
//    示例 1：
//
//        输入：nums = [1,1,1], k = 2
//        输出：2
//        示例 2：
//        输入：nums = [1,2,3], k = 3
//        输出：2
//        提示：
//        1 <= nums.length <= 2 * 104
//        -1000 <= nums[i] <= 1000
//        -107 <= k <= 107

public class Case560 {
    public static void main(String[] args) {
        Case560 case560 = new Case560();
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int k = 2;
        int ret = case560.subarraySum(nums, k);
        System.out.println(ret);

        ret = case560.subarraySum2(nums, k);
        System.out.println(ret);
    }

    //二维数组的方式
    // sum[i][j] 表示  num[i] + num[i+1] .... + nums[j]  i < j
    // sum[0][i]      num[0] + num[1] +...+ num[i]
    // sum[0][j]      num[0] + num[1] +...+ num[i]..+ num[j]
    //结果正确 但是内存超出了限制；
    //目测是二维数组的锅
    public int subarraySum(int[] nums, int k) {

        int ret = 0;

        int len = nums.length;
        int[][] sum = new int[len][len];
        // sum[i][j] 表示  num[i] + num[i+1] .... + nums[j]  i < j
        // sum[0][i]      num[0] + num[1] +...+ num[i]
        // sum[0][j]      num[0] + num[1] +...+ num[i]..+ num[j]
        sum[0][0] = nums[0];
        for (int i = 0; i < len; i++) {
            if (nums[i] == k) ret++;
            if (i == 0) continue;
            sum[0][i] = sum[0][i - 1] + nums[i];
        }
        Utils.print1dArr(sum[0]);

        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                sum[i][j] = sum[0][j] - sum[0][i] + nums[i];
            }
        }
        Utils.print2dArr(sum);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[j][i] == k) {
                    ret++;
                }
            }
        }
        return ret;
    }

    // 优化，使用的一维数组
    public int subarraySum1(int[] nums, int k) {
        int ret = 0;

        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        for (int i = 0; i < len; i++) {
            if (nums[i] == k) ret++;
            if (i == 0) continue;
            sum[i] = sum[i - 1] + nums[i];
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int j_i = sum[i] - sum[j] + nums[j];
                if (j_i == k) ret++;
            }
        }
        return ret;
    }

    // todo 可以使用map试试
    // 思路： 任意两个 前缀和（比如 i 和 j 前缀和） 的差   只要为K  ； 就是说 i 到 j连续的数组加起来是 K
    // 进一步，不用管前缀和的位置（i ，j）， 只需要前缀和的值出现的次数就行
    //  HashMap<Integer, Integer> record = new HashMap<>();
    //  键：前缀和，值：前缀和出现的次数
    public int subarraySum2(int[] nums, int k) {
        int ret = 0;

        int preSum = 0;
        HashMap<Integer, Integer> record = new HashMap<>();
        // 键：前缀和，值：前缀和出现的次数

        record.put(0, 1);
        // 初始化时为空区间，则前缀和为0，出现的次数为1

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            preSum += num;

            if (record.containsKey(preSum - k)) {
                ret += record.get(preSum - k);
            }
//            record.put(preSum, record.get(preSum) + 1);
            record.compute(preSum, (oldKey, oldV) ->
                    {
                        if (oldV == null)
                            return 1;
                        else return oldV + 1;
                    }
            );
            //更新前缀和 次数的key value; 如果不存在这个preSum - k 前缀和，那现在出现的次数就是1，如果出现了； 那preSum 就是preSum - k + 1
        }

        return ret;
    }


}
