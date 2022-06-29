package tanaduus.github.io.algorithm.理论;

/**
 * @author 夏冬
 * @date 2022/6/28
 */
public class 动态规划求背包1 {

    public static void main(String[] args) {

        int[] items = {2, 2, 4, 6, 3};

        System.out.println(knapsack2(items, 5, 9));
    }


    /**
     * 用1维数组保存经过一层之后，可能的背包状态
     * <p>
     * 逐层计算完之后，就得到所有可能的背包状态
     * <p>
     * 在里面可以取出最大值，作为最优解
     */
    public static int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w + 1]; // 默认值false

        //第一层特殊处理
        states[0] = true;
        if (items[0] <= w) {
            states[items[0]] = true;
        }

        //从第二层开始，进行迭代
        for (int i = 1; i < n; i++) {
            //1、不选择该层物品加入背包，什么都不用做
            //。。。

            //2、选择该层物品加入背包
//            for (int j = 0; j <= w; j++) {
//
//                //从小到大时，存在重复计算问题
//                if (states[j] && j + items[i] <= w) {
//                    System.out.println(j + items[i]);
//                    states[j + items[i]] = true;
//                }
//            }

            for (int j = w - items[i]; j >= 0; --j) {
                //把第i个物品放入背包
                if (states[j]) {
                    System.out.println(j + items[i]);
                    states[j + items[i]] = true;
                }
            }
        }

        for (int k = w; k >= 0; k--) {
            if (states[k]) {
                return k;
            }
        }

        return 0;
    }
}
