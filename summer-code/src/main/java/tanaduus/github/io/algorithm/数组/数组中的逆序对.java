package tanaduus.github.io.algorithm.数组;

/**
 * @author 夏冬
 * @date 2022/6/22
 */
public class 数组中的逆序对 {

    /**
     * 归并排序求解逆序对
     */
    public int InversePairs(int[] array) {

        if (array.length == 0) {
            return 0;
        }

        return mergeSort(array, 0, array.length - 1);
    }

    private int mergeSort(int[] array, int from, int to) {

        if (from >= to) {
            return 0;
        }

        int mid = (from + to) / 2;

        //分成两个数组分别排序后，进行合并
        int leftR = mergeSort(array, from, mid);
        int rightR = mergeSort(array, mid + 1, to);

        int[] temp = new int[to - from + 1];
        //合并
        int currentR = 0;

        int i = from, j = mid + 1;
        int base = 0;
        //todo 计算逆序数量，需要暂存一些基数。下次想想
        for (int k = 0; k < temp.length; k++) {

            if (i <= mid && j <= to) {
                int left = array[i];
                int right = array[j];

                if (left <= right) {
                    temp[k] = left;

                    i++;
                } else {
                    temp[k] = right;

                    currentR++;

                    j++;
                }
            } else if (i <= mid && j > to) {
                temp[k] = array[i];

                i++;
            } else if (i > mid && j <= to) {
                temp[k] = array[j];

                j++;
            }


        }

        return currentR + leftR + rightR;
    }
}
