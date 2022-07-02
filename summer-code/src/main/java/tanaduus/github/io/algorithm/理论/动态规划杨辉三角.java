package tanaduus.github.io.algorithm.理论;

/**
 * 三角形最小路径和
 * <p>
 * 题目：往下移动，我们把移动到最底层所经过的所有数字之和，定义为路径的长度。请你编程求出从最高层移动到最底层的最短路径长度
 * <p>
 * 思路：
 * n为层，m为从左至右的索引，都从0开始，则m<= n，
 * 设f(n,m)为到达该点的最短路径，那么有如下公式成立：
 * f(n,m) = Math.min( f(n-1, m-1), f(n-1,m) ) + this.value
 * 后面进行动态即可
 *
 * @author 夏冬
 * @date 2022/6/29
 */
public class 动态规划杨辉三角 {

    public int minTrace(int[][] triangle) {
        int size = triangle.length;

        int[][] status = new int[size][size];

        status[0][0] = triangle[0][0];//第一个先计算好

        if (size == 1) {
            return status[0][0];
        }

        for (int n = 1; n < size; n++) {
            for (int m = 0; m <= n; m++) {

                int leftP = -1;
                int rightP = -1;

                if (m > 0) {
                    leftP = status[n - 1][m - 1];
                }

                if (m < n) {
                    rightP = status[n - 1][m];
                }

                if (leftP == -1) leftP = rightP;
                if (rightP == -1) rightP = leftP;

                status[n][m] = Math.min(leftP, rightP) + triangle[n][m];
            }
        }

        int minV = status[size - 1][0];

        for (int i = 1; i < size - 1; i++) {

            minV = Math.min(minV, status[size - 1][i]);
        }

        return minV;
    }
}
