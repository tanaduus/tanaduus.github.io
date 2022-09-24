//你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有
//版本都是错的。 
//
// 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。 
//
// 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误
//的版本。你应该尽量减少对调用 API 的次数。 
//
// 示例 1： 
//
// 
//输入：n = 5, bad = 4
//输出：4
//解释：
//调用 isBadVersion(3) -> false 
//调用 isBadVersion(5) -> true 
//调用 isBadVersion(4) -> true
//所以，4 是第一个错误的版本。
// 
//
// 示例 2： 
//
// 
//输入：n = 1, bad = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= bad <= n <= 2³¹ - 1 
// 
//
// Related Topics 二分查找 交互 👍 801 👎 0

package tanaduus.github.io.algorithm.leetcode.editor.cn;

/**
 * 题目Id：278
 * 题目：第一个错误的版本
 * 日期：2022-09-25 03:18:10
 */
public class FirstBadVersion {
    public static void main(String[] args) {
        Solution solution = new FirstBadVersion().new Solution();

        System.out.println((((long) 2126753390 + (long) 1063376695)) / 2);

//        solution.firstBadVersion(2126753390);
    }

    boolean isBadVersion(int version) {
        return version >= 1702766719;
    }

    class VersionControl {

    }
    //leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {

            //二分法
            return findBad(1, n);
        }

        private int findBad(int from, int to) {

            if (from == (to - 1)) {
                return isBadVersion(from) ? from : to;
            }

            /*
                或者 int mid = from + (to - from) / 2
                总之防止溢出
             */
            int mid = (int) (((long) from + (long) to) / 2);

            if (isBadVersion(mid)) {
                if (from == mid) {
                    return from;
                }

                return findBad(from, mid);
            } else {
                if (mid == to) {
                    return mid;
                }

                return findBad(mid, to);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
