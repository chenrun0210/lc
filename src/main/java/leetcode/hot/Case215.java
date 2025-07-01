package leetcode.hot;

//215. 数组中的第K个最大元素
//中等
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
//请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。

import utils.Utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//示例 1:
//
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
//示例 2:
//
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4
public class Case215 {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // 获取分区点
            quickSort(arr, low, pivotIndex - 1);  // 递归排序左子数组
            quickSort(arr, pivotIndex + 1, high); // 递归排序右子数组
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 默认使用high作为pivot
        int position = low;

        for (int j = low ; j < high; j++) { // 这里是不处理pivot的，最后再处理
            if (arr[j] <= pivot) {
                swap(arr, position, j);
                position++;

            }
        }
        //处理pivot: position的位置就是pivot应该出现的位置，因为前面的都比他小了，所以这时候交换 position 和  high
        swap(arr, position, high);
        return position;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




    public int findKthLargest(int[] nums, int k) {
        quickSortK(nums, 0, nums.length-1, k);
        return nums[nums.length-k];
    }

    public static void quickSortK(int[] arr, int low, int high, int k) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // 获取分区点
            if (pivotIndex < arr.length - k) {
                quickSortK(arr, low, pivotIndex - 1, k);  // 递归排序左子数组
            } else {
                quickSortK(arr, pivotIndex + 1, high, k); // 递归排序右子数组}
            }
        }
    }


    public static int findKthLargest1(int[] nums, int k) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k); // 最小堆，容量为k
//        for (int num : nums) {
//            if (minHeap.size() < k) {
//                minHeap.offer(num); // 堆未满时直接插入
//            } else if (num > minHeap.peek()) { // 比这个队列的最小值要大，说明可以进入队列
//                minHeap.poll();     // 移除堆顶最小值  poll 和 peek都是处理队列的头部
//                minHeap.offer(num); // 插入更大的数
//            }
//        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a); // 逆序
            }
        }); // 自定义排序方式为逆序，那就是大顶堆，默认是小顶堆
        for (int num : nums) {
            maxHeap.offer(num); // 堆未满时直接插入
        }
        System.out.println("maxHeap:" + maxHeap);


        return maxHeap.peek(); // 堆顶即为第K大的数
    }

    //因此我们可以改进快速排序算法来解决这个问题：在分解的过程当中，我们会对子数组进行划分，如果划分得到的 q 正好就是我们需要的下标，就直接返回 a[q]；否则，如果 q 比目标下标小，就递归右子区间，否则递归左子区间。这样就可以把原来递归两个区间变成只递归一个区间，提高了时间效率。这就是「快速选择」算法。
    //
    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/307351/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcod-2/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        findKthLargest1(arr, 7);
    }

}
