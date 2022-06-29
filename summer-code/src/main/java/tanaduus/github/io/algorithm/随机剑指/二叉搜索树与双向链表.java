package tanaduus.github.io.algorithm.随机剑指;

import java.util.ArrayList;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class 二叉搜索树与双向链表 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return pRootOfTree;
        }
        TreeNode result = transfer(pRootOfTree);
        while (result.left != null) {
            result = result.left;
        }
        return result;
    }

    /**
     * 二叉搜索树转有序双向链表
     */
    public static TreeNode transfer(TreeNode pRootOfTree) {

        if (pRootOfTree.left != null) {
            TreeNode left = transfer(pRootOfTree.left);
            while (left.right != null) {
                left = left.right;
            }
            left.right = pRootOfTree;
            pRootOfTree.left = left;
        }
        if (pRootOfTree.right != null) {
            TreeNode right = transfer(pRootOfTree.right);
            while (right.left != null) {
                right = right.left;
            }
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }

        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }

        return pRootOfTree;
    }

    public static ArrayList<Integer> list = new ArrayList<Integer>();

    /**
     * 中序遍历
     */
    public static void ConvertMid(TreeNode pRootOfTree) {

        if (pRootOfTree == null) {
            return;
        }

        if (pRootOfTree.left != null) {
            ConvertMid(pRootOfTree.left);
        } else {
            list.add(pRootOfTree.val);
            return;
        }

        list.add(pRootOfTree.val);

        if (pRootOfTree.right != null) {
            ConvertMid(pRootOfTree.right);
        } else {
            list.add(pRootOfTree.val);
        }

        return;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(14);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(8);
        TreeNode f = new TreeNode(12);
        TreeNode g = new TreeNode(16);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;

        TreeNode result = Convert(a);
        System.out.println(a);
//        ConvertMid(a);
//        list.forEach(System.out::println);
    }
}
