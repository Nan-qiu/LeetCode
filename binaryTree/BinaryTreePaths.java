package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs("",root,res);
        return res;

    }

    private void dfs(String path,TreeNode root,List<String> res){
        if (root==null) return;
        StringBuffer stringBuffer = new StringBuffer(path);
        stringBuffer.append(root.val);
        if (root.left==null&&root.right==null){
            res.add(stringBuffer.toString());
        }else {
            stringBuffer.append("->");
            dfs(stringBuffer.toString(),root.left,res);
            dfs(stringBuffer.toString(),root.right,res);
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

