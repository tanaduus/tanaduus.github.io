package tanaduus.github.io.algorithm.随机剑指;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 广度优先遍历
 */
public class 从上往下打印二叉树 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //保存结果
        ArrayList<Integer> resultList = new ArrayList<>();
        if(root==null){
            return resultList;
        }
        //临时队列
        Queue<TreeNode> tempQueue = new LinkedList<>();

        tempQueue.offer(root);
        resultList.add(root.val);

        while(!tempQueue.isEmpty()){
            TreeNode node = tempQueue.poll();
            if(node.left!=null){
                tempQueue.offer(node.left);
                resultList.add(node.left.val);
            }
            if(node.right!=null){
                tempQueue.offer(node.right);
                resultList.add(node.right.val);
            }
        }
        return resultList;
    }
}
