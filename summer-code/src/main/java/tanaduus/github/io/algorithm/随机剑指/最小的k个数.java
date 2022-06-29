package tanaduus.github.io.algorithm.随机剑指;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * <p>
 * 思路：创建k长度的数组，输入数组逐个进入进行比较替换，并保持顺序性。
 * <p>
 * 补充：可以直接使用优先级队列{@link java.util.PriorityQueue}
 */
public class 最小的k个数 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        if (k == 0 || input.length < k) {
            return new ArrayList<>();
        }

        ArrayList<Integer> resultList = new ArrayList<>(k);


        for (int i = 0; i < input.length; i++) {
            addToResultList(resultList, k, input[i]);
        }

        return resultList;
    }

    private void addToResultList(ArrayList<Integer> resultList, int k, int param) {

        if (resultList.size() == 0) {
            resultList.add(param);
            return;
        }

        //个数小于k，直接插入至有序数组对应位置
        if (resultList.size() < k) {
            for (int m = 0; m < resultList.size(); m++) {
                if (resultList.get(m) > param) {
                    resultList.add(m, param);
                    return;
                }
            }
            resultList.add(param);
            return;
        }

        //个数等于k，直接插入至有序数组对应位置，并删除最后一个
        if (resultList.size() == k) {
            for (int m = 0; m < resultList.size(); m++) {
                if (resultList.get(m) > param) {
                    resultList.add(m, param);
                    resultList.remove(k);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        最小的k个数 a = new 最小的k个数();
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};

        ArrayList<Integer> resultList = a.GetLeastNumbers_Solution(input, 4);

        resultList.forEach(System.out::println);
    }

}
