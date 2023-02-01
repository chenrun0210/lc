package leetcode.dp.knapsack;

//377. 组合总和 Ⅳ
//        给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
//
//        题目数据保证答案符合 32 位整数范围。
//        示例 1：
//
//        输入：nums = [1,2,3], target = 4
//        输出：7
//        解释：
//        所有可能的组合为：
//        (1, 1, 1, 1)
//        (1, 1, 2)
//        (1, 2, 1)
//        (1, 3)
//        (2, 1, 1)
//        (2, 2)
//        (3, 1)
//        请注意，顺序不同的序列被视作不同的组合。
//        示例 2：
//
//        输入：nums = [9], target = 3
//        输出：0
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/combination-sum-iv
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Case377 {
    public static void main(String[] args) {
        Case377 case377 = new Case377();
        int[] nums = new int[]{9};
        int target = 3;
        System.out.println(case377.combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // dp [i] 凑成i的排列数
        dp[0] = 1;
        for (int amount = 1; amount <= target; amount++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= amount) dp[amount] += dp[amount - nums[i]];
            }
        }
        return dp[target];
    }
}
