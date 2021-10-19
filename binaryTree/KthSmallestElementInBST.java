package leetcode.binaryTree;

import java.util.Stack;

public class KthSmallestElementInBST { //中序遍历搜索二叉树就是从小到大的有序排列
    public static int kthSmallest(TreeNode root,int k){
        int i = 0;
        Stack<TreeNode> stack = new Stack<>();
        if (root != null){
            while (!stack.isEmpty() || root != null) {
                if (root != null){ // 先把当前节点的左边界全部放到栈里，root==null时，弹出一个节点，root=root的右子树
                    stack.push(root);
                    root = root.left;
                } else{ // 在右子树上再把左边界放栈，循环
                    root = stack.pop();
                    if (++i == k){
                        return root.val;
                    }
                    root = root.right;
                }
            }
        }
        return i;
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
