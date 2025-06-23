package leetcode.hot;
//287. 寻找重复数
//中等
//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
//
//假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
//
//你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。

//示例 1：
//
//输入：nums = [1,3,4,2,2]
//输出：2
//示例 2：
//
//输入：nums = [3,1,3,4,2]
//输出：3
//示例 3 :
//
//输入：nums = [3,3,3,3,3]
// 我们定义 cnt[i] 表示 nums 数组中小于等于 i 的数有多少个，
// 假设我们重复的数是 target，那么 [1,target−1]里的所有数满足 cnt[i]≤i，[target,n] 里的所有数满足 cnt[i]>i，具有单调性。
//
//        以示例 1 为例，我们列出每个数字的 cnt 值：
//
//        nums	1	2	3	4
//        cnt	1	3	4	5
//
//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/find-the-duplicate-number/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//输出：3


public class Case287 {
    public static void main(String[] args) {
        Case287 case287 = new Case287();
        int[] nums = {1,3,4,2,2};
        int a = case287.findDuplicate(nums);
        System.out.println(a);
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            // 表示小于等于  mid 的个数
// nums  1,3,4,2,2

//        nums	1	2	3	4
//        cnt	1	3	4	5
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
                // 说明是对的， cnt 就因该 <= mid；
                // 也说明所有的 mid以下的都是对的
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
