package doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-10-01
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 */
public class Case15 {

    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        Case15 case15 = new Case15();
        List<List<Integer>> res = case15.threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return null;
        }
        int len = nums.length;
        Arrays.sort(nums);
        int start = 0;
        int left = 0;
        int right = 0;
        List<List<Integer>> res = new ArrayList<>();

        for (start = 0; start <= len - 3; start++) {
            if(start > 0 && nums[start] == nums[start-1]) continue; // 去重  这里非常晦涩
            left = start + 1;
            right = len - 1;
            if (nums[start] > 0) {
                start++;
                break;
            }
            while (left < right) {
                if (nums[start] + nums[left] + nums[right] == 0) {
                    res.add(Arrays.asList(nums[start], nums[left], nums[right])); // 这里也是要先添加，再处理双指针
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--; left++;
                } else if (nums[start] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
