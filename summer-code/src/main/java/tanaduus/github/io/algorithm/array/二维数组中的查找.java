package tanaduus.github.io.algorithm.array;

/**
 * @author 夏冬
 * @date 2022/6/22
 */
public class 二维数组中的查找 {

    /**
     * （每个一维数组的长度相同）
     * <p>
     * [
     * [1,2,8,9],
     * [2,4,9,12],
     * [4,7,10,13],
     * [6,8,11,15]
     * ]
     * <p>
     * 解题思路： 左下角特性：往上比自己小，往右比自己大。那么从左下角开始检索也不错
     */
    public boolean Find1(int target, int[][] array) {

        int height = array.length;
        int length = array[0].length;

        int findHight = height - 1;
        int findLength = 0;

        //界内搜索
        while (findHight >= 0 && findLength <= length - 1) {

            if (target < array[findHight][findLength]) {
                findHight--;
            } else if (target == array[findHight][findLength]) {
                return true;
            } else {
                findLength++;
            }
        }

        return false;
    }

    /**
     * [
     * [1,2,8,9],
     * [2,4,9,12],
     * [4,7,10,13],
     * [6,8,11,15]
     * ]
     * <p>
     * 解题思路： 每一个子部分，都呈现出左上角最小，左下角最大的特性。可以进行十字分割
     */
    public boolean Find2(int target, int[][] array) {


        return false;
    }
}
