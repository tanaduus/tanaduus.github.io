package tanaduus.github.io.algorithm.递归回溯;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * @author 夏冬
 * @date 2022/7/18
 */
public class 有重复项数字的全排列 {


    public ArrayList<ArrayList<Integer>> permute(int[] num) {

        Arrays.sort(num);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        arrange(num, 0, result);

        return result;
    }

    private void arrange(int[] num, int arrangeStart, ArrayList<ArrayList<Integer>> result) {

        if (arrangeStart == num.length - 1) {

            ArrayList<Integer> numList = new ArrayList<>();
            for (int i : num) {
                numList.add(i);
            }

            result.add(numList);
            return;
        }


        Integer lastNum = null;
        for (int i = arrangeStart; i < num.length; i++) {

            //如果上一个锚点数字与当前所选锚点数字相同，则忽略
            if (lastNum != null && num[i] == lastNum) {
                continue;
            }

            int[] tempNum = new int[num.length];

            //将本数字移动到arrangeStart位置，其余数字依次后移
            for (int j = 0, k = 0; j < num.length; ) {

                if (k < arrangeStart) {
                    tempNum[k] = num[j];
                    j++;
                    k++;

                } else if (k == arrangeStart) {
                    tempNum[k] = num[i];
                    k++;
                } else if (k > arrangeStart) {

                    if (j == i) {

                        j++;
                    } else {

                        tempNum[k] = num[j];
                        j++;
                        k++;
                    }
                }
            }

            lastNum = num[i];

            arrange(tempNum, arrangeStart + 1, result);
        }
    }
}
