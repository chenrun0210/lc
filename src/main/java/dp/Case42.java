package dp;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-05
 */
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//        示例 1：
//        输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//        输出：6
//        解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/trapping-rain-water
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Case42 {

    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution solution = new Solution();
        System.out.println(solution.trap(height));
    }

    static class Solution {
        public int trap(int[] height) {
            int len = height.length;
            int[] maxLeft = new int[len];
            int[] maxRight =  new int[len];
            maxLeft[0] = 0;
            for (int i=1; i<len; i++) {
                maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
            }
            maxRight[len-1] = 0;
            for (int i=len-2; i>=0; i--) {
                maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
            }

            int[] cap = new int[len];
            int sum = 0;
            for (int i=0; i<len; i++) {
                cap[i] = Math.min(maxLeft[i], maxRight[i]) - height[i];
                    if (cap[i]>0){
                    sum += cap[i];
                    }
            }

            for (int i=0; i<len; i++) {
                System.out.print(maxLeft[i]);
            }

            System.out.println();
            for (int i=0; i<len; i++) {
                System.out.print(maxRight[i]);
            }
            System.out.println();
            return sum;
        }
    }
}
