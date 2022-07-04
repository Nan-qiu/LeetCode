package leetcode.binaryTree;

public class SumOfRootToLeafBinaryNumbers {

    public int sumRootToLeaf(TreeNode root){
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int res){
        int ans = 0;
        if (root != null){
            ans += (res << 1) + root.val;
        } else return 0;
        if (root.left == null && root.right == null) return ans;
        return dfs(root.left, ans) + dfs(root.right, ans);
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




