package com.summer.algorithm.swordpoint;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * <p>
 * 分解：
 * 最小单元有两种情况
 * 1，一个竖
 * 2，两个横
 * <p>
 * 思路：
 * 设f(n)为n个2*1小矩形填满大矩形的可能性的种数
 * 假如第一次放一个竖，则有f(n-1)种可能性
 * 假如第一次放两个横，则有f(n-2)种可能性
 * 所以f(n)=f(n-1)+f(n-2)
 * <p>
 * 显然，还是一个斐波那契数列
 */
public class 矩形覆盖 {

    public int RectCover(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        int result = 0;
        int prePre = 1;
        int pre = 2;
        for (int i = 3; i <= target; i++) {
            result = prePre + pre;
            prePre = pre;
            pre = result;
        }
        return result;
    }
}
