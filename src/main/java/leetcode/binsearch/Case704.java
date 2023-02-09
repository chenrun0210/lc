package leetcode.binsearch;

/**
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Case704 {
    public static void main(String[] args) {
        Case704 case704 = new Case704();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(case704.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {  // 这里的=  也很关键  不然只有一个元素的时候low=high=0  进不了循环
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) high = mid - 1; // 这里的-1  很关键  不然可能退不出while  会一直满足 low <= high
            else low = mid + 1; // +1 同
        }
        return -1;
    }
}
