//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
//
// Related Topics 数学 👍 2217 👎 0

package tanaduus.github.io.algorithm.leetcode.editor.cn;

/**
 * 题目Id：9
 * 题目：回文数
 * 日期：2022-09-23 23:38:02
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {

            if (x < 0) {
                return false;
            }

            if (x < 10) {
                return true;
            }

            byte[] bytes = String.valueOf(x).getBytes();

            int length = bytes.length;
            for (int i = 0, j = length - 1; i < length; ) {

                if (i >= j) {
                    break;
                }
                
                if (bytes[i] == bytes[j]) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
