package leetcode.binaryTree;

import java.util.Stack;

public class StepByStepDirectionsFromBinaryTreeNodeToAnother {
    public static String getDirections(TreeNode root,int startValue,int destValue){
        if (root == null) return null;
        TreeNode start = null; //开始的位置
        TreeNode end = null; // 结束的位置
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode find = root; //寻找节点的节点
        stack.push(find);
        while (!stack.isEmpty()) {
            find = stack.pop();
            //做操作
            if (find.val == startValue) start = find;
            if (find.val == destValue) end = find;
            if (start != null && end != null) break;
            if (find.right != null){
                stack.push(find.right);
            }
            if (find.left != null){
                stack.push(find.left);
            }
        }
        //--------开始寻找最近公共祖先-----------------
        return  null;
    }

    public void Dfs(TreeNode root){ //深度优先遍历
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            //做操作
            if (root.right != null){
                stack.push(root.right);
            }
            if (root.left != null){
                stack.push(root.left);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){
        }

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
