package sort;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-09-15
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,1,6,3,5,5};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums);

        for (int i=0;i<nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private void quickSort(int [] nums) {
        int low = 0;
        int high = nums.length-1;
        quickSort(nums, low, high);
    }

    public void quickSort(int [] nums, int low, int high) {
        if(low<high) {   // 这个if一定需要，不然会StackOverflowError
            int partion = partion(nums, low, high);
            quickSort(nums, low, partion - 1);
            quickSort(nums, partion + 1, high);
        }
    }

    public int partion(int [] nums, int low, int high) {
        int pri = nums[low];
        while(low < high) {
            while(low<high && nums[high]>=pri) high--;
            nums[low] = nums[high];
            while(low<high && nums[low]<=pri) low++;
            nums[high] = nums[low];  // low  high 此时是同一个数，需要把pri放在low的位置
        }
        nums[low] = pri;
        return low;
    }
}
