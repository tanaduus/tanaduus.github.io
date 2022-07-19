package tanaduus.github.io.algorithm.递归回溯;

/**
 * @author 夏冬
 * @date 2022/7/19
 */
public class 岛屿数量 {

    public int solve (char[][] grid) {
        // write code here

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j< grid[0].length; j++) {

                char cur = grid[i][j];

                if ('1' == cur) {
                    result++;

                    findAndReset(grid, i, j);
                }
            }
        }

        return result;
    }

    private void findAndReset(char[][] grid, int i, int j) {

        grid[i][j] = '0';

        //up
        if (i > 0 && '1' == grid[i-1][j]) {
            findAndReset(grid, i-1, j);
        }

        //down
        if (i+1 < grid.length && '1' == grid[i+1][j]) {
            findAndReset(grid, i + 1, j);
        }

        //left
        if (j > 0 && '1' == grid[i][j-1]) {
            findAndReset(grid, i, j - 1);
        }

        //right
        if (j+1 < grid[0].length && '1' == grid[i][j+1]) {
            findAndReset(grid, i, j + 1);
        }
    }
}
