package com.summer.algorithm.swordpoint;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class 重建二叉树 {

    static class test {
        public static void main(String[] args) {
            重建二叉树 a = new 重建二叉树();
            int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
            int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
            System.out.println(Arrays.toString(pre));
            System.out.println(Arrays.toString(in));
            a.reConstructBinaryTree(pre, in);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 把重建二叉树，分解为重建每个父-左子-右子的小二叉树
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }

        int root = pre[0];
        TreeNode rootNode = new TreeNode(root);

        getLeftAndRightChild(rootNode, pre, in);

        return rootNode;
    }

    public void getLeftAndRightChild(TreeNode rootNode, int[] pre, int[] in) {
        int[] leftChildPre = null;
        int[] leftChildIn = null;
        int[] rightChildPre = null;
        int[] rightChildIn = null;

        int leftLength = 0;
        int rightLength = 0;
        int fatherIndex = 0;

        for (int i = 0; i < in.length; i++) {
            if (rootNode.val == in[i]) {
                fatherIndex = i;
                leftLength = i;
                rightLength = in.length - i - 1;
                leftChildIn = new int[leftLength];
                leftChildPre = new int[leftLength];
                rightChildIn = new int[rightLength];
                rightChildPre = new int[rightLength];
            }
        }

        for (int i = 0; i < leftLength; i++) {
            leftChildIn[i] = in[i];
        }

        for (int i = 0; i < rightLength; i++) {
            rightChildIn[i] = in[i + fatherIndex + 1];
        }

        for (int i = 1, leftPreIndex = 0, rightPreIndex = 0; i < pre.length; i++) {
            boolean flag = false;

            for (int j = 0; j < leftChildIn.length; j++) {
                if (pre[i] == leftChildIn[j]) {
                    leftChildPre[leftPreIndex] = pre[i];
                    leftPreIndex++;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            for (int k = 0; k < rightChildIn.length; k++) {
                if (pre[i] == rightChildIn[k]) {
                    rightChildPre[rightPreIndex] = pre[i];
                    rightPreIndex++;
                    break;
                }
            }
        }

        if (leftLength != 0) {
            TreeNode leftChild = new TreeNode(leftChildPre[0]);
            rootNode.left = leftChild;
            getLeftAndRightChild(leftChild, leftChildPre, leftChildIn);
        }
        if (rightLength != 0) {
            TreeNode rightChild = new TreeNode(rightChildPre[0]);
            rootNode.right = rightChild;
            getLeftAndRightChild(rightChild, rightChildPre, rightChildIn);
        }
    }
}
