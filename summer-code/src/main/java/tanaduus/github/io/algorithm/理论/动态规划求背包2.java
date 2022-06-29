package tanaduus.github.io.algorithm.理论;

/**
 * @author 夏冬
 * @date 2022/6/29
 */
public class 动态规划求背包2 {

    private static int[] items = {2, 2, 4, 6, 3}; // 物品的重量
    private static int[] value = {3, 4, 8, 9, 6}; // 物品的价值
    private static int n = 5; // 物品个数
    private static int w = 9; // 背包承受的最大重量

    public static void main(String[] args) {

        int v = knapsack3(items, value, n, w);
        System.out.println(v);
    }

    /**
     * @param weight 重量
     * @param value  价值
     * @param n      物品index
     * @param w      重量上限
     * @return
     */
    public static int knapsack3(int[] weight, int[] value, int n, int w) {

        //假设该数组：记录该层该重量的最大价值
        int[][] status = new int[n][w + 1];

        //0不装
        status[0][0] = 0;
        //0装入
        if (weight[0] <= w) {
            status[0][weight[0]] = value[0];
        }

        for (int i = 1; i < n; i++) {

            //不装
            for (int j = 0; j < w + 1; j++) {

                if (status[i - 1][j] > 0) {
                    status[i][j] = status[i - 1][j];
                }
            }

            //装入
            for (int j = 0; j + weight[i] < w + 1; j++) {
                status[i][j + weight[i]] = Math.max(status[i][j + weight[i]], status[i - 1][j] + value[i]);
            }
        }

        //找出最大value，一定在n-1层里面
        int maxValue = 0;
        for (int j = 0; j < w + 1; j++) {
            if (status[n - 1][j] > maxValue) {
                maxValue = status[n - 1][j];
            }
        }

        return maxValue;
    }
}
