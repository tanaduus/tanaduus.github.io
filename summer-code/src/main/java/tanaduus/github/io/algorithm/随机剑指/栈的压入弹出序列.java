package tanaduus.github.io.algorithm.随机剑指;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class 栈的压入弹出序列 {

    static Stack<Integer> stack = new Stack<>();

    public static boolean IsPopOrder2(int[] pushA, int[] popA) {
        if (pushA == null || pushA.length == 0 || popA == null || popA.length == 0) {
            return false;
        }
        if (pushA.length != popA.length) {
            return false;
        }

        for (int i = 0; i < popA.length; ) {
            if (stack.empty()) {
                int j = 0;
                while (pushA[j] < popA[i]) {
                    stack.push(pushA[j]);
                    j++;
                }
                continue;
            } else {
                if (popA[i] > stack.peek()) {
                    i++;
                    continue;
                } else if (popA[i] == stack.peek()) {
                    stack.pop();
                    i++;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        for(int i=0,j=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(j<popA.length&&stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int[] b={4,5,3,2,1};
        int[] c = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(a, b));
        System.out.println(IsPopOrder(a, c));
    }
}
