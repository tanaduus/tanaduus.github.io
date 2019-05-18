package tanaduus.github.io.algorithm.swordpoint;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 奇数在偶数前 {
    public static void reOrderArray(int [] array) {
        for(int i=0;i<array.length;i++){
            //1,2,4,6,7,8,9
            //1,7,2,4,6,8,9
            //1,7,9,2,4,6,8
            if(isEven(array[i])){
                for(int j=i+1;j<array.length;j++){
                    if(!isEven(array[j])){
                        int temp = array[i];
                        array[i] = array[j];
                        int temp2=0;
                        for(int k=i+1;k<=j;k++){
                            temp2 = array[k];
                            array[k]=temp;
                            temp = temp2;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 是否是偶数
     */
    static boolean isEven(int target){
        if(target%2==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test ={1,2,4,6,7,8,9};
        reOrderArray(test);
    }
}
