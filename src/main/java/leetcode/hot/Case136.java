package leetcode.hot;

//136. 只出现一次的数字
//简单
//给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
//你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
//示例 1 ：
//
//输入：nums = [2,2,1]
//
//输出：1
//
//示例 2 ：
//
//输入：nums = [4,1,2,1,2]
//
//输出：4
//
//示例 3 ：
//
//输入：nums = [1]
//
//输出：1
//典型题目
//可使用异或运算 ⊕。异或运算有以下三个性质。
//
//任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
//任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
//异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。

//作者：力扣官方题解
//链接：https://leetcode.cn/problems/single-number/solutions/242211/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class Case136 {
    public int singleNumber(int[] nums) {
        int single = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            single = single ^ num;
        }
        return single;
    }

    public static void main(String[] args) {
        Case136 case136 = new Case136();
        int[] nums = {4,1,2,1,2};
        System.out.println(case136.singleNumber(nums));


        int a = 5;    // 二进制: 0101
        int b = 3;    // 二进制: 0011
        int result = a ^ b;  // 0110 (二进制) → 6 (十进制)
        System.out.println(result); // 输出 6
    }
}
