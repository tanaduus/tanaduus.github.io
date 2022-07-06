package tanaduus.github.io.algorithm.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 夏冬
 * @date 2022/7/4
 */
public class 前序遍历 {

    /**
     * 中左右
     */
    public int[] preorderTraversal(TreeNode root) {
        // write code here

//         1
//         2 3
//         4 5 6 7

//         1 2 4 5 3 6 7

        if (root == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while (st.size() > 0) {

            TreeNode t = st.pop();
            list.add(t.val);

            if (t.right != null) {
                st.push(t.right);
            }

            if (t.left != null) {
                st.push(t.left);
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
