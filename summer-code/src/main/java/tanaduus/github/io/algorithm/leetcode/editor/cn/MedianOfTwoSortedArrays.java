//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 5889 👎 0

package tanaduus.github.io.algorithm.leetcode.editor.cn;

/**
 * 题目Id：4
 * 题目：寻找两个正序数组的中位数
 * 日期：2022-09-23 23:06:33
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            //空数组解决
            if ((nums1 == null || nums1.length == 0) && (nums2 != null && nums2.length > 0)) {
                if (nums2.length % 2 == 0) {
                    return ((double) (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2])) / 2;
                } else {
                    return nums2[nums2.length / 2];
                }
            }

            if ((nums2 == null || nums2.length == 0) && (nums1 != null && nums1.length > 0)) {
                if (nums1.length % 2 == 0) {
                    return ((double) (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2])) / 2;
                } else {
                    return nums1[nums1.length / 2];
                }
            }


            boolean isEven = (nums1.length + nums2.length) % 2 == 0;

            int k;//表示第k大
            if (isEven) {
                k = (nums1.length + nums2.length) / 2; // 4/2=3... 2,3
            } else {
                k = (nums1.length + nums2.length) / 2 + 1; // 5/2+1=3...3
            }

            double v1 = find(k, nums1, nums2);

            if (isEven) {

                int v2;
                if (vInNums1) {

                    if (idx1 + 1 <= nums1.length - 1) {

                        if (idx2 <= nums2.length - 1) {
                            v2 = Math.min(nums1[idx1 + 1], nums2[idx2]);
                        } else {
                            v2 = nums1[idx1 + 1];
                        }

                    } else {
                        v2 = nums2[idx2];
                    }
                } else {

                    if (idx2 + 1 <= nums2.length - 1) {

                        if (idx1 <= nums1.length - 1) {
                            v2 = Math.min(nums1[idx1], nums2[idx2 + 1]);
                        } else {
                            v2 = nums2[idx2 + 1];
                        }

                    } else {
                        v2 = nums1[idx1];
                    }
                }

                return (v1 + v2) / 2;

            } else {
                return v1;
            }
        }

        boolean vInNums1 = true;
        int idx1 = 0;
        int idx2 = 0;

        private double find(int k, int[] nums1, int[] nums2) {

            //数组已全部剔除
            if (idx1 > nums1.length - 1) {

                vInNums1 = false;
                idx2 = idx2 + k - 1;
                return nums2[idx2];
            } else if (idx2 > nums2.length - 1) {

                vInNums1 = true;
                idx1 = idx1 + k - 1;
                return nums1[idx1];
            }

            if (k == 1) {

                if (nums1[idx1] < nums2[idx2]) {
                    vInNums1 = true;
                } else {
                    vInNums1 = false;
                }

                return Math.min(nums1[idx1], nums2[idx2]);
            }

            //数组剩余长度不满足k/2
            if (idx1 + k / 2 - 1 > nums1.length - 1) {

                int step = nums1.length - idx1 - 1;

                if (nums1[nums1.length - 1] < nums2[idx2 + step]) {

                    idx1 = nums1.length;
                } else {
                    idx2 = idx2 + step + 1;
                }

                return find(k - (step + 1), nums1, nums2);
            } else if (idx2 + k / 2 - 1 > nums2.length - 1) {
                int step = nums2.length - idx2 - 1;

                if (nums1[idx1 + step] < nums2[nums2.length - 1]) {

                    idx1 = idx1 + step + 1;
                } else {

                    idx2 = nums2.length;
                }

                return find(k - (step + 1), nums1, nums2);
            }

            //数组剩余长度满足k/2
            if (nums1[idx1 + k / 2 - 1] < nums2[idx2 + k / 2 - 1]) {

                idx1 = idx1 + k / 2;
            } else {

                idx2 = idx2 + k / 2;
            }

            return find(k - (k / 2), nums1, nums2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
