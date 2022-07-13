package tanaduus.github.io.algorithm.堆栈队列;

import java.util.Stack;

/**
 * '(',')','{','}','['和']'
 *
 * @author 夏冬
 * @date 2022/7/12
 */
public class 有效括号序列 {

    public boolean isValid(String s) {
        // write code here

        if (s == null || s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : chars) {

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

                    if ('(' == stack.pop()) {
                        break;
                    } else {
                        return false;
                    }
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }

                    if ('{' == stack.pop()) {
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }

                    if ('[' == stack.pop()) {
                        break;
                    } else {
                        return false;
                    }
                default:
                    break;
            }
        }

        return stack.isEmpty();
    }
}