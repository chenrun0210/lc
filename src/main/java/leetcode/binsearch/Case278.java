package leetcode.binsearch;

/**
 * 278. 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * <p>
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * <p>
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * 示例 2：
 * <p>
 * 输入：n = 1, bad = 1
 * 输出：1
 */
public class Case278 {
    public static void main(String[] args) {
        Case278 case278 = new Case278();
        System.out.println(case278.firstBadVersion(2126753390));
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low < high) { // 1 2 . 1是坏的  mid=1，   mid是坏  high = 1 , 此时  low = high 搜索结束   ， low = high = 第一个坏的
            int mid =  low + (high - low) / 2;  // 这里也很关键  如果直接是  (low+high)/2 很可能会溢出
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int)high;
    }

    public boolean isBadVersion(long version) {
        return version >= 1702766719;
    }
}
