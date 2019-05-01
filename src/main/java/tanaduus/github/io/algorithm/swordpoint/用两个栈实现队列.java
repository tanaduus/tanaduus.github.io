package tanaduus.github.io.algorithm.swordpoint;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 * <p>
 * 栈：先进后出
 * 队列：先进先出
 * <p>
 * 队列：1，2，3
 * 栈1：1入，2入
 * 栈2：2进，1进
 */
public class 用两个栈实现队列 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                int a = stack1.peek();
                stack1.pop();
                stack2.push(a);
            }
        }
        int result = stack2.peek();
        stack2.pop();
        return result;
    }
}
