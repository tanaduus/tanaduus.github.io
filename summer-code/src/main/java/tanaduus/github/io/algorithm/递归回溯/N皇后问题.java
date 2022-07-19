package tanaduus.github.io.algorithm.递归回溯;

/**
 * @author 夏冬
 * @date 2022/7/19
 */
public class N皇后问题 {

    public static void main(String[] args) {

        N皇后问题 tt = new N皇后问题();

        tt.Nqueen(9);
    }
    int count = 0;

    public int Nqueen (int n) {
        // write code here


        if (n==0) {
            return 0;
        }

        if (n==1) {
            return 1;
        }

        for (int column = 0; column<n; column++) {

            int[][] array = new int[n][n];

            isOk(array, 0, column);
        }

        return count;
    }

    private boolean isOk(int[][] array, int row, int column) {
        array[row][column] = 1;

        //递归找上面
        if(findUp(array, row, column)) {
            array[row][column] = 0;
            return false;
        }
        //递归找左上
        if(findUpAndLeft(array, row, column)) {
            array[row][column] = 0;
            return false;
        }
        //递归找右上
        if(findUpAndRight(array, row, column)) {
            array[row][column] = 0;
            return false;
        }

        //最后一行，能成
        if (row == array.length-1) {
            count++;
            return true;
        }

        for (int j=0; j<array[0].length; j++) {

            if (isOk(array, row+1, j)) {
                array[row+1][j] = 0;
            }
        }

        array[row][column] = 0;
        return false;
    }

    private boolean findUp(int[][] array, int row, int column){

        if (row > 0) {
            if (array[row-1][column] == 1) {
                return true;
            }

            return findUp(array, row-1, column);
        }

        return false;
    }

    private boolean findUpAndLeft(int[][] array, int row, int column){
        if (row > 0 && column >0) {
            if (array[row-1][column-1] == 1) {
                return true;
            }

            return findUpAndLeft(array, row-1, column-1);
        }

        return false;
    }

    private boolean findUpAndRight(int[][] array, int row, int column){
        if (row > 0 && column < array.length-1) {
            if (array[row-1][column+1] == 1) {
                return true;
            }

            return findUpAndRight(array, row-1, column+1);
        }

        return false;
    }
}
