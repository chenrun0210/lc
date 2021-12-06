package dp;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-08-19
 */
// 打家劫舍-删除并获得点数
// 给你一个整数数组 nums ，你可以对它进行一些操作。
//        每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
//        之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
//        开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
//        示例 1：
//        输入：nums = [3,4,2]
//        输出：6
//        解释：
//        删除 4 获得 4 个点数，因此 3 也被删除。
//        之后，删除 2 获得 2 个点数。总共获得 6 个点数。
//        示例 2：
//        输入：nums = [2,2,3,3,3,4]
//        输出：9
//        解释：
//        删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//        之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//        总共获得 9 个点数。
public class case740 {
    public int deleteAndEarn(int[] nums) {
        int len = 0;
        for (int i=0; i<nums.length; i++) {
            if(nums[i]>=len) len = nums[i];
        } // 找到最大的数
        int [] sum = new int[len+1];
        for (int i=0; i<nums.length; i++) {
            sum[nums[i]] += nums[i]; // 点睛之笔啊 sum[i] 表示  删除i能获得的收益
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0], nums[1]);
        int [] maxFit = new int[nums.length];
        // maxFit[i] 表示当前过了第i家的最大收益
        maxFit[0] = nums[0];
        maxFit[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<nums.length; i++) {
            maxFit[i] = Math.max(maxFit[i-1], maxFit[i-2] + nums[i]);
        }
        return maxFit[nums.length-1];
    }
}
