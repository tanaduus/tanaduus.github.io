package tanaduus.github.io.algorithm.array;

/**
 * @author 夏冬
 * @date 2022/6/22
 */
public class 二分查找 {

    public int search (int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int from = 0;
        int to = nums.length - 1;

        return find(nums, target, from, to);
    }

    private int find(int[] nums, int target, int from, int to) {

        if (from == to) {
            if (nums[from] == target) {
                return from;
            } else {
                return -1;
            }
        }


        if (nums[from] == target) {
            return from;
        }

        if (nums[to] == target) {
            return to;
        }

        if (from == to-1) {
            return -1;
        }

        int mid = (from + to) / 2;

        if (nums[mid] > target) {
            return find(nums, target, from, mid);
        }
        else if (nums[mid] == target) {
            return mid;
        } else {
            return find(nums, target, mid, to);
        }

    }
}
