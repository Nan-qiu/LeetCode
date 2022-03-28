package leetcode.binaryTree;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root){
        StringBuilder builder = new StringBuilder();
        dfs(root,builder);
        return builder.toString();
    }

    private void dfs1(TreeNode root,StringBuilder builder){
        if (root == null) return;
        builder.append(root.val);
        if (root.right == null && root.left == null) return;

        //左节点为不为空都要处理
        builder.append("(");
        dfs(root.left,builder);
        builder.append(")");

        //右节点只有不为空才处理
        if (root.right!=null){
            builder.append("(");
            dfs(root.right,builder);
            builder.append(")");
        }
    }

    //我是sb
    private void dfs(TreeNode root,StringBuilder builder){
        if (root == null) return;
        builder.append(root.val);
        if (root.right == null && root.left == null) return;
        if (root.left != null){
            builder.append("(");
            dfs(root.left,builder);
            builder.append(")");
        }
        if (root.left == null && root.right != null){
            builder.append("()(");
            dfs(root.right,builder);
            builder.append(")");
        } else if (root.right != null){
            builder.append("(");
            dfs(root.right,builder);
            builder.append(")");
        }
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
