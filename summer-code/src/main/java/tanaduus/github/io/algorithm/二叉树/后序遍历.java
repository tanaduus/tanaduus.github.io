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
     * <p>
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

        st.push(root);

        TreeNode pre = null;//用来记录已经遍历过的子树
        while (!st.isEmpty()) {

            while (root.left != null) {
                st.push(root.left);
                root = root.left;
            }

            if (st.isEmpty()) {
                break;
            }
            TreeNode node = st.peek();

            if (node.right == null) {

                st.pop();//作为最左子弹出 or 作为右子树弹出
                list.add(node.val);

                pre = node;//作为右子树弹出，需要记录自己防止再次进入

            } else {

                if (node.right == pre) {
                    //曾经进入过右子，自己作为根直接弹出
                    st.pop();
                    list.add(node.val);

                    pre = node;//作为右子树弹出，需要记录自己防止再次进入
                } else {
                    st.push(node.right);
                    root = node.right;
                }
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
