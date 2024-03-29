package tanaduus.github.io.algorithm.随机剑指;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * <p>
 * 其他解法：打印完第一行，数组逆时针转90度，继续打印第一行，然后重复上述操作
 */
public class 顺时针打印矩阵 {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        //行数
        int row = matrix.length;
        //列数
        int collor = matrix[0].length;
        //计算打印的圈数
        //圈数
        int circle = ((row < collor ? row : collor) - 1) / 2 + 1;
        for (int i = 0; i < circle; i++) {
            //从左向右打印
            for (int j = i; j < collor - i; j++) {
                res.add(matrix[i][j]);
            }
            //从上往下的每一列数据
            for (int k = i + 1; k < row - i; k++) {
                res.add(matrix[k][collor - 1 - i]);
            }
            //判断是否会重复打印(从右向左的每行数据)
            for (int m = collor - i - 2; (m >= i) && (row - i - 1 != i); m--) {
                res.add(matrix[row - i - 1][m]);
            }
            //判断是否会重复打印(从下往上的每一列数据)
            for (int n = row - i - 2; (n > i) && (collor - i - 1 != i); n--) {
                res.add(matrix[n][i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] target = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList list = printMatrix(target);
        list.forEach(e -> System.out.print(e + " "));
    }
}
