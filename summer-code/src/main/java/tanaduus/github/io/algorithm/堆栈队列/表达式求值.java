package tanaduus.github.io.algorithm.堆栈队列;

import java.util.Stack;

/**
 * @author 夏冬
 * @date 2022/7/13
 */
public class 表达式求值 {

    /**
     * + - * ( )
     */
    public int solve(String s) {
        // write code here

        //数栈
        Stack<Integer> numStack = new Stack<>();
        //操作栈 + - * ( )
        Stack<Character> opsStack = new Stack<>();

        char[] chars = s.toCharArray();

        int num = 0;

        for (int i = 0; i < chars.length; i++) {

            char cur = chars[i];

            //负号或减号
            if ('-' == cur) {





            }




        }


        return 0;
    }
}
