//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3512 👎 0

package tanaduus.github.io.algorithm.leetcode.editor.cn;

import java.util.Stack;

/**
 * 题目Id：20
 * 题目：有效的括号
 * 日期：2022-09-24 01:48:08
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {

            Stack<Character> stack = new Stack<>();
            Character cur;
            for (char c : s.toCharArray()) {
                switch (c) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push(c);
                        break;
                    case ')':
                        if (stack.isEmpty()) {
                            return false;
                        }
                        cur = stack.pop();
                        if (cur == '(') {
                            break;
                        }
                        return false;
                    case '}':
                        if (stack.isEmpty()) {
                            return false;
                        }
                        cur = stack.pop();
                        if (cur == '{') {
                            break;
                        }
                        return false;
                    case ']':
                        if (stack.isEmpty()) {
                            return false;
                        }
                        cur = stack.pop();
                        if (cur == '[') {
                            break;
                        }
                        return false;
                }
            }

            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
