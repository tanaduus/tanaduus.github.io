package tanaduus.github.io.algorithm.随机剑指;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class 连续子数组的最大和 {

    /**
     * 该题目思路:
     * f(n)表示结果；
     * 定义一个数组dp，dp[i]表示以元素array[i]结尾的最大连续子数组和；
     * 那么：f(n)=max(dp)   (dp长度为n)
     * <p>
     * 以[-2,-3,4,-1,-2,1,5,-3]为例
     * 可以发现,
     * dp[0] = -2
     * dp[1] = -3
     * dp[2] = 4
     * dp[3] = 3
     * 以此类推,会发现
     * dp[i] = max{dp[i-1]+array[i],array[i]}.
     * <p>
     * 最后，取dp数组中的最大值
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int n = array.length;
        int[] dp = new int[n];

        int max = array[0];

        for (int i = 0; i < n; i++) {
            int now = getDp(array, dp, i);

            max = max > now ? max : now;
        }


        return max;
    }

    private int getDp(int[] array, int[] dp, int index) {
        if (index == 0) {
            dp[index] = array[0];
            return array[0];
        }

        int r = array[index] + getDp(array, dp, index - 1) > array[index] ?
                array[index] + getDp(array, dp, index - 1) :
                array[index];

        dp[index] = r;
        return r;
    }

    public static void main(String[] args) {
        int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};

        连续子数组的最大和 test = new 连续子数组的最大和();

        test.FindGreatestSumOfSubArray(array);
    }
}
