package tanaduus.github.io.algorithm;

public class 快速排序 {

    /**
     * 快速排序
     *
     * @param targetArray
     * @param i           head
     * @param j           tail
     */
    static void quickSortMethod(int[] targetArray, int i, int j) {
        int head = i;
        int tail = j;

        if (i > j) {
            System.out.println("invalid parameters");
            return;
        }
        if (i == j) {
            return;
        }
        int baseNum = targetArray[i];
        boolean tailFirst = true;
        while (i < j) {
//            if(i==j){
//            }
            if (tailFirst) {
                if (baseNum > targetArray[j]) {
                    targetArray[i] = targetArray[j];
                    targetArray[j] = baseNum;
                    tailFirst = false;
                } else {
                    j--;
                }
            } else {
                if (baseNum < targetArray[i]) {
                    targetArray[j] = targetArray[i];
                    targetArray[i] = baseNum;
                    tailFirst = true;
                } else {
                    i++;
                }
            }
        }
        //i==j
        int newTail = i-1;
        int newHead = j+1;
        if(head<newTail) {
            quickSortMethod(targetArray, head, newTail);
        }
        if(tail>newHead) {
            quickSortMethod(targetArray, newHead, tail);
        }
    }

    public static void main(String[] args) {
        int[] testArray = {72,6,57,88,60,42,83,73,48,85};
        quickSortMethod(testArray,0,9);
        for(int i=0;i<testArray.length;i++){
            System.out.print(testArray[i]+" ");
        }
        int[] testArray2 = {0,6,57,88,60,42,83,73,48,85};
        quickSortMethod(testArray2,0,9);
        for(int i=0;i<testArray2.length;i++){
            System.out.print(testArray2[i]+" ");
        }
        int[] testArray3 = {72,6,57,88,60,42,83,73,48,100};
        quickSortMethod(testArray3,0,9);
        for(int i=0;i<testArray3.length;i++){
            System.out.print(testArray3[i]+" ");
        }
    }
}
