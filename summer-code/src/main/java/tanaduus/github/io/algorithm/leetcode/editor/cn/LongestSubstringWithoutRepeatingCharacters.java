//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 8202 👎 0

package tanaduus.github.io.algorithm.leetcode.editor.cn;

import java.util.HashMap;

/**
 * 题目Id：3
 * 题目：无重复字符的最长子串
 * 日期：2022-09-25 16:52:40
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;

        /**
         * 判断该元素是否在窗口中已存在
         */
        private boolean containsKey(char c) {
            Integer index = map.get(c);
            if (index == null) {
                return false;
            }

            if (index < start) {
                return false;
            }

            return true;
        }

        public int lengthOfLongestSubstring(String s) {

            char[] chars = s.toCharArray();
            int maxWindow = 0;

            for (int i = 0; i < chars.length; ) {

                char c = chars[i];

                if (containsKey(c)) {
                    Integer index = map.get(c);
                    start = index + 1;
                }

                map.put(c, i);
                end = i;

                i++;

                maxWindow = Math.max(maxWindow, (end - start + 1));
            }

            return maxWindow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
