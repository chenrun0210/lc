package leetcode.dp;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-08-19
 */
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//        数组中的每个元素代表你在该位置可以跳跃的最大长度。
//        判断你是否能够到达最后一个下标。
//
//        示例 1：
//
//        输入：nums = [2,3,1,1,4]
//        输出：true
//        解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//        示例 2：
//
//        输入：nums = [3,2,1,0,4]
//        输出：false
//        解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
//        fi = true ->  fi-j=true && num[i-j]>= j
public class case55 {
    public boolean canJump(int[] nums) {
        boolean [] can = new boolean[nums.length];
        // can[i] 表示从0开始，能不为到达nums的位置i
        can[0] = true;
        for (int i=1; i<nums.length; i++) {
            boolean cani = false;
            for (int j=1; j<=i; j++) {
                cani = can[i-j] && nums[i-j] >= j;
                if (cani) break;
            }
            can[i] = cani;
        }

        for (int i=0;i<nums.length; i++) {
            System.out.print(can[i]);
            System.out.print("   ");
        }
        System.out.println();
        return can[nums.length-1];
    }

    public static void main(String[] args) {
        case55 case55 = new case55();
        int [] nums = new int [] {2,3,1,1,4};
        case55.canJump(nums);
    }
}
