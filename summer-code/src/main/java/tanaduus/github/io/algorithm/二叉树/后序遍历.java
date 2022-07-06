package tanaduus.github.io.algorithm.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 夏冬
 * @date 2022/7/4
 */
public class 后序遍历 {

    /**
     * 左右中
     *
     * left
     * right
     * root
     */
    public int[] postorderTraversal(TreeNode root) {
        // write code here

//            1
//         2     3
//        4 5   6 7
//
//
//        1 3
//
//
//        4 5 2 6 7 3 1

        if (root == null) {
            return new int[0];
        }

        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode node = root;
        st.push(node);

        while (node != null) {

            if (node.right != null) {
                st.push(node.right);
                node = node.right;
                continue;
            }

            if (node.left != null) {
                st.push(node.left);
                node = node.left;
                continue;
            }

        }

        int[] res = new int[list.size()];
        int index = 0;
        for (int a : list) {
            res[index++] = a;
        }
        return res;
    }
}
