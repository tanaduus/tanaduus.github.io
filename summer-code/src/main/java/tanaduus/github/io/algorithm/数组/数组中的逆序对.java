package tanaduus.github.io.algorithm.数组;

/**
 * @author 夏冬
 * @date 2022/6/22
 */
public class 数组中的逆序对 {

    /**
     * 归并排序
     */
    public int InversePairs(int[] array) {

        if (array.length == 0) {
            return 0;
        }


        return 0;
    }

    private void mergeSort(int[] array, int from, int to) {

        if (from >= to) {
            return;
        }

        int mid = (array.length - 1) / 2;

        //分成两个数组分表排序后，进行合并
        mergeSort(array, 0, mid);
        mergeSort(array, mid + 1, array.length - 1);

        int[] temp = new int[array.length - 1];
        //合并
        for (int i = 0; i <= mid; i++) {

        }
    }
}
