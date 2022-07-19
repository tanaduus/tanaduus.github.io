package tanaduus.github.io.algorithm.堆栈队列;

/**
 * @author 夏冬
 * @date 2022/7/13
 */
public class 寻找第K大 {

    public void swap(int[] arr, int a, int b) {
        if (a == b) return;
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }

    public int partition(int[] a, int l, int r) {
        swap(a, l + r >> 1, r);
        int pv = a[r];
        int i = r;
        while (i > l) {
            while (i > l && a[l] > pv) l++;
            while (i > l && a[i] <= pv) i--;
            swap(a, l, i);
        }
        swap(a, r, i);
        return i;
    }

    public void quickSort(int[] a, int l, int r, int k) {
        if (l >= r) return;
        int p = partition(a, l, r);
        if (p == k - 1) return;
        else if (l + 1 == r && (p == k || p == k - 2)) return;
        else if (p > k - 1) {
            quickSort(a, l, p - 1, k);
        } else {
            quickSort(a, p + 1, r, k);
        }
    }

    public int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a, 0, n - 1, K);
        return a[K - 1];
    }
}
