package tanaduus.github.io.algorithm.随机剑指;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * <p>
 * 栈的特性：先进后出
 * 那么入栈顺序
 * 3，2，4，5，1
 * 则辅助栈的入栈为
 * 3，2，1
 */
public class 包含min函数的栈 {

    private Stack<Integer> localStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        localStack.push(node);
        int min;
        if (!minStack.empty()) {
            min = minStack.peek();
            if (node < min) {
                minStack.push(node);
            }
        } else {
            minStack.push(node);
        }
    }

    public void pop() {
        if(!localStack.empty()) {
            int peek = localStack.peek();
            localStack.pop();
            if(peek==minStack.peek()){
                minStack.pop();
            }
        }
    }

    public int top() {
        return localStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
