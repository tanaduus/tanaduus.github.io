package tanaduus.github.io.algorithm.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 夏冬
 * @date 2022/7/4
 */
public class 中序遍历 {


    /**
     * 左中右
     */
    public int[] inorderTraversal(TreeNode root) {
        // write code here

        Stack<TreeNode> st = new Stack<>();

        if (root == null) {
            return new int[0];
        }

        st.push(root);


        List<Integer> list = new ArrayList<>();

        while (!st.isEmpty()) {

            TreeNode node = st.peek();

            while (node.left != null) {
                st.push(node.left);

                node = node.left;
            }

            while (node.right == null) {
                st.pop();
                list.add(node.val);

                if (st.isEmpty()) {
                    break;
                }

                node = st.peek();
            }

            if (st.isEmpty()) {
                break;
            }

            st.pop();
            list.add(node.val);

            st.push(node.right);
        }


        int[] res = new int[list.size()];
        int index = 0;
        for (int a : list) {
            res[index++] = a;
        }
        return res;
    }

    public int[] inorderTraversal2(TreeNode root) {
        // write code here
        if (root == null) {
            return new int[]{};
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            list.add(p.val);
            p = p.right;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
