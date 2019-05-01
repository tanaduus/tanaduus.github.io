package com.summer.algorithm.swordpoint;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * <p>
 * 斐波那契数列
 * 1-1
 * 2-2
 * 3-3
 * 4-5
 * 5-8
 * <p>
 * 思路：
 * 假定f(n)为跳n级台阶的可能性数量(假设n>2)
 * 那么，如果第一次只跳了1级，可能性就是f(n-1);
 * 如果第一次跳了2级，可能性就是f(n-2);
 * 总可能性就是f(n)=f(n-1)+f(n-2)
 */
public class 跳台阶 {
    public int JumpFloor(int target) {
        //f(n)=f(n-1)+f(n-2)
        return 0;
    }
}
