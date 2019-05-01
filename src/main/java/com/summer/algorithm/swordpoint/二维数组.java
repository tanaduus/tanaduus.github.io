package com.summer.algorithm.swordpoint;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class 二维数组 {

    public static boolean Find(int target, int[][] array) {

        if (array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length == 0) {
                continue;
            }
            int length = array[i].length;
            if (array[i][0] <= target && target <= array[i][length - 1]) {
                for (int j = 0; j < length; j++) {
                    if (array[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(7, array));
    }

}
