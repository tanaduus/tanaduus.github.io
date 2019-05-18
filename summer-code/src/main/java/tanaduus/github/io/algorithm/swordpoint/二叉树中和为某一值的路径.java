package tanaduus.github.io.algorithm.swordpoint;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 * 。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class 二叉树中和为某一值的路径 {
    //        深度遍历
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//
//        while(!stack.isEmpty()){
//            TreeNode t = stack.pop();
//            if(t.right!=null){
//                stack.push(t.right);
//            }
//            if(t.left!=null){
//                stack.push(t.left);
//            }
//        }
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if(root==null||root.val>target){
            return lists;
        }

        if(root.val==target){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            lists.add(list);
            return lists;
        }

        find(root,target,null);

        return this.lists;
    }

    private void find(TreeNode node,int target,ArrayList<Integer> list){
        if(list==null){
            list = new ArrayList<>();
        }
        if(node.left!=null){
            if(node.val+node.left.val==target&&node.left.left==null&&node.left.right==null){
                ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();
                list2.add(node.val);
                list2.add(node.left.val);
                lists.add(list2);
            }else if(node.val+node.left.val<target){
                ArrayList<Integer> list3 = (ArrayList<Integer>) list.clone();
                list3.add(node.val);
                find(node.left,target-node.val,list3);
            }
        }

        if(node.right!=null){
            if(node.val+node.right.val==target&&node.right.left==null&&node.right.right==null){
                ArrayList<Integer> list4 = (ArrayList<Integer>) list.clone();
                list4.add(node.val);
                list4.add(node.right.val);
                lists.add(list4);
            }else if(node.val+node.right.val<target){
                ArrayList<Integer> list5 = (ArrayList<Integer>) list.clone();
                list5.add(node.val);
                find(node.right,target-node.val,list5);
            }
        }
    }

}

