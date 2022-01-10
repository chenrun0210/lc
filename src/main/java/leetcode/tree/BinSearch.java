package leetcode.tree;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-06
 */
public class BinSearch {

    public int binSearch (int target, int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        int mid = 0;
        while (low < high) {
            mid = (low + high)/2;
            if (nums[mid] == target) {
                break;
            }else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (nums[mid] == target) return mid;
        else return 0;
    }




}
