package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n){
        if (n == 0) return new ArrayList<>();
        return process(1, n);
    }

    private List<TreeNode> process(int start, int end){
        ArrayList<TreeNode> res = new ArrayList<>();
        if (start > end){
            res.add(null);
            return res;
        }

        for(int i = start; i <= end; i++){
            //当前节点的左子树集合
            List<TreeNode> left = process(start, i - 1);
            //当前节点的右子树集合
            List<TreeNode> right = process(i + 1, end);

            for(TreeNode t1 : left){
                for(TreeNode t2 : right){
                    TreeNode treeNode = new TreeNode(i, t1, t2);
                    res.add(treeNode);
                }
            }
        }
        return res;
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
