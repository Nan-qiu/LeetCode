package leetcode.binaryTree;

import java.util.HashSet;
import java.util.Stack;

public class TwoSumIVInputisaBST {

    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget1(TreeNode root,int k){
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return findTarget1(root.left,k) || findTarget1(root.right,k);
    }


    //I'm nt
    public boolean findTarget(TreeNode root,int k){
        Stack<TreeNode> outStack = new Stack<>();
        Stack<TreeNode> inStack = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>();
        int out = 0;
        int in = 0;
        outStack.push(root);

        while (!outStack.isEmpty()) {
            TreeNode pop = outStack.pop();
            out = pop.val;
            set.add(pop);
            inStack.push(root);
            while (!inStack.isEmpty()) {
                TreeNode inPop = inStack.pop();
                in = inPop.val;
                if (!set.contains(inPop)){
                    if (out + in == k) return true;
                }
                if (inPop.left != null) inStack.push(inPop.left);
                if (inPop.right != null) inStack.push(inPop.right);
            }
            if (pop.left != null) outStack.push(pop.left);
            if (pop.right != null) outStack.push(pop.right);
        }

        return false;
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

        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
