package leetcode.binaryTree;

import java.util.Stack;

public class SuccessorLCCI {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        Stack<TreeNode> stack = new Stack<>();
        boolean flag = false;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (flag) return root;
            if (root.val == p.val) flag = true;
            root = root.right;
        }
        return null;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }

}
