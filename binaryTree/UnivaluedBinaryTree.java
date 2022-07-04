package leetcode.binaryTree;

import java.util.Stack;

public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        int tem = -1;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                if (tem == -1) tem = root.val;
                else{
                    if (root.val != tem) return false;
                }
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return true;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){
        }

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}



