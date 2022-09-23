//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 👍 2471 👎 0

package tanaduus.github.io.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目Id：14
 * 题目：最长公共前缀
 * 日期：2022-09-24 00:00:19
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();

        String[] strs = {"flower", "flow", "flight"};

        solution.longestCommonPrefix(strs);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {

            if (strs == null || strs.length == 0) {
                return "";
            }

            if (strs.length == 1) {
                if (strs[0] == null || "".equals(strs[0])) {
                    return "";
                } else {
                    return strs[0];
                }
            }

            //以第一个数组构建trie树
            String str = strs[0];
            if (str == null || "".equals(str)) {
                return "";
            }

            char[] chars = str.toCharArray();
            int minDepth = chars.length;
            Map<Character, Trie> tempChildsMap = null;
            for (int i = 0; i < chars.length; i++) {
                if (i == 0) {
                    trie = new Trie();
                    trie.val = chars[i];
                    trie.cildsMap = new HashMap<>();
                    tempChildsMap = trie.cildsMap;
                } else {
                    Trie curTrie = new Trie();
                    curTrie.val = chars[i];
                    curTrie.cildsMap = new HashMap<>();

                    tempChildsMap.put(curTrie.val, curTrie);

                    tempChildsMap = curTrie.cildsMap;
                }
            }

            for (int k = 1; k < strs.length; k++) {
                String s = strs[k];
                if (s == null || "".equals(s)) {
                    return "";
                }

                chars = s.toCharArray();
                minDepth = Math.min(minDepth, chars.length);
                tempChildsMap = null;
                for (int i = 0; i < chars.length; i++) {
                    if (i == 0) {
                        if (trie.val == chars[i]) {
                            tempChildsMap = trie.cildsMap;
                        } else {
                            return "";
                        }
                    } else {
                        if (tempChildsMap.containsKey(chars[i])) {
                            tempChildsMap = tempChildsMap.get(chars[i]).cildsMap;
                        } else {
                            Trie curTrie = new Trie();
                            curTrie.val = chars[i];
                            curTrie.cildsMap = new HashMap<>();
                            tempChildsMap.put(curTrie.val, curTrie);
                            tempChildsMap = tempChildsMap.get(chars[i]).cildsMap;
                        }
                    }
                }
            }

            StringBuilder result = new StringBuilder(String.valueOf(trie.val));
            int curDepth = 1;
            tempChildsMap = trie.cildsMap;
            while (tempChildsMap != null && tempChildsMap.size() == 1 && curDepth < minDepth) {
                Character k = null;
                Trie v = null;
                for (Map.Entry<Character, Trie> entry : tempChildsMap.entrySet()) {
                    k = entry.getKey();
                    v = entry.getValue();
                }

                result.append(k);
                tempChildsMap = v.cildsMap;
                curDepth++;
            }

            return result.toString();
        }

        Trie trie = null;

        class Trie {
            char val;
            Map<Character, Trie> cildsMap;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
