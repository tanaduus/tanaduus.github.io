package com.summer.algorithm.swordpoint;

/**
 * 大家都知道斐波那契数列，
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class 斐波那契数列 {
    /**
     * 直接递归
     */
    public int Fibonacci(int n) {
        int result = 0;
        if (n == 0) {
            result = 0;
        }
        if (n == 1) {
            result = 1;
        }
        if (n >= 2) {
            result = Fibonacci(n - 1) + Fibonacci(n - 2);
        }
        return result;
    }

    /**
     * 正向循环计算
     */
    public int Fibonacci2(int n) {
        int a = 1, b = 1, c = 0;
        if (n < 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            for (int i = 3; i <= n; i++) {
                c = a + b;
                b = a;
                a = c;
            }
            return c;
        }
    }
}
