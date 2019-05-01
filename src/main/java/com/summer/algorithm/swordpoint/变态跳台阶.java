package com.summer.algorithm.swordpoint;

import java.util.ArrayList;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * 第一次跳跃：
 * 1-->f(n-1)
 * 2-->f(n-2)
 * ...
 * ...
 * n-->f(n-n)=1
 * <p>
 * 汇总：
 * f(n)=f(0)+f(1)+f(2)+...+f(n-1)
 * <p>
 * 进阶：
 * ∵f(n-1)=f(0)+f(1)+...f(n-2)
 * ∴f(n)=2*f(n-1)
 */
public class 变态跳台阶 {
    ArrayList<Integer> list = new ArrayList<>();

    /**
     * 简单汇总 f(n)=f(0)+f(1)+f(2)+...+f(n-1)
     */
    public int JumpFloorII(int target) {

        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        list.add(1);
        list.add(1);
        list.add(2);
        for (int i = 3; i < target; i++) {
            list.add(getSum());
        }
        return getSum();
    }

    int getSum() {
        int result = 0;
        for (Integer i : list) {
            result += i;
        }
        return result;
    }

    /**
     * 进阶 f(n)=2*f(n-1)
     */
    public int upgradeJump(int target) {
        if (target == 1) {
            return 1;
        }
        return 2 * upgradeJump(target - 1);
    }


}
